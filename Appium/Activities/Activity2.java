package Activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "e9a8ca8c");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "uiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void Test2(){
        driver.get("https://www.training-support.net/");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("About Us")));
        String pagetitle = driver.findElementByXPath("//android.widget.TextView[@text='Training Support']").getText();
        System.out.println(pagetitle);
        driver.findElementByAccessibilityId("About Us").click();
        String newPageTitle = driver.findElementByXPath("//android.widget.TextView[@text='About Us']").getText();
        System.out.println("Title on new page: " + newPageTitle);


        Assert.assertEquals(pagetitle, "Training Support");

        Assert.assertEquals(newPageTitle, "About Us");



    }


    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
