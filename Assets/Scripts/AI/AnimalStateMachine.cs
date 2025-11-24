using UnityEngine;

namespace MojaveWild.AI
{
    /// <summary>
    /// Finite State Machine for animal behavior
    /// Manages state transitions based on animal needs and environment
    /// </summary>
    public class AnimalStateMachine : MonoBehaviour
    {
        public AnimalState currentState = AnimalState.Idle;
        private AnimalAI animal;
        private float stateTimer = 0f;
        private float idleTime = 3f;
        private float drinkTime = 5f;
        private float grazeTime = 8f;
        private GameObject threatTarget;

        public void Initialize(AnimalAI animalAI)
        {
            animal = animalAI;
            TransitionToState(AnimalState.Idle);
        }

        public void UpdateState()
        {
            if (animal == null) return;

            stateTimer += Time.deltaTime;

            // Check for threats (highest priority)
            GameObject threat = animal.DetectNearbyThreat();
            if (threat != null && currentState != AnimalState.Flee)
            {
                threatTarget = threat;
                animal.fear = 1f;
                TransitionToState(AnimalState.Flee);
                return;
            }

            // State-specific behavior
            switch (currentState)
            {
                case AnimalState.Idle:
                    UpdateIdleState();
                    break;

                case AnimalState.Wander:
                    UpdateWanderState();
                    break;

                case AnimalState.SeekWater:
                    UpdateSeekWaterState();
                    break;

                case AnimalState.Drink:
                    UpdateDrinkState();
                    break;

                case AnimalState.SeekFood:
                    UpdateSeekFoodState();
                    break;

                case AnimalState.Graze:
                    UpdateGrazeState();
                    break;

                case AnimalState.Flee:
                    UpdateFleeState();
                    break;

                case AnimalState.Sleep:
                    UpdateSleepState();
                    break;
            }
        }

        private void UpdateIdleState()
        {
            animal.StopMoving();

            if (stateTimer > idleTime)
            {
                DecideNextState();
            }
        }

        private void UpdateWanderState()
        {
            if (animal.HasReachedDestination())
            {
                TransitionToState(AnimalState.Idle);
            }
        }

        private void UpdateSeekWaterState()
        {
            if (animal.waterSource != null)
            {
                animal.MoveTo(animal.waterSource.position);

                if (animal.HasReachedDestination())
                {
                    TransitionToState(AnimalState.Drink);
                }
            }
            else
            {
                // No water source found, wander instead
                TransitionToState(AnimalState.Wander);
            }
        }

        private void UpdateDrinkState()
        {
            animal.StopMoving();
            
            if (stateTimer > drinkTime)
            {
                animal.Drink();
                TransitionToState(AnimalState.Idle);
            }
        }

        private void UpdateSeekFoodState()
        {
            Transform grazingSpot = animal.GetNearestGrazingSpot();
            
            if (grazingSpot != null)
            {
                animal.MoveTo(grazingSpot.position);

                if (animal.HasReachedDestination())
                {
                    TransitionToState(AnimalState.Graze);
                }
            }
            else
            {
                // No grazing spot found, wander instead
                TransitionToState(AnimalState.Wander);
            }
        }

        private void UpdateGrazeState()
        {
            animal.StopMoving();

            if (stateTimer > grazeTime)
            {
                animal.Eat();
                TransitionToState(AnimalState.Idle);
            }
        }

        private void UpdateFleeState()
        {
            if (threatTarget != null)
            {
                // Run away from threat
                Vector3 fleeDirection = (transform.position - threatTarget.transform.position).normalized;
                Vector3 fleeTarget = transform.position + fleeDirection * animal.fleeDistance;
                animal.MoveTo(fleeTarget, running: true);
            }

            // Stop fleeing if far enough or threat is gone
            if (stateTimer > 10f || animal.fear < 0.3f)
            {
                threatTarget = null;
                animal.fear = 0f;
                TransitionToState(AnimalState.Idle);
            }
        }

        private void UpdateSleepState()
        {
            animal.StopMoving();
            animal.Rest();

            // Wake up when energy is restored or it's daytime
            if (animal.energy > 0.8f || !IsNightTime())
            {
                TransitionToState(AnimalState.Idle);
            }
        }

        private void DecideNextState()
        {
            // Priority-based decision making

            // 1. Sleep if night and low energy
            if (IsNightTime() && animal.energy < 0.3f)
            {
                TransitionToState(AnimalState.Sleep);
                return;
            }

            // 2. Drink if very thirsty
            if (animal.thirst > 0.7f)
            {
                TransitionToState(AnimalState.SeekWater);
                return;
            }

            // 3. Eat if very hungry
            if (animal.hunger > 0.7f)
            {
                TransitionToState(AnimalState.SeekFood);
                return;
            }

            // 4. Drink if moderately thirsty
            if (animal.thirst > 0.5f)
            {
                TransitionToState(AnimalState.SeekWater);
                return;
            }

            // 5. Eat if moderately hungry
            if (animal.hunger > 0.5f)
            {
                TransitionToState(AnimalState.SeekFood);
                return;
            }

            // 6. Rest if low energy
            if (animal.energy < 0.4f)
            {
                TransitionToState(AnimalState.Sleep);
                return;
            }

            // 7. Default: Wander
            TransitionToState(AnimalState.Wander);
        }

        private void TransitionToState(AnimalState newState)
        {
            // Exit current state
            OnStateExit(currentState);

            // Update state
            AnimalState previousState = currentState;
            currentState = newState;
            stateTimer = 0f;

            // Enter new state
            OnStateEnter(newState);

            Debug.Log($"{animal.speciesName}: {previousState} -> {newState}");
        }

        private void OnStateEnter(AnimalState state)
        {
            switch (state)
            {
                case AnimalState.Wander:
                    Vector3 wanderPoint = animal.GetRandomWanderPoint();
                    animal.MoveTo(wanderPoint);
                    break;

                case AnimalState.SeekWater:
                    if (animal.waterSource != null)
                    {
                        animal.MoveTo(animal.waterSource.position);
                    }
                    break;

                case AnimalState.SeekFood:
                    Transform grazingSpot = animal.GetNearestGrazingSpot();
                    if (grazingSpot != null)
                    {
                        animal.MoveTo(grazingSpot.position);
                    }
                    break;
            }
        }

        private void OnStateExit(AnimalState state)
        {
            // Cleanup when leaving a state
        }

        private bool IsNightTime()
        {
            // Check if it's night (will integrate with day-night cycle later)
            Environment.DayNightCycle dayNight = FindObjectOfType<Environment.DayNightCycle>();
            if (dayNight != null)
            {
                return dayNight.IsNight();
            }

            // Default: check Unity's time
            return false;
        }
    }
}
