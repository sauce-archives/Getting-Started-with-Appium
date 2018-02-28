#!/usr/bin/env bash

## set environment variables for Android


SCRIPTS_DIR=`dirname $0`
source $SCRIPTS_DIR/set_android_variables.sh

$ANDROID_SDK_ROOT/emulator/emulator -avd $ANDROID_DEVICE_NAME