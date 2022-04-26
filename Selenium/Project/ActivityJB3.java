package Liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActivityJB3 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        Reporter.log("Starting test");
        driver.get("https://alchemy.hguy.co/jobs");
        Reporter.log("browser opened");

    }
    @Test
    public void test3(){
        Reporter.log("starting Test |");
        WebElement imageURL = driver.findElement(By.xpath(".//img[@class='attachment-large size-large wp-post-image']"));
        String src = imageURL.getAttribute("src");
        System.out.println("URl of header image is " + " " + src);

    }
    @AfterClass
    public void teardown(){
        Reporter.log("Ending Test |");
        driver.close();
    }
}
