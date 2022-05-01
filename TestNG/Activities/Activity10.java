package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity10 {
    WebDriver driver ;
    Actions builder;
    @BeforeClass
    public void setup(){

        driver = new FirefoxDriver();
        builder = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/sliders");
    }
    @Test
    public void test1(){
        WebElement slider = driver.findElement(By.id("slider"));
        slider.click();
        String volumelevel = driver.findElement(By.id("value")).getText();
        Reporter.log("midvalue" + volumelevel);
        Assert.assertEquals(volumelevel, "50");

    }
    @Test
    public void test2(){
        WebElement slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(75,0).release().build().perform();
        String volumelevel = driver.findElement(By.id("value")).getText();
        Reporter.log("maxvalue" + volumelevel);
        Assert.assertEquals(volumelevel, "100");

    }

    @AfterClass
    public void teardown(){
        driver.close();
    }
}
