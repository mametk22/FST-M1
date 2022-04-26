package Liveproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActivityJB1 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        Reporter.log("Starting test");
        driver.get("https://alchemy.hguy.co/jobs");
        Reporter.log("browser opened");

    }
    @Test
    public void test1(){
        Reporter.log("starting Test |");
        String mainTitle = driver.getTitle();
        System.out.println("Page title is " + " " + mainTitle);
        Assert.assertEquals(mainTitle , "Alchemy Jobs – Job Board Application");
    }
    @AfterClass
    public void teardown(){
        Reporter.log("Ending Test |");
        driver.close();
    }
}
