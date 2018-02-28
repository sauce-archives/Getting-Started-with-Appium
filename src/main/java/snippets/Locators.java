package snippets;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class Locators
{
	AppiumDriver<MobileElement> driver;
	
	public void byAccesibilityId(String accessibilityId)
	{
		MobileElement element = driver.findElementByAccessibilityId(accessibilityId);
	}
	public void findById(String id)
	{
		MobileElement element = driver.findElementById(id);
	}
	
	public void findByXpath(String xpath)
	{
		MobileElement element = driver.findElementByXPath(xpath);
		
		By xpathLocator = MobileBy.xpath("//android.widget.TextView[@content-desc=\"verticalSwipe\"]");
		driver.findElement(xpathLocator);
	}
}
