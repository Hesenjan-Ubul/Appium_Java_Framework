package mobiletestautomation.androidapptesting.appiumframework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;

    public AppiumDriverLocalService startServer() {
        //
        boolean flag = checkIfServerIsRunnning(4723);
        if (!flag) {

            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;

    }

    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void startEmulator() throws IOException, InterruptedException {

        Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\mobiletestautomation\\androidapptesting\\resources\\startEmulator.bat");
        Thread.sleep(10000);
    }

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\mobiletestautomation\\androidapptesting\\appiumframework\\global.properties");
        Properties properties = new Properties();
        properties.load(fis);


        // TODO Auto-generated method stub
        File appDir = new File("src");
        File app = new File(appDir, (String) properties.get(appName));
        DesiredCapabilities capabilities = new DesiredCapabilities();

        String device = (String) properties.get("device"); // for run in local pc
//    String device= System.getProperty("deviceName"); // for run in mvn commands or Jenkins
        if (device.contains("Pixel")) {
            startEmulator();
        }
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);

        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static void getScreenshot(String s) throws IOException {
        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\Reports\\" + s + ".png"));

    }


}
