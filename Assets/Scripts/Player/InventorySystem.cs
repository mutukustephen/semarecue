using UnityEngine;
using System.Collections.Generic;

namespace MojaveWild.Player
{
    /// <summary>
    /// Manages player inventory and resources
    /// Handles item storage, usage, and database persistence
    /// </summary>
    public class InventorySystem : MonoBehaviour
    {
        [System.Serializable]
        public class Item
        {
            public string itemId;
            public string itemName;
            public string description;
            public int quantity;
            public ItemType type;
            public Sprite icon;
        }

        public enum ItemType
        {
            Medical,
            Food,
            Water,
            Tool,
            Equipment,
            Resource
        }

        [Header("Inventory")]
        public List<Item> items = new List<Item>();
        public int maxInventorySlots = 20;

        [Header("Item Definitions")]
        public ItemDefinition[] itemDefinitions;

        private Core.DatabaseManager db;

        private void Start()
        {
            db = Core.GameManager.Instance.databaseManager;
        }

        public bool AddItem(string itemId, int quantity = 1)
        {
            // Check if item already exists in inventory
            Item existingItem = items.Find(i => i.itemId == itemId);

            if (existingItem != null)
            {
                existingItem.quantity += quantity;
                Debug.Log($"Added {quantity} {existingItem.itemName}. Total: {existingItem.quantity}");
                return true;
            }

            // Check if inventory is full
            if (items.Count >= maxInventorySlots)
            {
                Debug.LogWarning("Inventory is full!");
                return false;
            }

            // Create new item from definition
            ItemDefinition definition = GetItemDefinition(itemId);
            if (definition != null)
            {
                Item newItem = new Item
                {
                    itemId = itemId,
                    itemName = definition.itemName,
                    description = definition.description,
                    quantity = quantity,
                    type = definition.type,
                    icon = definition.icon
                };

                items.Add(newItem);
                Debug.Log($"Added new item: {newItem.itemName} x{quantity}");
                return true;
            }

            Debug.LogError($"Item definition not found for: {itemId}");
            return false;
        }

        public bool RemoveItem(string itemId, int quantity = 1)
        {
            Item item = items.Find(i => i.itemId == itemId);

            if (item == null)
            {
                Debug.LogWarning($"Item not found: {itemId}");
                return false;
            }

            if (item.quantity < quantity)
            {
                Debug.LogWarning($"Not enough {item.itemName}. Have: {item.quantity}, Need: {quantity}");
                return false;
            }

            item.quantity -= quantity;
            Debug.Log($"Removed {quantity} {item.itemName}. Remaining: {item.quantity}");

            if (item.quantity <= 0)
            {
                items.Remove(item);
                Debug.Log($"{item.itemName} removed from inventory");
            }

            return true;
        }

        public bool UseItem(string itemId)
        {
            Item item = items.Find(i => i.itemId == itemId);

            if (item == null)
            {
                Debug.LogWarning($"Cannot use item - not in inventory: {itemId}");
                return false;
            }

            // Apply item effects based on type
            bool used = ApplyItemEffect(item);

            if (used)
            {
                RemoveItem(itemId, 1);
            }

            return used;
        }

        private bool ApplyItemEffect(Item item)
        {
            PlayerController player = GetComponent<PlayerController>();
            if (player == null) return false;

            switch (item.itemId)
            {
                case "medical_kit":
                    player.Heal(50f);
                    Debug.Log("Used medical kit - restored 50 health");
                    return true;

                case "water_bottle":
                    player.currentStamina = Mathf.Min(
                        player.maxStamina,
                        player.currentStamina + 30f
                    );
                    Debug.Log("Drank water - restored 30 stamina");
                    return true;

                case "food_ration":
                    player.Heal(20f);
                    player.currentStamina = Mathf.Min(
                        player.maxStamina,
                        player.currentStamina + 20f
                    );
                    Debug.Log("Ate food - restored 20 health and 20 stamina");
                    return true;

                default:
                    Debug.LogWarning($"No effect defined for item: {item.itemId}");
                    return false;
            }
        }

        public int GetItemCount(string itemId)
        {
            Item item = items.Find(i => i.itemId == itemId);
            return item?.quantity ?? 0;
        }

        public bool HasItem(string itemId, int quantity = 1)
        {
            return GetItemCount(itemId) >= quantity;
        }

        public void SaveToDatabase()
        {
            if (db == null) return;

            // Clear existing inventory in database
            db.ClearInventory();

            // Save all items
            foreach (Item item in items)
            {
                db.SaveInventoryItem(new Core.InventoryItem
                {
                    itemId = item.itemId,
                    quantity = item.quantity
                });
            }

            Debug.Log($"Saved {items.Count} items to database");
        }

        public void LoadFromDatabase()
        {
            if (db == null) return;

            items.Clear();

            Core.InventoryItem[] savedItems = db.LoadInventory();

            foreach (Core.InventoryItem savedItem in savedItems)
            {
                AddItem(savedItem.itemId, savedItem.quantity);
            }

            Debug.Log($"Loaded {items.Count} items from database");
        }

        private ItemDefinition GetItemDefinition(string itemId)
        {
            foreach (ItemDefinition def in itemDefinitions)
            {
                if (def.itemId == itemId)
                {
                    return def;
                }
            }
            return null;
        }
    }

    [System.Serializable]
    public class ItemDefinition
    {
        public string itemId;
        public string itemName;
        public string description;
        public InventorySystem.ItemType type;
        public Sprite icon;
    }
}
