using UnityEngine;
using UnityEngine.AI;

namespace MojaveWild.AI
{
    /// <summary>
    /// Main AI controller for animals
    /// Implements finite state machine for realistic animal behavior
    /// </summary>
    [RequireComponent(typeof(NavMeshAgent))]
    public class AnimalAI : MonoBehaviour
    {
        [Header("Animal Info")]
        public string speciesName = "Zebra";
        public AnimalType animalType = AnimalType.Herbivore;
        public bool isSocial = true;

        [Header("Needs")]
        [Range(0f, 1f)] public float hunger = 0.3f;
        [Range(0f, 1f)] public float thirst = 0.3f;
        [Range(0f, 1f)] public float fear = 0f;
        [Range(0f, 1f)] public float energy = 1f;

        [Header("Need Rates")]
        public float hungerRate = 0.05f;
        public float thirstRate = 0.08f;
        public float energyDrainRate = 0.03f;
        public float energyRegenRate = 0.1f;

        [Header("Behavior Settings")]
        public float wanderRadius = 20f;
        public float detectionRange = 15f;
        public float fleeDistance = 30f;
        public float walkSpeed = 2f;
        public float runSpeed = 8f;

        [Header("Points of Interest")]
        public Transform waterSource;
        public Transform[] grazingSpots;

        private NavMeshAgent agent;
        private AnimalStateMachine stateMachine;
        private Vector3 homePosition;
        private float stateTimer = 0f;

        public AnimalState CurrentState => stateMachine?.currentState ?? AnimalState.Idle;

        private void Awake()
        {
            agent = GetComponent<NavMeshAgent>();
            homePosition = transform.position;
        }

        private void Start()
        {
            // Initialize state machine
            stateMachine = gameObject.AddComponent<AnimalStateMachine>();
            stateMachine.Initialize(this);

            // Find nearby water source if not assigned
            if (waterSource == null)
            {
                GameObject water = GameObject.FindGameObjectWithTag("WaterSource");
                if (water != null)
                {
                    waterSource = water.transform;
                }
            }

            // Find grazing spots if not assigned
            if (grazingSpots == null || grazingSpots.Length == 0)
            {
                GameObject[] spots = GameObject.FindGameObjectsWithTag("GrazingSpot");
                grazingSpots = new Transform[spots.Length];
                for (int i = 0; i < spots.Length; i++)
                {
                    grazingSpots[i] = spots[i].transform;
                }
            }
        }

        private void Update()
        {
            UpdateNeeds();
            stateMachine?.UpdateState();
        }

        private void UpdateNeeds()
        {
            // Increase needs over time
            hunger += hungerRate * Time.deltaTime;
            thirst += thirstRate * Time.deltaTime;

            // Energy management
            if (CurrentState == AnimalState.Sleep)
            {
                energy += energyRegenRate * Time.deltaTime;
            }
            else
            {
                energy -= energyDrainRate * Time.deltaTime;
            }

            // Clamp values
            hunger = Mathf.Clamp01(hunger);
            thirst = Mathf.Clamp01(thirst);
            energy = Mathf.Clamp01(energy);
            fear = Mathf.Clamp01(fear);

            // Decay fear over time
            if (fear > 0)
            {
                fear -= 0.1f * Time.deltaTime;
            }
        }

        public void MoveTo(Vector3 destination, bool running = false)
        {
            if (agent != null && agent.isOnNavMesh)
            {
                agent.SetDestination(destination);
                agent.speed = running ? runSpeed : walkSpeed;
            }
        }

        public void StopMoving()
        {
            if (agent != null && agent.isOnNavMesh)
            {
                agent.ResetPath();
            }
        }

        public bool HasReachedDestination()
        {
            if (agent == null || !agent.isOnNavMesh) return false;
            return !agent.pathPending && agent.remainingDistance <= agent.stoppingDistance;
        }

        public Vector3 GetRandomWanderPoint()
        {
            Vector3 randomDirection = Random.insideUnitSphere * wanderRadius;
            randomDirection += homePosition;
            
            NavMeshHit hit;
            if (NavMesh.SamplePosition(randomDirection, out hit, wanderRadius, NavMesh.AllAreas))
            {
                return hit.position;
            }

            return homePosition;
        }

        public Transform GetNearestGrazingSpot()
        {
            if (grazingSpots == null || grazingSpots.Length == 0) return null;

            Transform nearest = grazingSpots[0];
            float nearestDistance = Vector3.Distance(transform.position, nearest.position);

            foreach (Transform spot in grazingSpots)
            {
                float distance = Vector3.Distance(transform.position, spot.position);
                if (distance < nearestDistance)
                {
                    nearest = spot;
                    nearestDistance = distance;
                }
            }

            return nearest;
        }

        public GameObject DetectNearbyThreat()
        {
            Collider[] nearbyObjects = Physics.OverlapSphere(transform.position, detectionRange);

            foreach (Collider col in nearbyObjects)
            {
                // Check for predators
                if (animalType == AnimalType.Herbivore)
                {
                    AnimalAI otherAnimal = col.GetComponent<AnimalAI>();
                    if (otherAnimal != null && otherAnimal.animalType == AnimalType.Carnivore)
                    {
                        return col.gameObject;
                    }
                }

                // Check for player (if too close)
                if (col.CompareTag("Player"))
                {
                    float distance = Vector3.Distance(transform.position, col.transform.position);
                    if (distance < detectionRange * 0.5f)
                    {
                        return col.gameObject;
                    }
                }
            }

            return null;
        }

        public void Drink()
        {
            thirst = Mathf.Max(0, thirst - 0.5f);
            Debug.Log($"{speciesName} is drinking water");
        }

        public void Eat()
        {
            hunger = Mathf.Max(0, hunger - 0.3f);
            Debug.Log($"{speciesName} is eating");
        }

        public void Rest()
        {
            Debug.Log($"{speciesName} is resting");
        }

        private void OnDrawGizmosSelected()
        {
            // Visualize detection range
            Gizmos.color = Color.yellow;
            Gizmos.DrawWireSphere(transform.position, detectionRange);

            // Visualize wander radius
            Gizmos.color = Color.green;
            Vector3 home = Application.isPlaying ? homePosition : transform.position;
            Gizmos.DrawWireSphere(home, wanderRadius);
        }
    }

    public enum AnimalType
    {
        Herbivore,
        Carnivore,
        Omnivore
    }

    public enum AnimalState
    {
        Idle,
        Wander,
        SeekWater,
        Drink,
        SeekFood,
        Graze,
        Flee,
        Sleep
    }
}
