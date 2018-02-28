#!/usr/bin/env bash

### set environment variables for ANDROID_SDK_TOOLS

SCRIPTS_DIR=`dirname $0`
source $SCRIPTS_DIR/set_android_variables.sh

### download Androids SDK tools
echo "Downloading Android SDK tools"

case $OS in
    Darwin)
        ANDROID_SDK_TOOLS_ZIP="sdk-tools-darwin-3859397.zip"
        ;;
    Linux)
        ANDROID_SDK_TOOLS_ZIP="sdk-tools-linux-3859397.zip"
        ;;
    Windows)
        ANDROID_SDK_TOOLS_ZIP="sdk-tools-windows-3859397.zip"
        ;;
esac

DOWNLOAD_URL="https://dl.google.com/android/repository/$ANDROID_SDK_TOOLS_ZIP"


if [[ ! -d "$ANDROID_SDK_ROOT" ]]; then
    mkdir -p "$ANDROID_SDK_ROOT"
    unzip -d "$ANDROID_SDK_ROOT" "$ANDROID_SDK_TOOLS_ZIP"

    if [[ ! -f $ANDROID_SDK_TOOLS_ZIP ]]; then
        wget "$DOWNLOAD_URL"
    else
        echo "Adroid SDK tools is already downloaded at $ANDROID_SDK_TOOLS_ZIP"
    fi
else
    echo "Android SDK is already installed at $ANDROID_SDK_ROOT"
fi