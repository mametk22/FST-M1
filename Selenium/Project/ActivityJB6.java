package Liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActivityJB6 {
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
    public void test6() throws InterruptedException {
        Reporter.log("starting Test |");
        String pagetitle = driver.getTitle();
        System.out.println("Page title is " + " " + pagetitle);
        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
        String newpagetitle = driver.getTitle();
        System.out.println("New Page title is " + " " + newpagetitle);
        driver.findElement(By.id("search_keywords")).clear();
        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
        driver.findElement(By.xpath(".//input[@type='submit']")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath(".//ul[contains(@class,'job_listings')]/li[1]/a[1]")).click();
        System.out.println("title is " + driver.getTitle());
        driver.findElement(By.xpath(".//input[@type='button']")).click();
        String email = driver.findElement(By.xpath(".//a[@class='job_application_email']")).getText();
        System.out.println("email for apply job is " + " " +email);




    }
    @AfterClass
    public void teardown(){
        Reporter.log("Ending Test |");
        driver.close();
    }
}
