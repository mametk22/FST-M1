package Liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActivityJB2 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        Reporter.log("Starting test");
        driver.get("https://alchemy.hguy.co/jobs");
        Reporter.log("browser opened");

    }
    @Test
    public void test2(){
        Reporter.log("starting Test |");
        String mainheading = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
        System.out.println("Page heading is " + " " + mainheading);
        Assert.assertEquals(mainheading , "Welcome to Alchemy Jobs");
    }
    @AfterClass
    public void teardown(){
        Reporter.log("Ending Test |");
        driver.close();
    }
}
