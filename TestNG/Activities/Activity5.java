package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity5 {

    WebDriver driver ;

    @BeforeTest(alwaysRun = true)
    public void setup(){

        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test (groups = {"Headertest" , "ButtonTests" })
    public void pagetitle(){

        System.out.println("title of main page is " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Target Practice");
    }
    @Test (dependsOnMethods = {"pagetitle"}, groups = {"Headertest"})
    public void HeaderTest1() {
        WebElement header3 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header3.getText(), "Third header");
    }
    @Test (dependsOnMethods = {"pagetitle"}, groups = {"Headertest"})
    public void HeaderTest2() {
        WebElement header5 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header5.getCssValue("color"), "rgb(251, 189, 8)");
    }
    @Test (dependsOnMethods = {"pagetitle"}, groups = {"ButtonTests"})

    public void ButtonTest1() {

        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));

        Assert.assertEquals(button1.getText(), "Olive");

    }



    @Test (dependsOnMethods = {"pagetitle"}, groups = {"ButtonTests"})

    public void ButtonTest2() {

        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));

        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");

    }



    @AfterTest(alwaysRun = true)
    public void teardown(){
        driver.close();
    }
}
