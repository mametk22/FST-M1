package Liveproject;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActivityJB9 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        Reporter.log("Starting test");
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        Reporter.log("browser opened");

    }
    @Test
    public void test9() throws InterruptedException {
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
        driver.findElement(By.xpath("//div[contains(text(),'Job Listings ')]")).click();
        driver.findElement(By.xpath("//div[@id='wpbody-content']/div[4]/a[1]")).click();
        Thread.sleep(5000);
        WebElement position = driver.findElement(By.id("post-title-0"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", position);


        //wait.until(ExpectedConditions.elementToBeClickable(By.id("post-title-0")));

        position.sendKeys("testmanager");
        driver.findElement(By.id("_application")).clear();
        driver.findElement(By.id("_application")).sendKeys("test12PP13@gmail.com");
        driver.findElement(By.id("_company_website")).sendKeys("https://www.testycola12.com/");
        driver.findElement(By.id("_job_location")).sendKeys("Mumbai");
        driver.findElement(By.id("_company_name")).sendKeys("Testcola12");
        Thread.sleep(10);
        driver.findElement(By.xpath(".//button[contains(text(),'Publish…')]")).click();
        Thread.sleep(10);
        driver.findElement(By.xpath(".//button[contains(text(),'Publish')]")).click();
        driver.findElement(By.xpath(".//a[contains(@class,'button edit-')]")).click();
        Thread.sleep(100);





    }
    @AfterClass
    public void teardown(){
        Reporter.log("Ending Test |");
        driver.close();
    }
}
