package snippets;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class StartAppiumDriver
{
	public void startAppiumDriver() throws MalformedURLException
	{
		URL appiumUrl = new URL("http://localhost:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//.. set capabilities
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(appiumUrl, capabilities);
	}
}
