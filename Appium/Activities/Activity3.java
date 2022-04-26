package Activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {

    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "e9a8ca8c");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "uiAutomator2");
        caps.setCapability("appPackage", "com.miui.calculator");
        caps.setCapability("appActivity", ".cal.CalculatorActivity");
        caps.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(remoteUrl, caps);

    }

    @Test
    public void TestAdd(){

        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_plus_s").click();
        driver.findElementById("btn_9_s").click();
        driver.findElementById("btn_equal_s").click();
        String addresult = driver.findElementById("result").getText();
        System.out.println(addresult);
        Assert.assertEquals(addresult, "= 14");
        driver.findElementById("btn_c_s").click();
    }
    @Test
    public void Testsub(){

        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_minus_s").click();
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_equal_s").click();
        String subresult = driver.findElementById("result").getText();
        System.out.println(subresult);
        Assert.assertEquals(subresult, "= 6");
        driver.findElementById("btn_c_s").click();
    }
    @Test
    public void Testmul(){

        driver.findElementById("btn_5_s").click();

        driver.findElementById("btn_mul_s").click();
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_equal_s").click();
        String mulresult = driver.findElementById("result").getText();
        System.out.println(mulresult);
        Assert.assertEquals(mulresult, "= 500");
        driver.findElementById("btn_c_s").click();
    }
    @Test
    public void Testdiv(){

        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_div_s").click();
        driver.findElementById("btn_2_s").click();
        driver.findElementById("btn_equal_s").click();
        String divresult = driver.findElementById("result").getText();
        System.out.println(divresult);
        Assert.assertEquals(divresult, "= 25");
        driver.findElementById("btn_c_s").click();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
