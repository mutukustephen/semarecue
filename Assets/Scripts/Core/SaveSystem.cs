using UnityEngine;

namespace MojaveWild.Core
{
    /// <summary>
    /// Handles save and load operations
    /// Coordinates between DatabaseManager and game systems
    /// </summary>
    public class SaveSystem : MonoBehaviour
    {
        private DatabaseManager db;

        public void Initialize()
        {
            db = GameManager.Instance.databaseManager;
            Debug.Log("Save System initialized");
        }

        public void CreateNewSave()
        {
            Debug.Log("Creating new save file");

            // Clear existing data
            db.ClearInventory();

            // Create new player progress
            PlayerProgress newProgress = new PlayerProgress
            {
                level = 1,
                experience = 0,
                currentMissionId = "",
                playTime = 0,
                positionX = 0,
                positionY = 0,
                positionZ = 0
            };

            db.SavePlayerProgress(newProgress);

            // Add starting inventory items
            AddStartingInventory();

            Debug.Log("New save created successfully");
        }

        public void SaveGame()
        {
            Debug.Log("Saving game...");

            // Save player progress
            SavePlayerData();

            // Save inventory
            SaveInventoryData();

            Debug.Log("Game saved successfully");
        }

        public void LoadGame()
        {
            Debug.Log("Loading game...");

            // Load player progress
            LoadPlayerData();

            // Load inventory
            LoadInventoryData();

            // Load completed missions
            LoadMissionData();

            Debug.Log("Game loaded successfully");
        }

        private void SavePlayerData()
        {
            // Get player controller (will be implemented later)
            var player = FindObjectOfType<Player.PlayerController>();
            if (player != null)
            {
                PlayerProgress progress = new PlayerProgress
                {
                    level = player.level,
                    experience = player.experience,
                    currentMissionId = player.currentMissionId,
                    playTime = (long)Time.realtimeSinceStartup,
                    positionX = player.transform.position.x,
                    positionY = player.transform.position.y,
                    positionZ = player.transform.position.z
                };

                db.SavePlayerProgress(progress);
            }
        }

        private void LoadPlayerData()
        {
            PlayerProgress progress = db.LoadPlayerProgress();
            if (progress != null)
            {
                var player = FindObjectOfType<Player.PlayerController>();
                if (player != null)
                {
                    player.level = progress.level;
                    player.experience = progress.experience;
                    player.currentMissionId = progress.currentMissionId;
                    player.transform.position = new Vector3(
                        progress.positionX,
                        progress.positionY,
                        progress.positionZ
                    );
                }
            }
        }

        private void SaveInventoryData()
        {
            var inventory = FindObjectOfType<Player.InventorySystem>();
            if (inventory != null)
            {
                inventory.SaveToDatabase();
            }
        }

        private void LoadInventoryData()
        {
            var inventory = FindObjectOfType<Player.InventorySystem>();
            if (inventory != null)
            {
                inventory.LoadFromDatabase();
            }
        }

        private void LoadMissionData()
        {
            var missionManager = FindObjectOfType<Missions.MissionManager>();
            if (missionManager != null)
            {
                missionManager.LoadCompletedMissions();
            }
        }

        private void AddStartingInventory()
        {
            // Starting items for new players
            db.SaveInventoryItem(new InventoryItem { itemId = "medical_kit", quantity = 3 });
            db.SaveInventoryItem(new InventoryItem { itemId = "water_bottle", quantity = 5 });
            db.SaveInventoryItem(new InventoryItem { itemId = "food_ration", quantity = 5 });
            db.SaveInventoryItem(new InventoryItem { itemId = "binoculars", quantity = 1 });
            db.SaveInventoryItem(new InventoryItem { itemId = "radio", quantity = 1 });
        }

        public bool HasExistingSave()
        {
            PlayerProgress progress = db.LoadPlayerProgress();
            return progress != null;
        }
    }
}
