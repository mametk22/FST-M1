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

public class activity1GoogleTask {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "e9a8ca8c");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "uiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void googleTask(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("tasks_fab")));
        driver.findElementByAccessibilityId("Create new task").click();
        MobileElement newtask = driver.findElementById("add_task_title");
        MobileElement save = driver.findElementById("add_task_done");
        newtask.sendKeys("Complete Activity with Google Tasks");
        save.click();
        driver.findElementByAccessibilityId("Create new task").click();
        newtask.sendKeys("Complete Activity with Google Keep");
        save.click();
        driver.findElementByAccessibilityId("Create new task").click();
        newtask.sendKeys("Complete the second Activity Google Keep");
        save.click();
        Assert.assertTrue(driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Complete Activity with Google Tasks')]").isDisplayed());
        Assert.assertTrue(driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Complete Activity with Google Keep')]").isDisplayed());
        Assert.assertTrue(driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Complete the second Activity Google Keep')]").isDisplayed());

    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
