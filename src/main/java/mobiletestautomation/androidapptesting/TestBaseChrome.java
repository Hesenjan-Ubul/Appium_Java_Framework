package mobiletestautomation.androidapptesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseChrome {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

        AndroidDriver<AndroidElement> driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4a API 31");
//            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Real Android Phone");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//new step

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        return driver;
    }
}
