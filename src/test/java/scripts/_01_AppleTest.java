package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class _01_AppleTest extends Base {
    //Declare your driver
    WebDriver driver;

    // 1. Initial set up - before each test
    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
    }

    // 2. Validation of test - test
    @Test
    public void testAppleTitle(){
        driver.get("https://www.apple.com/");

        String expectedTitle = "Apple"; // requirement
        String actualTitle = driver.getTitle(); // development

        Assert.assertEquals(actualTitle, expectedTitle);


       // if(actualTitle.equals(expectedTitle)) System.out.println("Apple title validation passed");
       // else System.out.println("Apple title validation failed");
    }



    @Test
    public void testAppleUrl(){
        driver.get("https://www.apple.com/");
        String expectedUrl = "https://www.apple.com/"; // requirement
        String actualUrl = driver.getCurrentUrl(); // development

        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test
    public void X(){
        //fail() method is used to fail a test on purpose
        // we use this for known issues
        Assert.fail("Failure on purpose");
    }

     @AfterMethod
    // 3. Teardown actions - after each test
    public void teardown(){
        Driver.quitDriver();
    }

    }
