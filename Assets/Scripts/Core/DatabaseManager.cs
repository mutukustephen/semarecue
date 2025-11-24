using System;
using System.IO;
using UnityEngine;
using SQLite;

namespace MojaveWild.Core
{
    /// <summary>
    /// Manages SQLite database operations for offline data persistence
    /// Handles player progress, inventory, missions, and encyclopedia
    /// </summary>
    public class DatabaseManager : MonoBehaviour
    {
        private SQLiteConnection database;
        private string databasePath;

        public void Initialize()
        {
            databasePath = Path.Combine(Application.persistentDataPath, "mojave_wild.db");
            Debug.Log($"Database Path: {databasePath}");

            try
            {
                database = new SQLiteConnection(databasePath);
                CreateTables();
                Debug.Log("Database initialized successfully");
            }
            catch (Exception e)
            {
                Debug.LogError($"Database initialization failed: {e.Message}");
            }
        }

        private void CreateTables()
        {
            database.CreateTable<PlayerProgress>();
            database.CreateTable<InventoryItem>();
            database.CreateTable<CompletedMission>();
            database.CreateTable<UnlockedEncyclopediaEntry>();
            Debug.Log("Database tables created");
        }

        #region Player Progress

        public void SavePlayerProgress(PlayerProgress progress)
        {
            try
            {
                var existing = database.Table<PlayerProgress>().FirstOrDefault();
                if (existing != null)
                {
                    progress.id = existing.id;
                    database.Update(progress);
                }
                else
                {
                    database.Insert(progress);
                }
            }
            catch (Exception e)
            {
                Debug.LogError($"Failed to save player progress: {e.Message}");
            }
        }

        public PlayerProgress LoadPlayerProgress()
        {
            try
            {
                return database.Table<PlayerProgress>().FirstOrDefault();
            }
            catch (Exception e)
            {
                Debug.LogError($"Failed to load player progress: {e.Message}");
                return null;
            }
        }

        #endregion

        #region Inventory

        public void SaveInventoryItem(InventoryItem item)
        {
            try
            {
                var existing = database.Table<InventoryItem>()
                    .FirstOrDefault(i => i.itemId == item.itemId);
                
                if (existing != null)
                {
                    item.id = existing.id;
                    database.Update(item);
                }
                else
                {
                    database.Insert(item);
                }
            }
            catch (Exception e)
            {
                Debug.LogError($"Failed to save inventory item: {e.Message}");
            }
        }

        public InventoryItem[] LoadInventory()
        {
            try
            {
                return database.Table<InventoryItem>().ToArray();
            }
            catch (Exception e)
            {
                Debug.LogError($"Failed to load inventory: {e.Message}");
                return new InventoryItem[0];
            }
        }

        public void ClearInventory()
        {
            database.DeleteAll<InventoryItem>();
        }

        #endregion

        #region Missions

        public void SaveCompletedMission(CompletedMission mission)
        {
            try
            {
                database.Insert(mission);
            }
            catch (Exception e)
            {
                Debug.LogError($"Failed to save completed mission: {e.Message}");
            }
        }

        public CompletedMission[] LoadCompletedMissions()
        {
            try
            {
                return database.Table<CompletedMission>().ToArray();
            }
            catch (Exception e)
            {
                Debug.LogError($"Failed to load completed missions: {e.Message}");
                return new CompletedMission[0];
            }
        }

        #endregion

        #region Encyclopedia

        public void UnlockEncyclopediaEntry(string entryId)
        {
            try
            {
                var existing = database.Table<UnlockedEncyclopediaEntry>()
                    .FirstOrDefault(e => e.entryId == entryId);
                
                if (existing == null)
                {
                    database.Insert(new UnlockedEncyclopediaEntry
                    {
                        entryId = entryId,
                        unlockedAt = GetCurrentTimestamp()
                    });
                    Debug.Log($"Unlocked encyclopedia entry: {entryId}");
                }
            }
            catch (Exception e)
            {
                Debug.LogError($"Failed to unlock encyclopedia entry: {e.Message}");
            }
        }

        public UnlockedEncyclopediaEntry[] LoadUnlockedEntries()
        {
            try
            {
                return database.Table<UnlockedEncyclopediaEntry>().ToArray();
            }
            catch (Exception e)
            {
                Debug.LogError($"Failed to load unlocked entries: {e.Message}");
                return new UnlockedEncyclopediaEntry[0];
            }
        }

        public bool IsEntryUnlocked(string entryId)
        {
            return database.Table<UnlockedEncyclopediaEntry>()
                .Any(e => e.entryId == entryId);
        }

        #endregion

        private long GetCurrentTimestamp()
        {
            return DateTimeOffset.UtcNow.ToUnixTimeSeconds();
        }

        private void OnDestroy()
        {
            database?.Close();
        }
    }

    #region Database Models

    [Table("PlayerProgress")]
    public class PlayerProgress
    {
        [PrimaryKey, AutoIncrement]
        public int id { get; set; }
        public int level { get; set; }
        public int experience { get; set; }
        public string currentMissionId { get; set; }
        public long playTime { get; set; }
        public float positionX { get; set; }
        public float positionY { get; set; }
        public float positionZ { get; set; }
    }

    [Table("Inventory")]
    public class InventoryItem
    {
        [PrimaryKey, AutoIncrement]
        public int id { get; set; }
        public string itemId { get; set; }
        public int quantity { get; set; }
    }

    [Table("CompletedMissions")]
    public class CompletedMission
    {
        [PrimaryKey, AutoIncrement]
        public int id { get; set; }
        public string missionId { get; set; }
        public long completionTime { get; set; }
        public int score { get; set; }
    }

    [Table("UnlockedEncyclopedia")]
    public class UnlockedEncyclopediaEntry
    {
        [PrimaryKey, AutoIncrement]
        public int id { get; set; }
        public string entryId { get; set; }
        public long unlockedAt { get; set; }
    }

    #endregion
}
