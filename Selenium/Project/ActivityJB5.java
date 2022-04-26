package Liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActivityJB5 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        Reporter.log("Starting test");
        driver.get("https://alchemy.hguy.co/jobs");
        Reporter.log("browser opened");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @Test
    public void test5(){
        Reporter.log("starting Test |");
        String pagetitle = driver.getTitle();
        System.out.println("Page title is " + " " + pagetitle);
        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
        String newpagetitle = driver.getTitle();
        System.out.println("New Page title is " + " " + newpagetitle);

        Assert.assertEquals(newpagetitle , "Jobs – Alchemy Jobs");
    }
    @AfterClass
    public void teardown(){
        Reporter.log("Ending Test |");
        driver.close();
    }
}
