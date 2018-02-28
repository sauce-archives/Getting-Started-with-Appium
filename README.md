# Getting Started with Appium

## 3 - Simple Appium Web Test

The next step is to convert your Selenium test into an Appium test.

Appium is based on Selenium and shares the same client libraries.
They both use the WebDriver JSON wire protocol too.
But Appium has additional capabilities and features that are specific to testing mobile apps.

However, Appium can also test web apps on mobile devices using the installed browser.
It uses the same Selenium commands such as `click` and `sendKeys`.

Appium is able to execute on Mobile devices by installing the WebDriverAgent
which acts as a server, relaying the commands between Appium
and the native automation on a mobile device.

To create this test:
1. Copy SimpleSeleniumTest.java to SimpleAppiumWebTest.java
2. Change the WebDriver to AppiumDriver.

    ```
    AppiumDriver driver = new AppiumDriver(remoteUrl, capabilities)
    ```

3. Set Appium specific capabilities:

    ```
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability("platformVersion", "11.2");
    capabilities.setCapability("deviceName", "iPhone Simulator");
    capabilities.setCapability("browserName", "Safari");
    ```    

4. Run your test.


For extra credit, change your test to run on Android.  
Note that the browserName for Android is "chrome" for Android 6+ 
and "browser" for older Android devices.






