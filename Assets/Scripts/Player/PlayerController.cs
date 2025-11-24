using UnityEngine;

namespace MojaveWild.Player
{
    /// <summary>
    /// Third-person player controller with mobile touch controls
    /// Handles movement, camera, and basic player stats
    /// </summary>
    [RequireComponent(typeof(CharacterController))]
    public class PlayerController : MonoBehaviour
    {
        [Header("Player Stats")]
        public int level = 1;
        public int experience = 0;
        public string currentMissionId = "";

        [Header("Movement")]
        public float walkSpeed = 3f;
        public float runSpeed = 6f;
        public float rotationSpeed = 10f;
        public float gravity = -9.81f;

        [Header("Stamina")]
        public float maxStamina = 100f;
        public float currentStamina = 100f;
        public float staminaDrainRate = 10f;
        public float staminaRegenRate = 15f;

        [Header("Health")]
        public float maxHealth = 100f;
        public float currentHealth = 100f;

        [Header("Camera")]
        public Transform cameraTransform;
        public float cameraDistance = 5f;
        public float cameraHeight = 2f;
        public float cameraSensitivity = 2f;

        private CharacterController controller;
        private Vector3 velocity;
        private bool isRunning = false;
        private float cameraRotationX = 0f;
        private float cameraRotationY = 0f;

        // Mobile input
        private Vector2 moveInput;
        private Vector2 lookInput;

        private void Awake()
        {
            controller = GetComponent<CharacterController>();
        }

        private void Start()
        {
            currentStamina = maxStamina;
            currentHealth = maxHealth;

            // Set up camera if not assigned
            if (cameraTransform == null && Camera.main != null)
            {
                cameraTransform = Camera.main.transform;
            }
        }

        private void Update()
        {
            HandleMovement();
            HandleStamina();
            HandleCamera();
        }

        private void HandleMovement()
        {
            // Get input (will be replaced with mobile virtual joystick)
            float horizontal = Input.GetAxis("Horizontal");
            float vertical = Input.GetAxis("Vertical");
            moveInput = new Vector2(horizontal, vertical);

            // Check if running
            isRunning = Input.GetKey(KeyCode.LeftShift) && currentStamina > 0;

            // Calculate movement
            Vector3 move = transform.right * moveInput.x + transform.forward * moveInput.y;
            float currentSpeed = isRunning ? runSpeed : walkSpeed;

            controller.Move(move * currentSpeed * Time.deltaTime);

            // Apply gravity
            if (controller.isGrounded && velocity.y < 0)
            {
                velocity.y = -2f;
            }

            velocity.y += gravity * Time.deltaTime;
            controller.Move(velocity * Time.deltaTime);

            // Rotate player based on camera direction
            if (moveInput.magnitude > 0.1f)
            {
                Vector3 lookDirection = new Vector3(move.x, 0, move.z);
                if (lookDirection != Vector3.zero)
                {
                    Quaternion targetRotation = Quaternion.LookRotation(lookDirection);
                    transform.rotation = Quaternion.Slerp(
                        transform.rotation,
                        targetRotation,
                        rotationSpeed * Time.deltaTime
                    );
                }
            }
        }

        private void HandleStamina()
        {
            if (isRunning && moveInput.magnitude > 0.1f)
            {
                // Drain stamina while running
                currentStamina -= staminaDrainRate * Time.deltaTime;
                currentStamina = Mathf.Max(0, currentStamina);
            }
            else
            {
                // Regenerate stamina
                currentStamina += staminaRegenRate * Time.deltaTime;
                currentStamina = Mathf.Min(maxStamina, currentStamina);
            }
        }

        private void HandleCamera()
        {
            if (cameraTransform == null) return;

            // Get look input (will be replaced with mobile touch)
            lookInput = new Vector2(Input.GetAxis("Mouse X"), Input.GetAxis("Mouse Y"));

            // Update camera rotation
            cameraRotationY += lookInput.x * cameraSensitivity;
            cameraRotationX -= lookInput.y * cameraSensitivity;
            cameraRotationX = Mathf.Clamp(cameraRotationX, -30f, 60f);

            // Position camera behind player
            Quaternion rotation = Quaternion.Euler(cameraRotationX, cameraRotationY, 0);
            Vector3 offset = rotation * new Vector3(0, cameraHeight, -cameraDistance);
            cameraTransform.position = transform.position + offset;
            cameraTransform.LookAt(transform.position + Vector3.up * 1.5f);
        }

        public void SetMoveInput(Vector2 input)
        {
            moveInput = input;
        }

        public void SetLookInput(Vector2 input)
        {
            lookInput = input;
        }

        public void SetRunning(bool running)
        {
            isRunning = running && currentStamina > 0;
        }

        public void TakeDamage(float damage)
        {
            currentHealth -= damage;
            currentHealth = Mathf.Max(0, currentHealth);

            if (currentHealth <= 0)
            {
                Die();
            }
        }

        public void Heal(float amount)
        {
            currentHealth += amount;
            currentHealth = Mathf.Min(maxHealth, currentHealth);
        }

        public void AddExperience(int amount)
        {
            experience += amount;
            CheckLevelUp();
        }

        private void CheckLevelUp()
        {
            int requiredXP = level * 100;
            if (experience >= requiredXP)
            {
                level++;
                experience -= requiredXP;
                OnLevelUp();
            }
        }

        private void OnLevelUp()
        {
            Debug.Log($"Level Up! Now level {level}");
            // Restore health and stamina on level up
            currentHealth = maxHealth;
            currentStamina = maxStamina;
        }

        private void Die()
        {
            Debug.Log("Player died!");
            // Handle player death (respawn, game over, etc.)
        }

        // Getters for UI
        public float GetHealthPercentage() => currentHealth / maxHealth;
        public float GetStaminaPercentage() => currentStamina / maxStamina;
        public int GetLevel() => level;
        public int GetExperience() => experience;
    }
}
