using UnityEngine;

namespace MojaveWild.Player
{
    /// <summary>
    /// Handles player interaction with world objects, animals, and mission items
    /// Uses raycast detection for mobile-friendly tap interactions
    /// </summary>
    public class PlayerInteraction : MonoBehaviour
    {
        [Header("Interaction Settings")]
        public float interactionRange = 3f;
        public LayerMask interactableLayer;
        public KeyCode interactKey = KeyCode.E;

        [Header("UI")]
        public GameObject interactionPrompt;
        public UnityEngine.UI.Text promptText;

        private Camera mainCamera;
        private IInteractable currentInteractable;
        private bool canInteract = false;

        private void Start()
        {
            mainCamera = Camera.main;

            if (interactionPrompt != null)
            {
                interactionPrompt.SetActive(false);
            }
        }

        private void Update()
        {
            CheckForInteractable();
            HandleInteractionInput();
        }

        private void CheckForInteractable()
        {
            Ray ray = new Ray(transform.position + Vector3.up, transform.forward);
            RaycastHit hit;

            if (Physics.Raycast(ray, out hit, interactionRange, interactableLayer))
            {
                IInteractable interactable = hit.collider.GetComponent<IInteractable>();

                if (interactable != null)
                {
                    if (currentInteractable != interactable)
                    {
                        currentInteractable = interactable;
                        ShowInteractionPrompt(interactable.GetInteractionPrompt());
                    }
                    canInteract = true;
                    return;
                }
            }

            // No interactable found
            if (canInteract)
            {
                HideInteractionPrompt();
                currentInteractable = null;
                canInteract = false;
            }
        }

        private void HandleInteractionInput()
        {
            // Keyboard input (for testing)
            if (Input.GetKeyDown(interactKey) && canInteract)
            {
                Interact();
            }

            // Mobile touch input
            if (Input.touchCount > 0 && canInteract)
            {
                Touch touch = Input.GetTouch(0);
                if (touch.phase == TouchPhase.Began)
                {
                    // Check if touch is on interaction button (implement UI button instead)
                    // For now, any touch will interact if in range
                }
            }
        }

        public void Interact()
        {
            if (currentInteractable != null && canInteract)
            {
                currentInteractable.OnInteract(gameObject);
                Debug.Log($"Interacted with: {currentInteractable.GetInteractionPrompt()}");
            }
        }

        private void ShowInteractionPrompt(string message)
        {
            if (interactionPrompt != null)
            {
                interactionPrompt.SetActive(true);
                if (promptText != null)
                {
                    promptText.text = message;
                }
            }
        }

        private void HideInteractionPrompt()
        {
            if (interactionPrompt != null)
            {
                interactionPrompt.SetActive(false);
            }
        }

        private void OnDrawGizmosSelected()
        {
            // Visualize interaction range in editor
            Gizmos.color = Color.yellow;
            Gizmos.DrawRay(transform.position + Vector3.up, transform.forward * interactionRange);
            Gizmos.DrawWireSphere(transform.position + transform.forward * interactionRange, 0.3f);
        }
    }

    /// <summary>
    /// Interface for interactable objects
    /// </summary>
    public interface IInteractable
    {
        string GetInteractionPrompt();
        void OnInteract(GameObject player);
    }
}
