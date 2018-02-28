import com.saucelabs.saucerest.SauceREST;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LocalAppiumWebTest
{
	@Rule
	public TestName testName = new TestName();
	
	URL remoteUrl;
	DesiredCapabilities capabilities;
	AppiumDriver driver;
	
	String APPIUM_URL = "http://localhost:4723/wd/hub";
	
	String PLATFORM_NAME = "iOS";
	String PLATFORM_VERSION = "11.2";
	String DEVICE_NAME = "iPhone 8";
	String BROWSER_NAME = "Safari";
	String APPIUM_VERSION = "1.7.2";
	
	@Before
	public void setup() throws MalformedURLException
	{
		remoteUrl = getRemoteUrl();
		capabilities = getAppiumDesiredCapabilities();
		driver = new AppiumDriver(remoteUrl, capabilities);
	}
	
	@Test
	public void openHomePage()
	{
		driver.get("https://saucelabs.com");
		String title = driver.getTitle();
		assertThat(title).contains("Sauce Labs");
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
	
	public DesiredCapabilities getAppiumDesiredCapabilities()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", PLATFORM_NAME);
		capabilities.setCapability("platformVersion", PLATFORM_VERSION);
		capabilities.setCapability("deviceName", DEVICE_NAME);
		capabilities.setCapability("browserName", BROWSER_NAME);
		capabilities.setCapability("appiumVersion", APPIUM_VERSION);
		return capabilities;
	}
}
