package appiumframework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobiletestautomation.androidapptesting.pageObjects.HomePage;
import mobiletestautomation.androidapptesting.pageObjects.Preferences;
import mobiletestautomation.androidapptesting.appiumframework.TestData;
import mobiletestautomation.androidapptesting.appiumframework.Base;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiDemoTest extends Base {

    @Test(dataProvider = "InputData", dataProviderClass = TestData.class)
    public void apiDemoTest(String input) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        service = startServer();

        AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //xpath id className, androidUIautomator
        /*    xpath Syntax
         *    //tagName[@attribute='value']

         *
         */
        HomePage homePage = new HomePage(driver);
        homePage.Preferences.click();

        Preferences preferences = new Preferences(driver);
        // driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        preferences.dependencies.click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(input);
        // driver.findElementsByClassName("android.widget.Button").get(1).click();
        preferences.buttons.get(1).click();
        service.stop();

    }


}


