package mobiletestautomation.androidapptesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static AndroidDriver<AndroidElement> capabilities(String deviceType) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver;
        DesiredCapabilities cap = new DesiredCapabilities();

        File appDir = new File("src");

        File app = new File(appDir, "ApiDemos-debug.apk");
        if (deviceType.equalsIgnoreCase("Pixel 4a API 31")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4a API 31");
        } else if (deviceType.equalsIgnoreCase("Real Android Phone")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Real Android Phone");
        }

        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//new step

        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        return driver;
    }
}
