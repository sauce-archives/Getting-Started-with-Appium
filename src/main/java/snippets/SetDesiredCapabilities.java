package snippets;

import org.openqa.selenium.remote.DesiredCapabilities;

public class SetDesiredCapabilities
{
	String PLATFORM_NAME = "iOS";
	String PLATFORM_VERSION = "11.2";
	String DEVICE_NAME = "iPhone 8 Simulator";
	String APP_NAME = "MyApp.zip";
	String BROWSER_NAME = "Safari";
	String APPIUM_VERSION = "1.7.2";
	
	public DesiredCapabilities getAppDesiredCapabilities()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("platformName", PLATFORM_NAME);
		capabilities.setCapability("platformVersion", PLATFORM_VERSION);
		capabilities.setCapability("DeviceName", DEVICE_NAME);
		capabilities.setCapability("app", APP_NAME);
		capabilities.setCapability("appiumVersion", APPIUM_VERSION);
		
		return capabilities;
	}
	
	public DesiredCapabilities getWebDesiredCapabilities()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("platformName", PLATFORM_NAME);
		capabilities.setCapability("platformVersion", PLATFORM_VERSION);
		capabilities.setCapability("DeviceName", DEVICE_NAME);
		capabilities.setCapability("BrowserName", BROWSER_NAME);
		capabilities.setCapability("appiumVersion", APPIUM_VERSION);
		
		return capabilities;
	}
}
