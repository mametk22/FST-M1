package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class TagsExample extends BaseClass{
    @Given("^User is on TS homepage$")
    public void openTSHomePage() {
        driver.get("https://training-support.net");
          }

    @When("^User clicks About Us button$")
    public void clickAboutUS() {
        driver.findElement(By.id("about-link")).click();

    }
    @Then("^About Us page should open$")
    public void verifyAboutUs() {
        String pagetitle = driver.findElement(By.xpath("//h1[@class='ui header']")).getText();
        Assert.assertEquals(pagetitle,"About Us");


    }
}
