import io.appium.java_client.AppiumDriver;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class VodQADragAndDropTest
{
	URL appiumServer;
	DesiredCapabilities capabilities;
	AppiumDriver driver;
	
	@Before
	public void setup() throws MalformedURLException
	{
	
		appiumServer = new URL("http://localhost:4723/wd/hub");
		
	}
}
