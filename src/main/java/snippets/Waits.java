package snippets;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits
{
	AppiumDriver<MobileElement> driver;
	By locator;
	
	public void implicitlyWait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void explicitlyWait()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	
}
