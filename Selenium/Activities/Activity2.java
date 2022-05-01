package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.id("about-link")).getText());
        System.out.println(driver.findElement(By.className("ui inverted huge green button")).getText());
        System.out.println(driver.findElement(By.linkText("About Us")).getText());


        driver.close();
    }
}
