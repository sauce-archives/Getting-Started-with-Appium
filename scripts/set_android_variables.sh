#!/usr/bin/env bash

### set environment variables for Android

echo "setting environment variables for Android"
echo

OS=$(uname -s)
OS=${OS:-"Windows"}

ANDROID_HOME=${ANDROID_HOME:-Android/sdk}
ANDROID_SDK_ROOT=${ANDROID_SDK_ROOT:-Android/sdk/}
ANDROID_PLATFORM=${ANDROID_PLATFORM:-android-26}
ANDROID_DEVICE_NAME=${ANDROID_DEVICE_NAME:-"MyAndroid8Emulator"}
ANDROID_DEVICE=${ANDROID_DEVICE:-"pixel"}
ANDROID_PACKAGE=${ANDROID_PACKAGE:-"system-images;android-26;google_apis;x86"}

alias sdkmanager='"$ANDROID_SDK_ROOT/tools/bin/sdkmanager" --sdk_root="$ANDROID_SDK_ROOT"'
alias avdmanager='"$ANDROID_SDK_ROOT/tools/bin/avdmanager"'
alias emulator='"$ANDROID_SDK_ROOT/tools/emulator"'

echo "OS=$OS"
echo "ANDROID_HOME=$ANDROID_HOME"
echo "ANDROID_SDK_ROOT=$ANDROID_SDK_ROOT"
echo "ANDROID_PLATFORM=$ANDROID_PLATFORM"
echo "ANDROID_DEVICE_NAME=$ANDROID_DEVICE_NAME"
echo "ANDROID_DEVICE=$ANDROID_DEVICE"
echo "ANDROID_PACKAGE=$ANDROID_PACKAGE"
echo

alias sdkmanager
alias avdmanager
alias emulator

echo