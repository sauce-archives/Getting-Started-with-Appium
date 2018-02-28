
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
	String PLATFORM_VERSION = "6.0";
	String DEVICE_NAME = "Android Emulator";
	String MOBILE_APP = "HelloSauceAndroid.apk";
	
	@Before
	public void setup() throws IOException
	{
		File file = getApp(MOBILE_APP);
		uploadToSauceStorage(file);
		
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
	
	public void uploadToSauceStorage(File file) throws IOException
	{
		SauceREST api = new SauceREST(SAUCE_USERNAME, SAUCE_ACCESS_KEY);
		api.uploadFile(file);
	}
	
	public File getApp(String appName)
	{
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(appName).getFile());
	}
	
	
	public String getTestName()
	{
		return this.getClass().getSimpleName()
				+ " " + this.testName.getMethodName()
				+ " " + PLATFORM_NAME
				+ " " + PLATFORM_VERSION;
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