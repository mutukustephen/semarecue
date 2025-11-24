using UnityEngine;

namespace MojaveWild.Missions
{
    /// <summary>
    /// Animal rescue mission - locate and save distressed animals
    /// </summary>
    public class AnimalRescueMission : Mission
    {
        public string targetAnimalType;
        public Vector3 rescueLocation;
        public bool animalFound = false;
        public bool animalRescued = false;

        private GameObject targetAnimal;

        public override void StartMission()
        {
            base.StartMission();
            type = MissionType.AnimalRescue;
            
            // Spawn or mark target animal
            SpawnTargetAnimal();
        }

        public override void UpdateMission()
        {
            base.UpdateMission();

            if (!isActive || isCompleted || isFailed) return;

            // Check if player found the animal
            if (!animalFound)
            {
                CheckAnimalFound();
            }

            // Check if animal is rescued
            if (animalFound && !animalRescued)
            {
                CheckAnimalRescued();
            }

            // Complete mission when animal is rescued
            if (animalRescued)
            {
                isCompleted = true;
            }
        }

        private void SpawnTargetAnimal()
        {
            // In a full implementation, this would spawn an animal at the rescue location
            // For now, we'll just log it
            Debug.Log($"Rescue mission: Find {targetAnimalType} at {rescueLocation}");
        }

        private void CheckAnimalFound()
        {
            // Check if player is near rescue location
            Player.PlayerController player = Object.FindObjectOfType<Player.PlayerController>();
            if (player != null)
            {
                float distance = Vector3.Distance(player.transform.position, rescueLocation);
                if (distance < 10f)
                {
                    animalFound = true;
                    Debug.Log($"Found the distressed {targetAnimalType}!");
                }
            }
        }

        private void CheckAnimalRescued()
        {
            // Check if player has used medical supplies or completed rescue action
            Player.InventorySystem inventory = Object.FindObjectOfType<Player.InventorySystem>();
            if (inventory != null)
            {
                // Simplified: assume rescue is complete if player is near and has medical kit
                Player.PlayerController player = Object.FindObjectOfType<Player.PlayerController>();
                if (player != null)
                {
                    float distance = Vector3.Distance(player.transform.position, rescueLocation);
                    if (distance < 5f && inventory.HasItem("medical_kit"))
                    {
                        inventory.RemoveItem("medical_kit", 1);
                        animalRescued = true;
                        Debug.Log($"{targetAnimalType} successfully rescued!");
                    }
                }
            }
        }

        public override float GetProgress()
        {
            if (animalRescued) return 1.0f;
            if (animalFound) return 0.5f;
            return 0.0f;
        }
    }

    /// <summary>
    /// Fire fighting mission - extinguish bushfires
    /// </summary>
    public class FireFightingMission : Mission
    {
        public Vector3 fireLocation;
        public int firesToExtinguish;
        public int firesExtinguished = 0;

        public override void StartMission()
        {
            base.StartMission();
            type = MissionType.FireFighting;
            
            Debug.Log($"Fire fighting mission: Extinguish {firesToExtinguish} fires at {fireLocation}");
        }

        public override void UpdateMission()
        {
            base.UpdateMission();

            if (!isActive || isCompleted || isFailed) return;

            // Check if all fires are extinguished
            if (firesExtinguished >= firesToExtinguish)
            {
                isCompleted = true;
                Debug.Log("All fires extinguished!");
            }
        }

        public void ExtinguishFire()
        {
            firesExtinguished++;
            Debug.Log($"Fire extinguished! {firesExtinguished}/{firesToExtinguish}");
        }

        public override float GetProgress()
        {
            return (float)firesExtinguished / firesToExtinguish;
        }
    }

    /// <summary>
    /// Medical aid mission - provide first aid to injured animals
    /// </summary>
    public class MedicalAidMission : Mission
    {
        public string targetAnimalType;
        public Vector3 injuryLocation;
        public int medicalSuppliesNeeded;
        public bool animalTreated = false;

        public override void StartMission()
        {
            base.StartMission();
            type = MissionType.MedicalAid;
            
            Debug.Log($"Medical aid mission: Treat injured {targetAnimalType} at {injuryLocation}");
        }

        public override void UpdateMission()
        {
            base.UpdateMission();

            if (!isActive || isCompleted || isFailed) return;

            if (!animalTreated)
            {
                CheckTreatment();
            }

            if (animalTreated)
            {
                isCompleted = true;
            }
        }

        private void CheckTreatment()
        {
            Player.PlayerController player = Object.FindObjectOfType<Player.PlayerController>();
            Player.InventorySystem inventory = Object.FindObjectOfType<Player.InventorySystem>();

            if (player != null && inventory != null)
            {
                float distance = Vector3.Distance(player.transform.position, injuryLocation);
                
                if (distance < 5f && inventory.HasItem("medical_kit", medicalSuppliesNeeded))
                {
                    inventory.RemoveItem("medical_kit", medicalSuppliesNeeded);
                    animalTreated = true;
                    Debug.Log($"Successfully treated the injured {targetAnimalType}!");
                }
            }
        }

        public override float GetProgress()
        {
            return animalTreated ? 1.0f : 0.0f;
        }
    }

    /// <summary>
    /// Animal relocation mission - move animals to safer areas
    /// </summary>
    public class AnimalRelocationMission : Mission
    {
        public Vector3 sourceLocation;
        public Vector3 destinationLocation;
        public int animalsToRelocate;
        public int animalsRelocated = 0;

        public override void StartMission()
        {
            base.StartMission();
            type = MissionType.AnimalRelocation;
            
            Debug.Log($"Relocation mission: Move {animalsToRelocate} animals from {sourceLocation} to {destinationLocation}");
        }

        public override void UpdateMission()
        {
            base.UpdateMission();

            if (!isActive || isCompleted || isFailed) return;

            if (animalsRelocated >= animalsToRelocate)
            {
                isCompleted = true;
                Debug.Log("All animals successfully relocated!");
            }
        }

        public void RelocateAnimal()
        {
            animalsRelocated++;
            Debug.Log($"Animal relocated! {animalsRelocated}/{animalsToRelocate}");
        }

        public override float GetProgress()
        {
            return (float)animalsRelocated / animalsToRelocate;
        }
    }

    /// <summary>
    /// Poacher tracking mission - investigate illegal activities
    /// </summary>
    public class PoacherTrackingMission : Mission
    {
        public Vector3 trackingStartLocation;
        public int evidenceToCollect;
        public int evidenceCollected = 0;

        public override void StartMission()
        {
            base.StartMission();
            type = MissionType.PoacherTracking;
            
            Debug.Log($"Poacher tracking mission: Collect {evidenceToCollect} pieces of evidence starting at {trackingStartLocation}");
        }

        public override void UpdateMission()
        {
            base.UpdateMission();

            if (!isActive || isCompleted || isFailed) return;

            if (evidenceCollected >= evidenceToCollect)
            {
                isCompleted = true;
                Debug.Log("All evidence collected! Poachers reported.");
            }
        }

        public void CollectEvidence()
        {
            evidenceCollected++;
            Debug.Log($"Evidence collected! {evidenceCollected}/{evidenceToCollect}");
        }

        public override float GetProgress()
        {
            return (float)evidenceCollected / evidenceToCollect;
        }
    }
}
