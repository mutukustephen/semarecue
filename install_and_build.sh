#!/bin/bash
# Quick install and build script for SemaRescue

echo "Installing Android SDK Platform 34..."
sudo apt-get install -y google-android-platform-34-installer

echo ""
echo "Building SemaRescue..."
./gradlew assembleDebug

echo ""
echo "✅ Build complete!"
echo "APK: app/build/outputs/apk/debug/app-debug.apk"
echo ""
echo "To install on your device:"
echo "1. Check your phone for USB debugging authorization prompt"
echo "2. Run: adb devices (should show 'device' not 'unauthorized')"
echo "3. Run: ./gradlew installDebug"
