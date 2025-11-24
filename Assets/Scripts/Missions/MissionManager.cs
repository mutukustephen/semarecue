using UnityEngine;
using System.Collections.Generic;

namespace MojaveWild.Missions
{
    /// <summary>
    /// Manages mission lifecycle, generation, and completion
    /// Coordinates between mission types and player progress
    /// </summary>
    public class MissionManager : MonoBehaviour
    {
        [Header("Current Mission")]
        public Mission currentMission;
        public bool hasMission = false;

        [Header("Mission Settings")]
        public float missionGenerationInterval = 300f; // 5 minutes
        public int maxActiveMissions = 3;

        [Header("Completed Missions")]
        private List<string> completedMissionIds = new List<string>();

        private MissionGenerator generator;
        private float timeSinceLastGeneration = 0f;
        private Core.DatabaseManager db;

        private void Start()
        {
            db = Core.GameManager.Instance.databaseManager;
            generator = GetComponent<MissionGenerator>();
            
            if (generator == null)
            {
                generator = gameObject.AddComponent<MissionGenerator>();
            }

            LoadCompletedMissions();
        }

        private void Update()
        {
            // Auto-generate missions if none active
            if (!hasMission)
            {
                timeSinceLastGeneration += Time.deltaTime;
                
                if (timeSinceLastGeneration >= missionGenerationInterval)
                {
                    GenerateNewMission();
                    timeSinceLastGeneration = 0f;
                }
            }

            // Update current mission
            if (hasMission && currentMission != null)
            {
                currentMission.UpdateMission();

                if (currentMission.isCompleted)
                {
                    CompleteMission();
                }
                else if (currentMission.isFailed)
                {
                    FailMission();
                }
            }
        }

        public void GenerateNewMission()
        {
            if (generator == null) return;

            currentMission = generator.GenerateMission();
            
            if (currentMission != null)
            {
                hasMission = true;
                currentMission.StartMission();
                Debug.Log($"New mission generated: {currentMission.missionName}");
                
                // Update player's current mission
                Player.PlayerController player = FindObjectOfType<Player.PlayerController>();
                if (player != null)
                {
                    player.currentMissionId = currentMission.missionId;
                }
            }
        }

        public void StartMission(Mission mission)
        {
            if (hasMission)
            {
                Debug.LogWarning("Already have an active mission!");
                return;
            }

            currentMission = mission;
            hasMission = true;
            currentMission.StartMission();
            Debug.Log($"Started mission: {mission.missionName}");
        }

        private void CompleteMission()
        {
            if (currentMission == null) return;

            Debug.Log($"Mission completed: {currentMission.missionName}");
            Debug.Log($"Reward: {currentMission.experienceReward} XP");

            // Give rewards
            Player.PlayerController player = FindObjectOfType<Player.PlayerController>();
            if (player != null)
            {
                player.AddExperience(currentMission.experienceReward);
            }

            // Save to database
            SaveCompletedMission(currentMission);

            // Unlock encyclopedia entries
            UnlockMissionEncyclopediaEntries(currentMission);

            // Clear current mission
            completedMissionIds.Add(currentMission.missionId);
            currentMission = null;
            hasMission = false;
        }

        private void FailMission()
        {
            if (currentMission == null) return;

            Debug.Log($"Mission failed: {currentMission.missionName}");
            
            currentMission = null;
            hasMission = false;
        }

        public void AbandonMission()
        {
            if (currentMission != null)
            {
                Debug.Log($"Mission abandoned: {currentMission.missionName}");
                currentMission = null;
                hasMission = false;
            }
        }

        private void SaveCompletedMission(Mission mission)
        {
            if (db == null) return;

            Core.CompletedMission completedMission = new Core.CompletedMission
            {
                missionId = mission.missionId,
                completionTime = System.DateTimeOffset.UtcNow.ToUnixTimeSeconds(),
                score = mission.experienceReward
            };

            db.SaveCompletedMission(completedMission);
        }

        public void LoadCompletedMissions()
        {
            if (db == null) return;

            Core.CompletedMission[] missions = db.LoadCompletedMissions();
            completedMissionIds.Clear();

            foreach (Core.CompletedMission mission in missions)
            {
                completedMissionIds.Add(mission.missionId);
            }

            Debug.Log($"Loaded {completedMissionIds.Count} completed missions");
        }

        private void UnlockMissionEncyclopediaEntries(Mission mission)
        {
            if (db == null || mission.encyclopediaUnlocks == null) return;

            foreach (string entryId in mission.encyclopediaUnlocks)
            {
                db.UnlockEncyclopediaEntry(entryId);
            }
        }

        public bool IsMissionCompleted(string missionId)
        {
            return completedMissionIds.Contains(missionId);
        }

        public int GetCompletedMissionCount()
        {
            return completedMissionIds.Count;
        }
    }

    /// <summary>
    /// Base class for all missions
    /// </summary>
    [System.Serializable]
    public abstract class Mission
    {
        public string missionId;
        public string missionName;
        public string description;
        public MissionType type;
        public int experienceReward = 100;
        public float timeLimit = 600f; // 10 minutes
        public string[] encyclopediaUnlocks;

        public bool isActive = false;
        public bool isCompleted = false;
        public bool isFailed = false;
        
        protected float elapsedTime = 0f;

        public virtual void StartMission()
        {
            isActive = true;
            isCompleted = false;
            isFailed = false;
            elapsedTime = 0f;
            Debug.Log($"Mission started: {missionName}");
        }

        public virtual void UpdateMission()
        {
            if (!isActive) return;

            elapsedTime += Time.deltaTime;

            // Check time limit
            if (timeLimit > 0 && elapsedTime >= timeLimit)
            {
                isFailed = true;
                Debug.Log($"Mission failed: Time limit exceeded");
            }
        }

        public float GetRemainingTime()
        {
            return Mathf.Max(0, timeLimit - elapsedTime);
        }

        public float GetProgress()
        {
            return 0f; // Override in subclasses
        }
    }

    public enum MissionType
    {
        AnimalRescue,
        PoacherTracking,
        FireFighting,
        MedicalAid,
        AnimalRelocation,
        PatrolArea,
        Investigation
    }
}
