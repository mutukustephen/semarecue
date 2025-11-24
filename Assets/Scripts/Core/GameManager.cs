using UnityEngine;
using UnityEngine.SceneManagement;

namespace MojaveWild.Core
{
    /// <summary>
    /// Central game manager using Singleton pattern
    /// Manages game state, scene transitions, and system coordination
    /// </summary>
    public class GameManager : MonoBehaviour
    {
        public static GameManager Instance { get; private set; }

        [Header("Game State")]
        public GameState currentState = GameState.MainMenu;
        
        [Header("Systems")]
        public DatabaseManager databaseManager;
        public SaveSystem saveSystem;

        [Header("Settings")]
        public float masterVolume = 1.0f;
        public int targetFrameRate = 30;

        private void Awake()
        {
            // Singleton pattern
            if (Instance != null && Instance != this)
            {
                Destroy(gameObject);
                return;
            }

            Instance = this;
            DontDestroyOnLoad(gameObject);

            InitializeGame();
        }

        private void Start()
        {
            Application.targetFrameRate = targetFrameRate;
        }

        private void InitializeGame()
        {
            Debug.Log("MOJAVE WILD - Initializing Game Systems");

            // Initialize database
            if (databaseManager == null)
            {
                databaseManager = gameObject.AddComponent<DatabaseManager>();
            }
            databaseManager.Initialize();

            // Initialize save system
            if (saveSystem == null)
            {
                saveSystem = gameObject.AddComponent<SaveSystem>();
            }
            saveSystem.Initialize();

            Debug.Log("Game Systems Initialized Successfully");
        }

        public void StartNewGame()
        {
            Debug.Log("Starting New Game");
            currentState = GameState.Playing;
            saveSystem.CreateNewSave();
            LoadGameScene();
        }

        public void ContinueGame()
        {
            Debug.Log("Continuing Game");
            currentState = GameState.Playing;
            saveSystem.LoadGame();
            LoadGameScene();
        }

        public void PauseGame()
        {
            currentState = GameState.Paused;
            Time.timeScale = 0f;
        }

        public void ResumeGame()
        {
            currentState = GameState.Playing;
            Time.timeScale = 1f;
        }

        public void ReturnToMainMenu()
        {
            currentState = GameState.MainMenu;
            Time.timeScale = 1f;
            SceneManager.LoadScene("MainMenu");
        }

        public void QuitGame()
        {
            Debug.Log("Quitting Game");
            saveSystem.SaveGame();
            Application.Quit();
        }

        private void LoadGameScene()
        {
            SceneManager.LoadScene("GameWorld");
        }

        private void OnApplicationPause(bool pause)
        {
            if (pause && currentState == GameState.Playing)
            {
                saveSystem.SaveGame();
            }
        }

        private void OnApplicationQuit()
        {
            if (currentState == GameState.Playing)
            {
                saveSystem.SaveGame();
            }
        }
    }

    public enum GameState
    {
        MainMenu,
        Playing,
        Paused,
        Loading
    }
}
