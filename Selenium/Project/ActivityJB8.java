package Liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActivityJB8 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        Reporter.log("Starting test");
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        Reporter.log("browser opened");

    }
    @Test
    public void test8(){
        Reporter.log("starting Test |");
        String mainTitle = driver.getTitle();
        System.out.println("Page title is " + " " + mainTitle);
        WebElement username = driver.findElement(By.id("user_login"));
        Assert.assertTrue(username.isDisplayed());
        WebElement password = driver.findElement(By.id("user_pass"));
        username.sendKeys("root");
        password.sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='wpbody-content']/div[4]/h1[1]"))));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='wpbody-content']/div[4]/h1[1]")).isDisplayed());
    }
    @AfterClass
    public void teardown(){
        Reporter.log("Ending Test |");
        driver.close();
    }
}
