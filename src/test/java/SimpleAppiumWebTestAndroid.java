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

public class SimpleAppiumWebTestAndroid
{
	@Rule
	public TestName testName = new TestName();
	
	URL remoteUrl;
	DesiredCapabilities capabilities;
	AppiumDriver driver;
	
	String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
	String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	String SAUCE_URL = "https://SAUCE_USERNAME:SAUCE_ACCESS_KEY@ondemand.saucelabs.com:443/wd/hub"
			.replace("SAUCE_USERNAME", SAUCE_USERNAME)
			.replace("SAUCE_ACCESS_KEY", SAUCE_ACCESS_KEY);
	
	String PLATFORM_NAME = "Android";
	String PLATFORM_VERSION = "6.0";
	String DEVICE_NAME = "Android Emulator";
	String BROWSER_NAME = "Chrome";
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
			updateTestStatus(true);
			driver.quit();
		}
	}
	
	public URL getRemoteUrl() throws MalformedURLException
	{
		URL remoteUrl = new URL(SAUCE_URL);
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
		capabilities.setCapability("name", getTestName());
		return capabilities;
	}
	
	public String getTestName()
	{
		return this.getClass().getSimpleName()
				+ " " + this.testName.getMethodName()
				+ " " + PLATFORM_NAME
				+ " " + PLATFORM_VERSION
				+ " " + BROWSER_NAME;
	}
	
	public void updateTestStatus(Boolean passed)
	{
		SauceREST api = new SauceREST(SAUCE_USERNAME, SAUCE_ACCESS_KEY);
		String sessionId = driver.getSessionId().toString();
		
		if (passed)
		{
			api.jobPassed(sessionId);
		}
		else
		{
			api.jobFailed(sessionId);
		}
	}
}
