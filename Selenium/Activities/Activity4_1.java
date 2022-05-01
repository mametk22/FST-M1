package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
        System.out.println(driver.getTitle());






        driver.close();
    }
}
