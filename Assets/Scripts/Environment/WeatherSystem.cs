using UnityEngine;

namespace MojaveWild.Environment
{
    /// <summary>
    /// Weather system controlling wind and environmental effects
    /// Affects fire spread and animal behavior
    /// </summary>
    public class WeatherSystem : MonoBehaviour
    {
        [Header("Wind")]
        public Vector2 currentWindDirection = new Vector2(1f, 0f);
        public float currentWindSpeed = 5f;
        public float windChangeInterval = 60f;
        public float maxWindSpeed = 15f;

        [Header("Effects")]
        public ParticleSystem windParticles;
        public AudioSource windAudioSource;

        private float windChangeTimer = 0f;
        private FirePropagation firePropagation;

        private void Start()
        {
            firePropagation = FindObjectOfType<FirePropagation>();
            UpdateWindEffects();
        }

        private void Update()
        {
            windChangeTimer += Time.deltaTime;

            if (windChangeTimer >= windChangeInterval)
            {
                ChangeWind();
                windChangeTimer = 0f;
            }
        }

        private void ChangeWind()
        {
            // Gradually change wind direction
            float angle = Random.Range(-45f, 45f);
            Vector2 newDirection = Rotate(currentWindDirection, angle);
            currentWindDirection = newDirection.normalized;

            // Vary wind speed
            currentWindSpeed = Random.Range(2f, maxWindSpeed);

            UpdateWindEffects();

            Debug.Log($"Wind changed: Direction {currentWindDirection}, Speed {currentWindSpeed:F1} m/s");
        }

        private void UpdateWindEffects()
        {
            // Update fire propagation
            if (firePropagation != null)
            {
                firePropagation.SetWindDirection(currentWindDirection);
                firePropagation.SetWindStrength(currentWindSpeed / maxWindSpeed);
            }

            // Update particle effects
            if (windParticles != null)
            {
                var main = windParticles.main;
                main.startSpeed = currentWindSpeed;
                
                var shape = windParticles.shape;
                float angle = Mathf.Atan2(currentWindDirection.y, currentWindDirection.x) * Mathf.Rad2Deg;
                windParticles.transform.rotation = Quaternion.Euler(0, angle, 0);
            }

            // Update wind audio
            if (windAudioSource != null)
            {
                windAudioSource.volume = Mathf.Clamp01(currentWindSpeed / maxWindSpeed);
            }
        }

        private Vector2 Rotate(Vector2 v, float degrees)
        {
            float radians = degrees * Mathf.Deg2Rad;
            float cos = Mathf.Cos(radians);
            float sin = Mathf.Sin(radians);
            return new Vector2(
                v.x * cos - v.y * sin,
                v.x * sin + v.y * cos
            );
        }

        public Vector2 GetWindDirection()
        {
            return currentWindDirection;
        }

        public float GetWindSpeed()
        {
            return currentWindSpeed;
        }

        public string GetWindDescription()
        {
            if (currentWindSpeed < 5f)
                return "Light breeze";
            else if (currentWindSpeed < 10f)
                return "Moderate wind";
            else
                return "Strong wind";
        }
    }
}
