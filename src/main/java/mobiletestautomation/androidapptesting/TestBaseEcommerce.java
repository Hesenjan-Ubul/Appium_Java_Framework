package mobiletestautomation.androidapptesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBaseEcommerce {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

        AndroidDriver<AndroidElement> driver;
        File appDir = new File("src");
        File app = new File(appDir, "General-Store.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4a API 31");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//new step
        //capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);

        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
