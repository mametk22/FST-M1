package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActivitySel10_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" https://training-support.net/selenium/drag-drop");
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement drop1 = driver.findElement(By.id("droppable"));
        WebElement drop2 = driver.findElement(By.id("dropzone2"));
        Actions DragAndDrop = new Actions(driver);
        DragAndDrop.dragAndDrop(ball, drop1).build().perform();
        Thread.sleep(100);
        DragAndDrop.dragAndDrop(drop1, drop2).build().perform();
        Thread.sleep(100);
        driver.close();



    }
}
