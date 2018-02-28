# Getting Started with Appium

The goal of this course is to introduce you to Appium,
the open source tool for automating tests on Android and iOS.

You should be able to run Appium scripts on your local system
with Android emulators (using Android Studio or SDK Tools)
and iOS simulators (using XCode)
with Appium Server
or in the cloud using Sauce Labs infrastructure.

##  1 - Setup

### Java JDK

These test examples use Java with JUnit, Maven, and the Appium Java client library.
You will need to have the Java JDK version 8 installed to execute these scripts.

The Oracle Java SDK can be downloaded here:
http://www.oracle.com/technetwork/java/javase/downloads/index.html

### Intellij IDEA

It's also suggested that you use a Java IDE.  I recommend Intellij Community Edition:

https://www.jetbrains.com/idea/downloadGetting

### Android Studio or SDK Tools

In order to run tests on local Android emulators, you will need to install Android Studio.

https://developer.android.com/studio/index.html

Alternately, you can install just the Android SDK tools and create and launch emulators from the command line.

### Xcode

If you're using a Mac, you can also run IOS Simluators from Xcode.

Xcode is available in the App Store:

https://developer.apple.com/xcode/

### Node.js

To run Appium Server, you will need the Node.js Javascript runtime.
It is available from https://nodejs.org

You can alternately use nvm to install multiple versions of node.js

https://github.com/creationix/nvm

	nvm install stable

On Mac, you can also install node.js using homebrew:

https://brew.sh

	brew install node

### Appium Server

Install appium server from the command line using NPM (included with Node.js):

	npm install -g appium

### Appium Desktop

Appium Desktop is a graphical interface that allows you start and stop Appium servers, load app on mobile devices, inspect apps elements for locators, and can generate sample code.

It can be downloaded from https://appium.io
