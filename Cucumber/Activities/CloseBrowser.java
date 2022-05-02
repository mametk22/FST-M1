package stepDefinations;

import io.cucumber.java.en.And;

public class CloseBrowser extends BaseClass
{
    @And("^Close the Browser$")
    public void closeBrowser() {
        driver.close();

    }
}
