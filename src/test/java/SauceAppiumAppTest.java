
import com.saucelabs.saucerest.SauceREST;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class SauceAppiumAppTest
{
	@Rule
	public TestName testName = new TestName();
	
	URL remoteUrl;
	DesiredCapabilities capabilities;
	AndroidDriver<MobileElement> driver;
	
	String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
	String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	String SAUCE_URL = "https://SAUCE_USERNAME:SAUCE_ACCESS_KEY@ondemand.saucelabs.com:443/wd/hub"
			.replace("SAUCE_USERNAME", SAUCE_USERNAME)
			.replace("SAUCE_ACCESS_KEY", SAUCE_ACCESS_KEY);
	
	String PLATFORM_NAME = "Android";
	String PLATFORM_VERSION = "7.1";
	String DEVICE_NAME = "Samsung Galaxy S8 WQHD GoogleAPI Emulator";
	String MOBILE_APP = "vodqa.apk";
	
	@Before
	public void setup() throws IOException
	{
		remoteUrl = getRemoteUrl();
		capabilities = getDesiredCapabilities();
		driver = new AndroidDriver<MobileElement>(remoteUrl, capabilities);
	}
	
	@Test
	public void navigateApp()
	{
		driver.findElementByAccessibilityId("username").sendKeys("bad");
		driver.findElementByAccessibilityId("password").sendKeys("bad");
		driver.hideKeyboard();
		driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"login\"]/android.widget.Button").click();

		String actual = driver.findElementById("android:id/message").getText();
		String expected = "Invalid";

		assertThat(actual).contains(expected);
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	public URL getRemoteUrl() throws MalformedURLException
	{
        URL remoteUrl = new URL(SAUCE_URL);
		return remoteUrl;
	}
	
	public DesiredCapabilities getDesiredCapabilities()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", PLATFORM_NAME);
		capabilities.setCapability("platformVersion", PLATFORM_VERSION);
		capabilities.setCapability("deviceName", DEVICE_NAME);
		capabilities.setCapability("app", "sauce-storage:" + MOBILE_APP);
		capabilities.setCapability("name", getTestName());
		
		return capabilities;
	}
	
	
	public String getTestName()
	{
		return this.getClass().getSimpleName()
				+ " " + this.testName.getMethodName()
				+ " " + PLATFORM_NAME
				+ " " + PLATFORM_VERSION;
	}
}