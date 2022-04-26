package Project;

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

public class activity2GoogleKeep {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "e9a8ca8c");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "uiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void googleTask(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("new_note_button")));
        driver.findElementById("new_note_button").click();
        driver.findElementById("editable_title").sendKeys("title1");
        driver.findElementById("edit_note_text").sendKeys("test for appium");
        driver.findElementByAccessibilityId("Open navigation drawer").click();

        Assert.assertTrue(driver.findElementById("index_note_title))]").isDisplayed());

    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
