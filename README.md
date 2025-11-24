# MOJAVE WILD - Wildlife Conservation Game

![Version](https://img.shields.io/badge/version-1.0.0-blue)
![Unity](https://img.shields.io/badge/Unity-2021.3%2B-green)
![Platform](https://img.shields.io/badge/platform-Android-brightgreen)

## 🦁 Overview

MOJAVE WILD is a fully offline educational–adventure Android game that immerses players in the experience of being a wildlife ranger in a Kenyan savanna ecosystem. Through engaging missions and realistic animal AI, players learn about wildlife conservation while having fun.

## ✨ Features

### Core Gameplay
- **🎮 Offline Play**: No internet required - all data stored locally
- **🌍 Dynamic Savanna**: Explore grasslands, rivers, hills, and wildlife zones
- **🦓 Realistic Animal AI**: Animals with needs-based behavior (hunger, thirst, fear, energy)
- **📋 Mission System**: Rescue animals, fight fires, provide medical aid, track poachers
- **📚 Educational Content**: Unlock wildlife facts and conservation knowledge
- **💾 Auto-Save**: Progress automatically saved using SQLite

### Game Systems
- **Day-Night Cycle**: Dynamic lighting and time-based gameplay
- **Fire Propagation**: Realistic bushfire spread with wind effects
- **Inventory Management**: Collect and use medical supplies, food, and equipment
- **Experience & Leveling**: Progress through ranger ranks
- **Encyclopedia**: Comprehensive wildlife database

## 🛠️ Technology Stack

| Component | Technology |
|-----------|-----------|
| Game Engine | Unity (C#) |
| Database | SQLite |
| Platform | Android (API 24+) |
| Data Format | JSON |

## 📁 Project Structure

```
MojaveWild/
├── Assets/
│   ├── Scripts/
│   │   ├── Core/              # Game management, save system, database
│   │   ├── Player/            # Player controller, inventory, interaction
│   │   ├── AI/                # Animal behavior and state machines
│   │   ├── Missions/          # Mission system and types
│   │   ├── Environment/       # Day-night cycle, weather, fire
│   │   └── UI/                # User interface scripts
│   ├── Models/                # 3D models (animals, environment, props)
│   ├── Materials/             # Materials and shaders
│   ├── Textures/              # Texture assets
│   ├── Animations/            # Animation clips and controllers
│   ├── Prefabs/               # Reusable game objects
│   ├── Scenes/                # Unity scenes
│   └── Resources/
│       └── Data/              # JSON data files
└── README.md
```

## 🎯 Mission Types

1. **Animal Rescue** - Locate and save distressed wildlife
2. **Fire Fighting** - Extinguish bushfires before they spread
3. **Medical Aid** - Provide first aid to injured animals
4. **Animal Relocation** - Move animals to safer habitats
5. **Poacher Tracking** - Investigate and report illegal activities

## 🤖 Animal AI System

Animals use a Finite State Machine (FSM) with the following states:

```
Idle → Wander → Seek Water → Drink
                ↓
              Seek Food → Graze
                ↓
              Sleep ← (if night/low energy)
                ↓
              Flee ← (if threat detected)
```

### Need-Based Behavior
- **Hunger**: Increases over time, triggers seeking food
- **Thirst**: Increases over time, triggers seeking water
- **Energy**: Decreases during activity, regenerates during sleep
- **Fear**: Spikes when threats detected, causes fleeing

## 🔥 Fire Propagation Algorithm

```csharp
fireChance = (baseRate + windEffect) * tileFuel
if (Random.value < fireChance) {
    IgniteNeighborTile();
}
```

Fire spreads based on:
- Base spread rate
- Wind direction and strength
- Tile fuel amount
- Neighboring tile positions

## 💾 Database Schema

### PlayerProgress
- level, experience, currentMissionId
- playTime, position (x, y, z)

### Inventory
- itemId, quantity

### CompletedMissions
- missionId, completionTime, score

### UnlockedEncyclopedia
- entryId, unlockedAt

## 🎮 Getting Started

### Prerequisites
- Unity 2021.3 LTS or newer
- Android Build Support module
- SQLite for Unity package

### Setup Instructions

1. **Clone or Download** this project
2. **Open in Unity Hub**
3. **Install Dependencies**:
   - SQLite (via Package Manager or Asset Store)
   - TextMeshPro (if not already installed)
4. **Configure Android Build**:
   - File → Build Settings → Android
   - Switch Platform
   - Player Settings → Minimum API Level: 24
5. **Add Scenes to Build**:
   - MainMenu.unity
   - GameWorld.unity

### Building for Android

1. Connect Android device or set up emulator
2. File → Build Settings → Build
3. Choose output location for APK
4. Install APK on device

## 🎨 Asset Requirements

The project structure is ready for assets. You'll need to add:

### 3D Models
- African animals (elephant, lion, zebra, giraffe, rhino, buffalo, leopard)
- Environment (terrain, trees, rocks, water)
- Props (ranger base, vehicles, equipment)

### Textures
- Terrain textures (grass, dirt, sand)
- Animal textures
- UI elements

### Audio
- Animal sounds
- Ambient savanna sounds
- Music tracks
- UI sound effects

## 📱 Performance Optimization

Target: **30+ FPS on low-end Android devices (2GB RAM)**

Optimizations:
- Mobile-optimized shaders
- Texture compression (ASTC)
- LOD (Level of Detail) for models
- Occlusion culling
- Object pooling
- AI update throttling (10-15 FPS for distant animals)

## 🧪 Testing

### Unit Tests
- Player movement and interaction
- Inventory system
- Save/load functionality
- Mission generation
- AI state transitions

### Performance Tests
- FPS monitoring on target devices
- Memory usage profiling
- Battery consumption
- APK size verification

## 📝 Educational Content

The game teaches:
- Wildlife conservation principles
- African ecosystem dynamics
- Ranger responsibilities
- Anti-poaching efforts
- Habitat management
- Animal behavior and biology

## 🚀 Future Enhancements

- Additional maps (Mara, Tsavo)
- Crafting system for ranger tools
- Local multiplayer via Bluetooth
- Cinematic storyline mode
- Localized voice acting (Kiswahili/Kimeru)
- More animal species
- Seasonal weather changes

## 📄 License

This project is for educational purposes.

## 👥 Credits

**Developer**: MOJAVE WILD Team
**Inspired by**: Kenyan National Parks and Wildlife Conservation Efforts

## 🤝 Contributing

This is an educational project. Suggestions and improvements are welcome!

## 📞 Support

For issues or questions about the game implementation, please refer to the documentation in the `Assets/Scripts/` folders.

---

**Made with ❤️ for Wildlife Conservation Education**
