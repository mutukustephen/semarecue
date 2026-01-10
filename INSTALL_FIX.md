# Fix for Build-Tools Installation Issue

## Problem
The SDK licenses were accepted with `sudo`, but Gradle needs Build-Tools 34.0.0 installed and the licenses need to be in the correct location.

## Solution

Run these commands in your terminal:

### 1. Install Build-Tools 34.0.0
```bash
sudo sdkmanager "build-tools;34.0.0"
```

### 2. Fix License Permissions
The licenses are in `/opt/android-sdk/licenses` but Gradle is looking in `/usr/lib/android-sdk/licenses`. We need to copy them:

```bash
sudo mkdir -p /usr/lib/android-sdk/licenses
sudo cp -r /opt/android-sdk/licenses/* /usr/lib/android-sdk/licenses/
```

**OR** if the licenses are in a different location:

```bash
sudo find / -name "android-sdk-license" 2>/dev/null
```

This will show you where the licenses are. Then copy them to `/usr/lib/android-sdk/licenses/`

### 3. Alternative: Use Local SDK

If the above doesn't work, you can download a local Android SDK just for this project:

```bash
# Set ANDROID_HOME to a local directory
export ANDROID_HOME=$HOME/Android/Sdk
mkdir -p $ANDROID_HOME

# Download command-line tools
cd $HOME/Downloads
wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip
unzip commandlinetools-linux-9477386_latest.zip -d $ANDROID_HOME
mkdir -p $ANDROID_HOME/cmdline-tools/latest
mv $ANDROID_HOME/cmdline-tools/* $ANDROID_HOME/cmdline-tools/latest/ 2>/dev/null || true

# Accept licenses and install build-tools
$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager --licenses
$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager "build-tools;34.0.0" "platforms;android-34"

# Add to your shell profile
echo 'export ANDROID_HOME=$HOME/Android/Sdk' >> ~/.bashrc
echo 'export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools' >> ~/.bashrc
source ~/.bashrc
```

### 4. Try Building Again

After fixing the licenses:

```bash
cd /home/mojave/Desktop/semarescue
./gradlew clean
./gradlew installDebug
```

## Quick Fix (Recommended)

Try this first - it installs the build-tools and copies licenses:

```bash
sudo sdkmanager "build-tools;34.0.0"
sudo mkdir -p /usr/lib/android-sdk/licenses
sudo cp /opt/android-sdk/licenses/* /usr/lib/android-sdk/licenses/ 2>/dev/null || echo "Licenses already in place"
cd /home/mojave/Desktop/semarescue
./gradlew installDebug
```
