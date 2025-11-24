using UnityEngine;
using System.Collections.Generic;

namespace MojaveWild.Environment
{
    /// <summary>
    /// Fire propagation system for bushfire missions
    /// Implements realistic fire spread based on wind and fuel
    /// </summary>
    public class FirePropagation : MonoBehaviour
    {
        [Header("Fire Settings")]
        public float baseSpreadRate = 0.3f;
        public float windEffectMultiplier = 0.5f;
        public float tileFuelAmount = 1.0f;
        public float fireLifetime = 60f;

        [Header("Grid Settings")]
        public int gridWidth = 50;
        public int gridHeight = 50;
        public float tileSize = 2f;

        [Header("Prefabs")]
        public GameObject firePrefab;
        public GameObject burnedGroundPrefab;

        [Header("Wind")]
        public Vector2 windDirection = new Vector2(1f, 0f);
        public float windStrength = 0.5f;

        private FireTile[,] fireGrid;
        private List<FireTile> activeFires = new List<FireTile>();
        private float updateTimer = 0f;
        private float updateInterval = 1f; // Update fire spread every second

        private void Start()
        {
            InitializeGrid();
        }

        private void Update()
        {
            updateTimer += Time.deltaTime;

            if (updateTimer >= updateInterval)
            {
                UpdateFireSpread();
                updateTimer = 0f;
            }

            // Update active fires
            for (int i = activeFires.Count - 1; i >= 0; i--)
            {
                FireTile fire = activeFires[i];
                fire.lifetime += Time.deltaTime;

                if (fire.lifetime >= fireLifetime || fire.isExtinguished)
                {
                    ExtinguishFire(fire);
                    activeFires.RemoveAt(i);
                }
            }
        }

        private void InitializeGrid()
        {
            fireGrid = new FireTile[gridWidth, gridHeight];

            for (int x = 0; x < gridWidth; x++)
            {
                for (int y = 0; y < gridHeight; y++)
                {
                    fireGrid[x, y] = new FireTile
                    {
                        gridX = x,
                        gridY = y,
                        worldPosition = new Vector3(x * tileSize, 0, y * tileSize),
                        fuel = tileFuelAmount,
                        isOnFire = false
                    };
                }
            }

            Debug.Log($"Fire grid initialized: {gridWidth}x{gridHeight}");
        }

        public void StartFire(Vector3 worldPosition)
        {
            // Convert world position to grid coordinates
            int gridX = Mathf.RoundToInt(worldPosition.x / tileSize);
            int gridY = Mathf.RoundToInt(worldPosition.z / tileSize);

            if (IsValidGridPosition(gridX, gridY))
            {
                IgniteTile(gridX, gridY);
            }
        }

        private void IgniteTile(int x, int y)
        {
            if (!IsValidGridPosition(x, y)) return;

            FireTile tile = fireGrid[x, y];

            if (tile.isOnFire || tile.fuel <= 0) return;

            tile.isOnFire = true;
            tile.lifetime = 0f;
            tile.isExtinguished = false;

            // Spawn fire visual
            if (firePrefab != null)
            {
                tile.fireObject = Instantiate(firePrefab, tile.worldPosition, Quaternion.identity);
                tile.fireObject.transform.parent = transform;
            }

            activeFires.Add(tile);
            Debug.Log($"Fire started at grid position ({x}, {y})");
        }

        private void UpdateFireSpread()
        {
            List<FireTile> newFires = new List<FireTile>();

            foreach (FireTile fire in activeFires)
            {
                if (fire.isExtinguished) continue;

                // Try to spread to neighboring tiles
                int[][] neighbors = new int[][]
                {
                    new int[] { fire.gridX + 1, fire.gridY },     // Right
                    new int[] { fire.gridX - 1, fire.gridY },     // Left
                    new int[] { fire.gridX, fire.gridY + 1 },     // Up
                    new int[] { fire.gridX, fire.gridY - 1 },     // Down
                    new int[] { fire.gridX + 1, fire.gridY + 1 }, // Diagonal
                    new int[] { fire.gridX - 1, fire.gridY - 1 }, // Diagonal
                    new int[] { fire.gridX + 1, fire.gridY - 1 }, // Diagonal
                    new int[] { fire.gridX - 1, fire.gridY + 1 }  // Diagonal
                };

                foreach (int[] neighbor in neighbors)
                {
                    int nx = neighbor[0];
                    int ny = neighbor[1];

                    if (IsValidGridPosition(nx, ny))
                    {
                        FireTile neighborTile = fireGrid[nx, ny];

                        if (!neighborTile.isOnFire && neighborTile.fuel > 0)
                        {
                            // Calculate spread chance
                            float windEffect = CalculateWindEffect(fire.gridX, fire.gridY, nx, ny);
                            float spreadChance = (baseSpreadRate + windEffect) * neighborTile.fuel;

                            if (Random.value < spreadChance)
                            {
                                newFires.Add(neighborTile);
                            }
                        }
                    }
                }
            }

            // Ignite new tiles
            foreach (FireTile tile in newFires)
            {
                IgniteTile(tile.gridX, tile.gridY);
            }
        }

        private float CalculateWindEffect(int fromX, int fromY, int toX, int toY)
        {
            // Calculate direction from source to target
            Vector2 spreadDirection = new Vector2(toX - fromX, toY - fromY).normalized;

            // Calculate dot product with wind direction
            float windAlignment = Vector2.Dot(spreadDirection, windDirection.normalized);

            // Wind effect is positive when spreading with wind, negative against
            return windAlignment * windStrength * windEffectMultiplier;
        }

        public void ExtinguishFireAt(Vector3 worldPosition)
        {
            int gridX = Mathf.RoundToInt(worldPosition.x / tileSize);
            int gridY = Mathf.RoundToInt(worldPosition.z / tileSize);

            if (IsValidGridPosition(gridX, gridY))
            {
                FireTile tile = fireGrid[gridX, gridY];
                if (tile.isOnFire)
                {
                    tile.isExtinguished = true;
                    Debug.Log($"Fire extinguished at ({gridX}, {gridY})");
                }
            }
        }

        private void ExtinguishFire(FireTile tile)
        {
            tile.isOnFire = false;
            tile.fuel = 0f;

            // Destroy fire visual
            if (tile.fireObject != null)
            {
                Destroy(tile.fireObject);
            }

            // Spawn burned ground
            if (burnedGroundPrefab != null)
            {
                GameObject burned = Instantiate(burnedGroundPrefab, tile.worldPosition, Quaternion.identity);
                burned.transform.parent = transform;
            }
        }

        private bool IsValidGridPosition(int x, int y)
        {
            return x >= 0 && x < gridWidth && y >= 0 && y < gridHeight;
        }

        public int GetActiveFireCount()
        {
            return activeFires.Count;
        }

        public void SetWindDirection(Vector2 direction)
        {
            windDirection = direction.normalized;
        }

        public void SetWindStrength(float strength)
        {
            windStrength = Mathf.Clamp01(strength);
        }
    }

    [System.Serializable]
    public class FireTile
    {
        public int gridX;
        public int gridY;
        public Vector3 worldPosition;
        public float fuel;
        public bool isOnFire;
        public bool isExtinguished;
        public float lifetime;
        public GameObject fireObject;
    }
}
