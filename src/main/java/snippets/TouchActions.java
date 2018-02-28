package snippets;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class TouchActions
{
	AppiumDriver driver;
	MobileElement element;
	TouchAction action = new TouchAction(driver);
	
	int x = 100;
	int y = 200;
	
	public void tap()
	{
		action.tap(element);
		action.tap(x, y);
		action.tap(element, x, y);
	}
	
	public void press()
	{
		action.press(element);
		action.press(x, y);
		action.press(element, x, y);
	}
	
	public void longPress()
	{
		action.longPress(element);
	}
	
	public void moveTo()
	{
		action.moveTo(element);
		action.moveTo(x, y);
		action.moveTo(element, x, y);
	}
	
	public void chained()
	{
		TouchAction action = new TouchAction(driver);
		action.longPress(element).moveTo(0, 100).release().perform();
		
	}
	
	public void swipeRight(MobileElement element)
	{
		TouchAction swipe = new TouchAction(driver);
		swipe.press(element).moveTo(element, -100, 0).release().perform();
	}
	
	public void dragDrop(MobileElement source, MobileElement dest)
	{
		TouchAction dragDrop = new TouchAction(driver);
		dragDrop.press(source).moveTo(dest).release().perform();
	}
}
