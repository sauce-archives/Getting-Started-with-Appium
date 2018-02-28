# Getting Started with Appium

## Local Appium Native App Test

Now that we can run web tests using Appium 
both locally and on Sauce Labs, we're ready for the next step.

Running tests on Native Applications.

You need to upload your app to the Emulator/Simulator
and you do that by specifying the filename in DesiredCapabilities

For Android:

    capabilities.setCapability("app", "/path/to/yourApp.apk");

or for IOS:

    capabilities.setCapability("app", "/path/to/yourApp.zip");
        
For IOS you can specify either the folder yourApp.app or zip it up.
 