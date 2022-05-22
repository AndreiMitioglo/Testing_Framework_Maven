package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.Driver;

    /*
    1. Go to "https://www.techglobalschool.com/apply-now"
    2. Validate the heading1 is displayed and the text for it is ="Application Form"
 */

public class _02_TechGlobalTest {
    WebDriver driver;
    //1. Set up driver

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
    }

    // 2. Validation of test - test
    @Test(priority = 1, description = "TC123: Validate Application form heading")
    public void testAplicationFromHeading(){
        driver.get("https://www.techglobalschool.com/apply-now");

        WebElement heading1= driver.findElement(By.xpath("//span[text()='Application Form']"));

        System.out.println(heading1.getText());
        String expectedHeading1 = "Application Form"; // requirement
        String actualHeading1 = heading1.getText(); // development

        Assert.assertTrue(heading1.isDisplayed());
        Assert.assertEquals(actualHeading1, expectedHeading1);


    }

    @AfterMethod
    // 3. Teardown actions - after each test
    public void teardown(){
        Driver.quitDriver();
    }

}



