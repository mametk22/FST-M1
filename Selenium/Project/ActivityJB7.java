package Liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActivityJB7 {
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
    public void test7() throws InterruptedException {
        Reporter.log("starting Test |");
        String mainTitle = driver.getTitle();
        System.out.println("Page title is " + " " + mainTitle);
        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/post-a-job/']")).click();
        String heading = driver.findElement(By.xpath("//article[@id='post-5']/header[1]/h1[1]")).getText();
        Assert.assertEquals(heading, "Post a Job");
        driver.findElement(By.id("create_account_email")).sendKeys("test12PP1@gmail.com");
        driver.findElement(By.id("job_title")).sendKeys("TestJob111");
        driver.findElement(By.id("job_location")).sendKeys("Pune");
        WebElement dropdown = driver.findElement(By.id("job_type"));
        Select select = new Select(dropdown);
        select.selectByValue("3");
        Thread.sleep(100);
        driver.switchTo().frame("job_description_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("description");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("application")).sendKeys("https://www.tesla11.com/");
        driver.findElement(By.id("company_name")).sendKeys("test company");
        Thread.sleep(100);
        driver.findElement(By.name("submit_job")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("job_preview_submit_button"))));
        driver.findElement(By.id("job_preview_submit_button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
        String newpagetitle = driver.getTitle();
        System.out.println("New Page title is " + " " + newpagetitle);
        Thread.sleep(1000);
        driver.findElement(By.id("search_keywords")).clear();
        driver.findElement(By.id("search_keywords")).sendKeys("TestJob111");
        driver.findElement(By.xpath(".//input[@value='Search Jobs']")).click();
        Thread.sleep(100);
        WebElement job1 = driver.findElement(By.xpath(".//ul[contains(@class,'job_listings')]/li[1]/a[1]"));
        Assert.assertTrue(job1.isDisplayed() );
        job1.click();
        Thread.sleep(10000);





    }
    @AfterClass
    public void teardown(){
        Reporter.log("Ending Test |");
        driver.close();
    }
}
