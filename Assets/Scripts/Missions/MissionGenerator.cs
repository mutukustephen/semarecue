using UnityEngine;

namespace MojaveWild.Missions
{
    /// <summary>
    /// Generates procedural missions based on player level and game state
    /// </summary>
    public class MissionGenerator : MonoBehaviour
    {
        [Header("Generation Settings")]
        public int minPlayerLevel = 1;
        public float difficultyMultiplier = 1.0f;

        private Player.PlayerController player;

        private void Start()
        {
            player = FindObjectOfType<Player.PlayerController>();
        }

        public Mission GenerateMission()
        {
            if (player == null)
            {
                player = FindObjectOfType<Player.PlayerController>();
            }

            // Calculate mission difficulty based on player level
            int playerLevel = player != null ? player.GetLevel() : 1;
            float difficulty = playerLevel * difficultyMultiplier;

            // Randomly select mission type
            MissionType[] types = (MissionType[])System.Enum.GetValues(typeof(MissionType));
            MissionType selectedType = types[Random.Range(0, types.Length)];

            // Generate mission based on type
            Mission mission = CreateMissionByType(selectedType, difficulty);

            return mission;
        }

        private Mission CreateMissionByType(MissionType type, float difficulty)
        {
            switch (type)
            {
                case MissionType.AnimalRescue:
                    return CreateAnimalRescueMission(difficulty);

                case MissionType.FireFighting:
                    return CreateFireFightingMission(difficulty);

                case MissionType.MedicalAid:
                    return CreateMedicalAidMission(difficulty);

                case MissionType.AnimalRelocation:
                    return CreateRelocationMission(difficulty);

                case MissionType.PoacherTracking:
                    return CreatePoacherTrackingMission(difficulty);

                default:
                    return CreateAnimalRescueMission(difficulty);
            }
        }

        private Mission CreateAnimalRescueMission(float difficulty)
        {
            AnimalRescueMission mission = new AnimalRescueMission();
            mission.missionId = $"rescue_{System.Guid.NewGuid().ToString().Substring(0, 8)}";
            mission.missionName = "Animal Rescue";
            mission.description = "A distressed animal has been spotted. Locate and rescue it.";
            mission.experienceReward = Mathf.RoundToInt(100 * difficulty);
            mission.timeLimit = 600f;
            mission.encyclopediaUnlocks = new string[] { "elephant_facts", "rescue_techniques" };
            
            // Set rescue-specific parameters
            mission.targetAnimalType = GetRandomAnimalType();
            mission.rescueLocation = GetRandomLocation();
            
            return mission;
        }

        private Mission CreateFireFightingMission(float difficulty)
        {
            FireFightingMission mission = new FireFightingMission();
            mission.missionId = $"fire_{System.Guid.NewGuid().ToString().Substring(0, 8)}";
            mission.missionName = "Bushfire Emergency";
            mission.description = "A bushfire has broken out! Extinguish it before it spreads.";
            mission.experienceReward = Mathf.RoundToInt(150 * difficulty);
            mission.timeLimit = 480f;
            mission.encyclopediaUnlocks = new string[] { "fire_ecology", "fire_management" };
            
            mission.fireLocation = GetRandomLocation();
            mission.firesToExtinguish = Mathf.RoundToInt(3 + difficulty);
            
            return mission;
        }

        private Mission CreateMedicalAidMission(float difficulty)
        {
            MedicalAidMission mission = new MedicalAidMission();
            mission.missionId = $"medical_{System.Guid.NewGuid().ToString().Substring(0, 8)}";
            mission.missionName = "Medical Emergency";
            mission.description = "An injured animal needs immediate medical attention.";
            mission.experienceReward = Mathf.RoundToInt(120 * difficulty);
            mission.timeLimit = 420f;
            mission.encyclopediaUnlocks = new string[] { "wildlife_medicine", "first_aid" };
            
            mission.targetAnimalType = GetRandomAnimalType();
            mission.injuryLocation = GetRandomLocation();
            mission.medicalSuppliesNeeded = Mathf.RoundToInt(2 + difficulty * 0.5f);
            
            return mission;
        }

        private Mission CreateRelocationMission(float difficulty)
        {
            AnimalRelocationMission mission = new AnimalRelocationMission();
            mission.missionId = $"relocate_{System.Guid.NewGuid().ToString().Substring(0, 8)}";
            mission.missionName = "Animal Relocation";
            mission.description = "Move animals to a safer habitat zone.";
            mission.experienceReward = Mathf.RoundToInt(130 * difficulty);
            mission.timeLimit = 720f;
            mission.encyclopediaUnlocks = new string[] { "habitat_management", "animal_behavior" };
            
            mission.sourceLocation = GetRandomLocation();
            mission.destinationLocation = GetRandomLocation();
            mission.animalsToRelocate = Mathf.RoundToInt(2 + difficulty * 0.3f);
            
            return mission;
        }

        private Mission CreatePoacherTrackingMission(float difficulty)
        {
            PoacherTrackingMission mission = new PoacherTrackingMission();
            mission.missionId = $"poacher_{System.Guid.NewGuid().ToString().Substring(0, 8)}";
            mission.missionName = "Poacher Alert";
            mission.description = "Illegal activity detected. Track and report the poachers.";
            mission.experienceReward = Mathf.RoundToInt(180 * difficulty);
            mission.timeLimit = 540f;
            mission.encyclopediaUnlocks = new string[] { "conservation_law", "anti_poaching" };
            
            mission.trackingStartLocation = GetRandomLocation();
            mission.evidenceToCollect = Mathf.RoundToInt(3 + difficulty * 0.4f);
            
            return mission;
        }

        private string GetRandomAnimalType()
        {
            string[] animals = { "Elephant", "Lion", "Zebra", "Giraffe", "Rhino", "Buffalo", "Leopard" };
            return animals[Random.Range(0, animals.Length)];
        }

        private Vector3 GetRandomLocation()
        {
            // Generate random location within game world bounds
            float x = Random.Range(-100f, 100f);
            float z = Random.Range(-100f, 100f);
            return new Vector3(x, 0, z);
        }
    }
}
