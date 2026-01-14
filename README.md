# semarecue 🚑

<p align="center">
  <img alt="Build Status" src="https://img.shields.io/github/actions/workflow/status/mutukustephen/semarecue/android.yml?branch=main&style=for-the-badge&label=Build%20Status">
  <img alt="License" src="https://img.shields.io/github/license/mutukustephen/semarecue?style=for-the-badge&label=License">
  <img alt="Last Commit" src="https://img.shields.io/github/last-commit/mutukustephen/semarecue?style=for-the-badge&label=Last%20Commit">
</p>

SemaRescue is a mobile application designed to provide quick, reliable first aid guidelines and emergency management tools. It helps users access vital medical information, log incidents, and contact emergency services efficiently in critical situations.

## ✨ Features

- 🏥 Manage and display comprehensive medical profiles (e.g., allergies, conditions, blood type).
- 🚨 Log and track emergency incidents with timestamps and locations.
- 📞 Configure and quickly contact emergency contacts.
- 📖 Access detailed multi-step instructional first aid guides.
- 🧭 Utilize device utilities such as location tracking, SMS, phone calls, flashlight, and metronome for CPR timing.
- ⚙️ Modular architecture with Dependency Injection for scalability and maintainability.

## 🚀 Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/mutukustephen/semarecue.git
   cd semarecue
   ```

2. **Set up your development environment**

   - Install [Java JDK 11+](https://adoptium.net/)
   - Install [Android Studio](https://developer.android.com/studio)
   - Ensure Kotlin plugin is enabled in Android Studio

3. **Build the project**

   Using the Gradle wrapper:

   ```bash
   ./gradlew build
   ```

   Or run the provided installation and build script:

   ```bash
   ./install_and_build.sh
   ```

4. **Review any environment-specific fixes**

   Check `INSTALL_FIX.md` for troubleshooting and additional setup notes.

## 💻 Usage

- Launch the app on an Android device or emulator.
- Navigate through the app to:
  - View and update your medical profile.
  - Access first aid guides tailored for various emergencies.
  - Log incidents as they occur, with location and time.
  - Quickly contact emergency contacts via call or SMS.
  - Activate panic mode utilities, including flashlight and metronome for CPR.

**For Developers:**

- Use the included Python scripts (`gen_100_guides.py`, `generate_200_guides.py`, `create_full_guides.py`) to generate or update instructional guide data.
- Utility classes in the app handle core device functions like SMS and location; extend these to integrate new safety features.

## 🤝 Contributing

We welcome contributions to help transform SemaRescue from a structured foundation into a fully functional first aid app.

- Fork the repository and create a feature branch.
- Follow the existing Kotlin architectural patterns.
- Test your changes thoroughly.
- Submit a pull request with a clear description.

For detailed guidelines, please open an issue or contact the maintainer.

## 📄 License

This project is licensed under the **MIT License**. 

<p align="center">Inspired by Dr.Kaslim</p>
<p align="center">Made by mutukustephen</p>
---

