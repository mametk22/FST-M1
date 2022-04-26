package Activities;

import io.appium.java_client.MobileBy;
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

public class Activity4 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "e9a8ca8c");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "uiAutomator2");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.TwelveKeyDialer");
        caps.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
        wait = new WebDriverWait(driver, 5);

    }

    @Test
    public void Test4(){
        driver.findElementByAccessibilityId("Contacts").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new contact")));
        driver.findElementByAccessibilityId("Create new contact").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='Name']")));
        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='Name']");
        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Title']");
        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
        firstName.sendKeys("Aaditya");
        lastName.sendKeys("Varma");
        phoneNumber.sendKeys("9991284782");
        driver.findElementById("button2").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("custom_title")));
        MobileElement mobileCard = driver.findElementById("custom_title");
        Assert.assertTrue(mobileCard.isDisplayed());
        String contactName = driver.findElementById("large_title").getText();
        Assert.assertEquals(contactName, "Aaditya");




    }
    @AfterClass
    public void teardown(){

        driver.quit();
    }
}
