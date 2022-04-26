package Liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActivityJB4 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        Reporter.log("Starting test");
        driver.get("https://alchemy.hguy.co/jobs");
        Reporter.log("browser opened");

    }
    @Test
    public void test4(){
        Reporter.log("starting Test |");
        String secondheading = driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]")).getText();
        System.out.println("Page heading is " + " " + secondheading);
        Assert.assertEquals(secondheading , "Quia quis non");
    }
    @AfterClass
    public void teardown(){
        Reporter.log("Ending Test |");
        driver.close();
    }
}
