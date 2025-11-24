using UnityEngine;

namespace MojaveWild.Environment
{
    /// <summary>
    /// Day-night cycle system with dynamic lighting
    /// Affects animal behavior and mission availability
    /// </summary>
    public class DayNightCycle : MonoBehaviour
    {
        [Header("Time Settings")]
        [Range(0f, 24f)]
        public float currentTime = 6f; // Start at 6 AM
        public float dayDurationMinutes = 24f; // 24 real minutes = 24 game hours
        public bool cyclePaused = false;

        [Header("Lighting")]
        public Light sunLight;
        public Light moonLight;
        public Gradient skyColor;
        public Gradient horizonColor;
        public AnimationCurve lightIntensityCurve;

        [Header("Time of Day Thresholds")]
        public float sunriseTime = 6f;
        public float sunsetTime = 18f;

        private float timeMultiplier;
        private Material skyboxMaterial;

        private void Start()
        {
            // Calculate time multiplier (24 game hours / X real minutes)
            timeMultiplier = 24f / (dayDurationMinutes * 60f);

            // Get skybox material
            if (RenderSettings.skybox != null)
            {
                skyboxMaterial = new Material(RenderSettings.skybox);
                RenderSettings.skybox = skyboxMaterial;
            }

            // Set up lights
            if (sunLight == null)
            {
                GameObject sun = GameObject.Find("Sun");
                if (sun != null)
                {
                    sunLight = sun.GetComponent<Light>();
                }
            }

            UpdateLighting();
        }

        private void Update()
        {
            if (!cyclePaused)
            {
                // Advance time
                currentTime += Time.deltaTime * timeMultiplier;

                // Wrap time to 24-hour format
                if (currentTime >= 24f)
                {
                    currentTime = 0f;
                }

                UpdateLighting();
            }
        }

        private void UpdateLighting()
        {
            // Calculate time percentage (0-1)
            float timePercent = currentTime / 24f;

            // Rotate sun
            if (sunLight != null)
            {
                float sunAngle = (currentTime - 6f) * 15f; // 15 degrees per hour, starting at 6 AM
                sunLight.transform.rotation = Quaternion.Euler(sunAngle - 90f, 170f, 0f);

                // Adjust sun intensity based on time
                sunLight.intensity = lightIntensityCurve.Evaluate(timePercent);
                
                // Enable/disable sun based on day/night
                sunLight.enabled = IsDaytime();
            }

            // Moon light
            if (moonLight != null)
            {
                moonLight.enabled = IsNight();
                moonLight.intensity = IsNight() ? 0.3f : 0f;
            }

            // Update skybox colors
            if (skyboxMaterial != null)
            {
                Color sky = skyColor.Evaluate(timePercent);
                Color horizon = horizonColor.Evaluate(timePercent);
                
                skyboxMaterial.SetColor("_SkyTint", sky);
                skyboxMaterial.SetColor("_GroundColor", horizon);
            }

            // Update ambient lighting
            RenderSettings.ambientIntensity = lightIntensityCurve.Evaluate(timePercent);
        }

        public bool IsDaytime()
        {
            return currentTime >= sunriseTime && currentTime < sunsetTime;
        }

        public bool IsNight()
        {
            return !IsDaytime();
        }

        public string GetTimeOfDayString()
        {
            int hours = Mathf.FloorToInt(currentTime);
            int minutes = Mathf.FloorToInt((currentTime - hours) * 60f);
            return $"{hours:00}:{minutes:00}";
        }

        public void SetTime(float time)
        {
            currentTime = Mathf.Clamp(time, 0f, 24f);
            UpdateLighting();
        }

        public void PauseCycle(bool pause)
        {
            cyclePaused = pause;
        }

        // Get time period for missions
        public TimePeriod GetCurrentTimePeriod()
        {
            if (currentTime >= 5f && currentTime < 12f)
                return TimePeriod.Morning;
            else if (currentTime >= 12f && currentTime < 17f)
                return TimePeriod.Afternoon;
            else if (currentTime >= 17f && currentTime < 20f)
                return TimePeriod.Evening;
            else
                return TimePeriod.Night;
        }
    }

    public enum TimePeriod
    {
        Morning,
        Afternoon,
        Evening,
        Night
    }
}
