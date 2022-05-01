package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver ;

    @BeforeClass
    public void setup(){

        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }

    @Test
    public void activity1(){

        System.out.println("title of main page is " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Training Support");
        driver.findElement(By.id("about-link")).click();
        System.out.println("title of new page is " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "About Training Support");


    }

    @AfterClass
    public void teardown(){
        driver.close();
    }
}
