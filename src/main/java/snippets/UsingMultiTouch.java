package snippets;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

public class UsingMultiTouch
{
	AppiumDriver driver;
	
	public void pinchZoom()
	{
		MultiTouchAction action = new MultiTouchAction(driver);
		
		TouchAction finger = new TouchAction(driver);
		TouchAction thumb = new TouchAction(driver);
		
		finger.press(100, 100).moveTo(200, 200).release();
		thumb.press(500, 500).moveTo(400, 400).release();
		
		action.add(finger).add(thumb).perform();
	}
}
