import com.saucelabs.saucerest.SauceREST;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SimpleSeleniumTest
{
	@Rule
	public TestName testName = new TestName();
	Boolean testPassed;
	
	URL remoteUrl;
	DesiredCapabilities capabilities;
	RemoteWebDriver driver;
	
	String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
	String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	String SAUCE_URL = "https://SAUCE_USERNAME:SAUCE_ACCESS_KEY@ondemand.saucelabs.com:443/wd/hub"
			.replace("SAUCE_USERNAME", SAUCE_USERNAME)
			.replace("SAUCE_ACCESS_KEY", SAUCE_ACCESS_KEY);
	
	String SELENIUM_PLATFORM = "Windows 10";
	String SELENIUM_BROWSER = "Chrome";
	
	@Before
	public void setup() throws MalformedURLException
	{
		remoteUrl = getRemoteUrl();
		capabilities = getDesiredCapabilities();
		driver = new RemoteWebDriver(remoteUrl, capabilities);
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
	
	public DesiredCapabilities getDesiredCapabilities()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", SELENIUM_PLATFORM);
		capabilities.setCapability("browserName", SELENIUM_BROWSER);
		capabilities.setCapability("name", getTestName());
		return capabilities;
	}
	
	public String getTestName()
	{
		return this.getClass().getSimpleName()
				+ " " + this.testName.getMethodName()
				+ " " + SELENIUM_PLATFORM
				+ " " + SELENIUM_BROWSER;
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
