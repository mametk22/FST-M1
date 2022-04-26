package Project;

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

public class activity3ToDoList {
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "e9a8ca8c");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);

        // Open page
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void scrollIntoViewTest1() throws InterruptedException {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
        driver.findElement(
                        MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(3).scrollIntoView(text(\"To-Do List\"))"))
                .click();
 
        Thread.sleep(10);
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("taskInput")));
        driver.findElementByXPath("android.widget.EditText").sendKeys("Add tasks to list");
        driver.findElementByXPath("//android.widget.Button[contains(@text, 'Add Task')]").click();
        driver.findElementById("taskInput").sendKeys("Get number of tasks");
        driver.findElementByXPath("//android.widget.Button[contains(@text, 'Add Task')]").click();
        driver.findElementById("taskInput").sendKeys("Clear the list");
        driver.findElementByXPath("//android.widget.Button[contains(@text, 'Add Task')]").click();
        driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Add tasks to list')]").click();
        driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Get number of tasks')]").click();
        driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Get number of tasks')]").click();
        driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Clear List')]").click();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
