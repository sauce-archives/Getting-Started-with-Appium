# Getting Started with Appium

## 4 - Local Appium Web Tests

To run your tests on a local Appium Server 
-- instead of in Sauce Labs cloud

You need to run a local Appium server
You can start an Appium server from Appium Desktop

Or from the command line
First install Appium server    
    
    npm install -g appium
    
 Then start appium server
 
    appium
    
In your test, specify in your test to use your local Appium server instead of Sauce Labs

    remoteUrl = "http://localhost:4723/wd/host

You don't have to worry about authenticating with Sauce Labs or reporting test results,
so you can remote those steps.

But, in order for your tests to run locally,
you have to have an iOS Simulator or Android emulator running locally.

Note the deviceName (and possibly platformVersion) may be different
on your local emulator/simulator than what is available in Sauce Labs.

Check out the examples at:
LocalAppiumWebTestIOS.java
LocalAppiumWebTestAndroid.java

One more thing to note:
The version of Chrome on Android devices may be incompatible 
with the version of chromedriver included with your Appium server.

See this reference documentation:
https://appium.io/docs/en/writing-running-appium/web/chromedriver

You can specify the chromedriver version when you build appium server with:
    
    npm install appium --chromedriver-version="2.31"
    
This is the version that happens to work with Chrome 58, which is installed on Android 8.0
 



