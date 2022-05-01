package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");
        WebElement value = driver.findElement(By.id("single-value"));
        Select select = new Select(driver.findElement(By.id("single-select")));
        select.selectByValue("2");
        System.out.println(value.getText());
        select.selectByIndex(0);
        System.out.println(value.getText());
        select.selectByVisibleText("Option 6");
        System.out.println(value.getText());
        List<WebElement> options = select.getOptions();



        for(WebElement option : options) {

            System.out.println("Option: " + option.getText());

        }

    }
}
