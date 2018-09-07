import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AppiumSampleScript {

    public static void main(String[] args) throws Exception {
        final String USERNAME = System.getenv("SAUCE_USERNAME");
        final String KEY = System.getenv("SAUCE_ACCESS_KEY");
        final String url = "https://" + USERNAME + ":" + KEY +
                "@ondemand.saucelabs.com/wd/hub";

        // define the capabilities you want
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.1");
        caps.setCapability("deviceName", "Samsung Galaxy S8 WQHD GoogleAPI Emulator");
        caps.setCapability("browserName", "Chrome");

        // create the driver
        AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL(url), caps);

        driver.get("http://saucelabs.github.io/training-test-page/");
        driver.findElement(By.id("comments")).sendKeys("Nice page you got here");
        int i = 0;
        while (i++ != 10) {
            driver.findElement(By.id("unchecked_checkbox")).click();
            driver.findElement(By.id("checked_checkbox")).click();
        }
        driver.findElement(By.id("submit")).click();
        // disconnect from Sauce Labs
        driver.quit();
    }
}
