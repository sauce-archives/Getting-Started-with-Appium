#!/usr/bin/env bash

SCRIPTS=`dirname $0`

$SCRIPTS/download_android_sdk.sh && $SCRIPTS/install_android_sdk_tools.sh && $SCRIPTS/create_android_emulator.sh && $SCRIPTS/launch_android_emulator.sh
