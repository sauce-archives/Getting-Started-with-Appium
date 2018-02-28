#!/usr/bin/env bash

### set environment variables for Android

SCRIPTS_DIR=`dirname $0`
source $SCRIPTS_DIR/set_android_variables.sh

### create Android emulator

avdmanager create avd --name "$ANDROID_DEVICE_NAME" \
 --device "$ANDROID_DEVICE" \
 --package "$ANDROID_PACKAGE" \
 --force

