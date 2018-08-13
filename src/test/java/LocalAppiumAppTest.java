
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
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
	String PLATFORM_VERSION = "8.1";
	String DEVICE_NAME = "Nexus 5X API 27";
	String MOBILE_APP = "/Users/joshuagrant/VodQA.apk";

	String APPIUM_URL = "http://localhost:4723/wd/hub";

	@Before
	public void setup() throws MalformedURLException
	{
		remoteUrl = getRemoteUrl();
		capabilities = getDesiredCapabilities();
		driver = new AndroidDriver<MobileElement>(remoteUrl, capabilities);
	}
	
	@Test
	public void navigateApp() throws InterruptedException {
		Thread.sleep(3000);

		driver.findElementByAccessibilityId("username").sendKeys("bad");
		driver.findElementByAccessibilityId("password").sendKeys("bad");
		driver.hideKeyboard();
		driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"login\"]/android.widget.Button").click();

		String actual = driver.findElementById("android:id/message").getText();
		String expected = "Invalid";

		assertThat(actual).contains(expected);

		driver.findElementById("android:id/button1").click();
	}
	
	@After
	public void teardown()
	{
		driver.quit();
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
		capabilities.setCapability("app", MOBILE_APP);

		return capabilities;
	}
}