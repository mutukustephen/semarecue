# MOJAVE WILD - Unity Setup Guide

This guide will help you set up the MOJAVE WILD project in Unity and prepare it for Android development.

## Prerequisites

### Required Software
1. **Unity Hub** (latest version)
   - Download from: https://unity.com/download

2. **Unity Editor** (2021.3 LTS or newer recommended)
   - Install via Unity Hub
   - Required modules:
     - Android Build Support
     - Android SDK & NDK Tools
     - OpenJDK

3. **Git** (for version control)
   - Already initialized in this project

### Optional Software
- **Android Studio** (for advanced Android debugging)
- **Visual Studio Code** or **Visual Studio** (for C# editing)

## Step-by-Step Setup

### 1. Open Project in Unity

1. Launch **Unity Hub**
2. Click **"Add"** or **"Open"**
3. Navigate to the `MojaveWild` folder
4. Select the folder and click **"Open"**
5. Unity will import the project (this may take a few minutes)

### 2. Install Required Packages

#### SQLite for Unity

**Option A: Unity Asset Store**
1. Open Unity Asset Store in Unity (Window → Asset Store)
2. Search for "SQLite4Unity3d" or "sqlite-net"
3. Download and import

**Option B: Manual Installation**
1. Download sqlite-net-pcl from NuGet
2. Place DLL files in `Assets/Plugins/SQLite/`
3. Download SQLite native libraries for Android:
   - `libsqlite3.so` for ARM64
   - Place in `Assets/Plugins/Android/libs/arm64-v8a/`

#### TextMeshPro
1. Window → TextMeshPro → Import TMP Essential Resources
2. Click "Import"

### 3. Configure Android Build Settings

#### Switch to Android Platform
1. File → Build Settings
2. Select **"Android"**
3. Click **"Switch Platform"** (wait for reimport)

#### Player Settings
1. In Build Settings, click **"Player Settings"**
2. Configure the following:

**Company Name**: Your name or studio
**Product Name**: MOJAVE WILD

**Other Settings**:
- Package Name: `com.yourname.mojavewild`
- Minimum API Level: **Android 7.0 'Nougat' (API level 24)**
- Target API Level: **Android 13 (API level 33)** or highest available
- Scripting Backend: **IL2CPP**
- API Compatibility Level: **.NET Standard 2.1**
- Target Architectures: **ARM64** (required for Google Play)

**Graphics**:
- Graphics API: **OpenGLES3** (or Vulkan for newer devices)
- Multithreaded Rendering: **Enabled**

**Quality Settings**:
1. Edit → Project Settings → Quality
2. Set default quality level to **"Medium"** for mobile
3. Adjust settings:
   - Pixel Light Count: 1
   - Texture Quality: Medium
   - Anisotropic Textures: Per Texture
   - Anti Aliasing: 2x Multi Sampling
   - Shadow Resolution: Medium Resolution

### 4. Create Unity Scenes

You'll need to create the following scenes:

#### MainMenu Scene
1. File → New Scene
2. Create UI elements:
   - Canvas
   - Title text
   - Buttons (New Game, Continue, Encyclopedia, Settings, Exit)
3. Save as `Assets/Scenes/MainMenu.unity`

#### GameWorld Scene
1. File → New Scene
2. Add:
   - Terrain (GameObject → 3D Object → Terrain)
   - Directional Light (for sun)
   - Camera
   - Empty GameObject named "GameManager" (attach GameManager script)
3. Save as `Assets/Scenes/GameWorld.unity`

#### Loading Scene (Optional)
1. File → New Scene
2. Add loading screen UI
3. Save as `Assets/Scenes/Loading.unity`

### 5. Set Up Scene Build Order

1. File → Build Settings
2. Click **"Add Open Scenes"** for each scene
3. Ensure order:
   - 0: MainMenu
   - 1: GameWorld
   - 2: Loading (if created)

### 6. Configure NavMesh for AI

1. Window → AI → Navigation
2. Select your Terrain
3. In Navigation window:
   - Object tab → Mark as **"Navigation Static"**
   - Bake tab → Click **"Bake"**
4. This creates pathfinding data for animal AI

### 7. Create Prefabs

Create empty GameObjects with scripts attached:

#### GameManager Prefab
1. Create Empty GameObject: "GameManager"
2. Add components:
   - GameManager script
   - DatabaseManager script
   - SaveSystem script
3. Drag to `Assets/Prefabs/` to create prefab

#### Player Prefab
1. Create Capsule: GameObject → 3D Object → Capsule
2. Add components:
   - PlayerController script
   - InventorySystem script
   - PlayerInteraction script
   - Character Controller component
3. Add Camera as child object
4. Drag to `Assets/Prefabs/`

#### Animal Prefabs
For each animal type (Elephant, Lion, Zebra, etc.):
1. Create Capsule (temporary model)
2. Add components:
   - AnimalAI script
   - AnimalStateMachine script
   - NavMesh Agent component
3. Configure AnimalAI settings
4. Save as prefab

### 8. Import Assets

#### 3D Models
Place animal and environment models in:
- `Assets/Models/Animals/`
- `Assets/Models/Environment/`
- `Assets/Models/Props/`

#### Textures
Place textures in:
- `Assets/Textures/`

#### Audio
Create folders:
- `Assets/Audio/Music/`
- `Assets/Audio/SFX/`
- `Assets/Audio/Ambient/`

### 9. Test in Unity Editor

1. Open MainMenu scene
2. Click **Play** button
3. Test basic functionality:
   - UI navigation
   - Scene transitions
   - Save/load system

### 10. Build APK

#### First Build
1. File → Build Settings
2. Click **"Build"**
3. Choose output location
4. Wait for build to complete

#### Testing on Device
1. Enable Developer Options on Android device
2. Enable USB Debugging
3. Connect device via USB
4. File → Build Settings → Build And Run

## Troubleshooting

### Common Issues

**"SQLite not found" error**
- Ensure SQLite DLL is in `Assets/Plugins/`
- Check Android native library is in correct architecture folder

**"NavMesh not found" error**
- Bake NavMesh for your terrain (Window → AI → Navigation → Bake)

**Build fails with "IL2CPP error"**
- Ensure Android NDK is installed via Unity Hub
- Check Scripting Backend is set to IL2CPP

**App crashes on startup**
- Check Minimum API Level is 24 or higher
- Verify all required permissions in AndroidManifest.xml

**Low FPS on device**
- Reduce quality settings
- Disable shadows or reduce shadow distance
- Use simpler shaders

## Performance Optimization Tips

1. **Texture Compression**
   - Select textures → Inspector → Override for Android
   - Format: ASTC 6x6 or ETC2

2. **Model Optimization**
   - Keep polygon count low (< 5000 per animal)
   - Use LOD (Level of Detail) groups

3. **Lighting**
   - Use baked lighting where possible
   - Limit real-time lights to 1-2

4. **Physics**
   - Use simple colliders (box, sphere, capsule)
   - Avoid mesh colliders on moving objects

5. **AI Optimization**
   - Update distant AI at lower frequency
   - Limit active AI agents based on distance

## Next Steps

After setup:
1. ✅ Test all core systems
2. ✅ Add 3D models and animations
3. ✅ Create UI screens
4. ✅ Add audio and music
5. ✅ Test on physical Android devices
6. ✅ Optimize performance
7. ✅ Build final APK

## Resources

- [Unity Manual](https://docs.unity3d.com/Manual/index.html)
- [Unity Android Documentation](https://docs.unity3d.com/Manual/android.html)
- [NavMesh Tutorial](https://docs.unity3d.com/Manual/nav-BuildingNavMesh.html)
- [Mobile Optimization](https://docs.unity3d.com/Manual/MobileOptimization.html)

---

**Need Help?** Refer to the main README.md for project structure and system documentation.
