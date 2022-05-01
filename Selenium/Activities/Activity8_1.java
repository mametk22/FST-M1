package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");
        List<WebElement> cols = driver.findElements(By.xpath(".//table[contains(@class,'ui celled striped table')]/tbody[1]/tr[1]/td"));
        List<WebElement> rows = driver.findElements(By.xpath(".//table[contains(@class,'ui celled striped table')]/tbody[1]"));
        System.out.println("no of cols "+ cols.size());
        System.out.println("no of rows "+ rows.size());



        driver.close();
    }
}
