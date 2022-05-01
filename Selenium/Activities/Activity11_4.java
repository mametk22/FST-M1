package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class Activity11_4 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tab-opener");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("parent Page title 1" + " " + driver.getTitle());
        System.out.println("parent Page handle1" + " " + driver.getWindowHandle());
        driver.findElement(By.id("launcher")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for (String handle : allWindowHandles)
        {
            driver.switchTo().window(handle);
        }
        System.out.println("first New Tab Title is: " + driver.getTitle());

        driver.findElement(By.id("actionButton")).click();
        String handle2 = driver.getWindowHandle();
        Set<String> allWindowHandles2 = driver.getWindowHandles();
        System.out.println(allWindowHandles2);
        for (String handle1 : allWindowHandles2)
        {
            driver.switchTo().window(handle1);
        }
        System.out.println("second New Tab Title is: " + driver.getTitle());


        driver.quit();

    }
}
