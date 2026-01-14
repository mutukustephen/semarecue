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

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

<p align="center">Inspired by Dr.Kaslim</p>
<p align="center">Made by mutukustephen</p>
---

# .env.example

```env
# SemaRescue Environment Configuration Example

# API Keys
# You may need keys for third-party services such as maps or SMS gateways.
# Obtain your API keys at:
# Google Maps: https://console.cloud.google.com/apis/credentials
# Twilio (SMS): https://www.twilio.com/console

GOOGLE_MAPS_API_KEY=your_google_maps_api_key_here
# Use this key for location services and hospital locator features

TWILIO_ACCOUNT_SID=your_twilio_account_sid_here
TWILIO_AUTH_TOKEN=your_twilio_auth_token_here
TWILIO_PHONE_NUMBER=your_twilio_phone_number_here
# Required if the app integrates SMS sending via Twilio

# Database Connection (Local or Remote)
# For app-internal SQLite, this may not be needed.
# If using a remote database, provide connection string here.

DATABASE_URL=jdbc:sqlite:semarescue.db
# Example SQLite connection string for local file-based database

# Security Notes:
# - Keep API keys secret and do NOT commit real keys to public repositories.
# - Use secure storage mechanisms on devices to protect sensitive data.

# App Configuration Defaults
DEFAULT_EMERGENCY_CONTACT_NAME=Emergency Contact
DEFAULT_EMERGENCY_CONTACT_NUMBER=+1234567890

# Feature Toggles
ENABLE_PANIC_MODE=true

```
