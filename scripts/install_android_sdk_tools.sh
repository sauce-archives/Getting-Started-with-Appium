#!/usr/bin/env bash

### set environment variables for Android

SCRIPTS_DIR=`dirname $0`
source $SCRIPTS_DIR/set_android_variables.sh

### install Android SDK tools

SDKMANAGER="$ANDROID_SDK_ROOT/tools/bin/sdkmanager --sdk_root=$ANDROID_SDK_ROOT"
echo "installing additional Android SDK tools"

if [[ ! -d $ANDROID_SDK_ROOT/build-tools ]]; then
    $SDKMANAGER "build-tools;27.0.3"
else
    echo "build tools is already installed"
fi

if [[ ! -d $ANDROID_SDK_ROOT/emulator ]]; then
    $SDKMANAGER "emulator"
else
    echo "emulator is already installed"
fi

if [[ ! -d $ANDROID_SDK_ROOT/platform-tools ]]; then
    $SDKMANAGER "platform-tools"
else
    echo "platform tools is already installed"
fi

if [[ ! -d $ANDROID_SDK_ROOT/platforms/$ANDROID_PLATFORM ]]; then
    $SDKMANAGER "platforms;$ANDROID_PLATFORM"
    $SDKMANAGER "sources;$ANDROID_PLATFORM"
    $SDKMANAGER "system-images;$ANDROID_PLATFORM;google_apis;x86"
else
    echo "platform is already installed: $ANDROID_PLATFORM"
fi

