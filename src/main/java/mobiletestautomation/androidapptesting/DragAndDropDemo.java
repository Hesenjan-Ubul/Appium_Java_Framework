package mobiletestautomation.androidapptesting;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class DragAndDropDemo extends TestBase {

    public static void main(String[] args) throws MalformedURLException {

        // TODO Auto-generated method stub
        AndroidDriver<AndroidElement> driver = capabilities("Pixel 4a API 31");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

        WebElement source = driver.findElementsByClassName("android.view.View").get(0);
        WebElement destination = driver.findElementsByClassName("android.view.View").get(1);

        TouchAction t = new TouchAction(driver);

        // use this for multiple actions during drag and drop
//        t.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2))).moveTo(element(destination)).release().perform();

        // use this just for drag and drop
        t.longPress(element(source)).moveTo(element(destination)).release().perform();
    }
}
