package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://training-support.net/selenium/simple-form");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("firstName")).sendKeys("Madhu");
        driver.findElement(By.id("lastName")).sendKeys("Metkari");
        driver.findElement(By.id("email")).sendKeys("madhu8@gmail.com");
        driver.findElement(By.id("number")).sendKeys("9423456789");
        driver.findElement(By.xpath(".//input[@class='ui green button']")).click();
        driver.close();

    }
}
