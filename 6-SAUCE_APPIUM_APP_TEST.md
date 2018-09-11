# Getting Started with Appium

## 6 - Testing Mobile Apps on Sauce Labs

To test an app in Sauce Labs 
you need to specify a URL for the app.

It either needs to be a public URL
or you can use Sauce Storage
to keep your (untested) app private:

Use the Sauce REST API to upload the file
to Sauce Storage:

    File file = new File("HelloSauceAndroid.apk");
    SauceREST api = new SauceREST(SAUCE_USERNAME, SAUCE_ACCESS_KEY);
	api.uploadFile(file);
		
See also https://wiki.saucelabs.com/display/DOCS/Uploading+Mobile+Applications+to+Sauce+Storage+for+Testing

and then include the `sauce-storage` url
in DesiredCapabilities

    capabilities.setCapability("app", "sauce-storage:HelloSauceAndroid.apk");
    
    You can see an example script here: https://github.com/saucelabs-training/Getting-Started-with-Appium/blob/master/src/test/java/SauceAppiumAppTest.java
