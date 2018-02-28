
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalAppiumAppTest
{
	@Rule
	public TestName testName = new TestName();
	
	URL remoteUrl;
	DesiredCapabilities capabilities;
	AndroidDriver<MobileElement> driver;

	String PLATFORM_NAME = "Android";
	String PLATFORM_VERSION = "8.0";
	String DEVICE_NAME = "Android_Emulator";
	String MOBILE_APP = "HelloSauceAndroid.apk";

	String APPIUM_URL = "http://localhost:4723/wd/hub";

	@Before
	public void setup() throws MalformedURLException
	{
		remoteUrl = getRemoteUrl();
		capabilities = getDesiredCapabilities();
		driver = new AndroidDriver<MobileElement>(remoteUrl, capabilities);
	}
	
	@Test
	public void navigateApp()
	{
		String messageBefore = driver.findElementById("com.saucelabs.hellosauceandroid:id/message").getText();
		driver.findElementByAccessibilityId("Dashboard").click();
		String messageAfter = driver.findElementById("com.saucelabs.hellosauceandroid:id/message").getText();
	
		System.out.println("messageBefore: "+ messageBefore);
		
		System.out.println("messageAfter: "+ messageAfter);
		assertThat(messageBefore).isNotEqualTo(messageAfter);
	}
	
	@After
	public void teardown()
	{
		if (driver != null)
		{
			driver.quit();
		}
	}
	
	public URL getRemoteUrl() throws MalformedURLException
	{
        URL remoteUrl = new URL(APPIUM_URL);
		return remoteUrl;
	}
	
	public DesiredCapabilities getDesiredCapabilities()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", PLATFORM_NAME);
		capabilities.setCapability("platformVersion", PLATFORM_VERSION);
		capabilities.setCapability("deviceName", DEVICE_NAME);
		capabilities.setCapability("app", getApp(MOBILE_APP).getAbsolutePath());

		return capabilities;
	}
	
	public File getApp(String appName)
	{
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(appName).getFile());
	}
}