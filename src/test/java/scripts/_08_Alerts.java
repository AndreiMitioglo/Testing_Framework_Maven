package scripts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AlertHandler;
import utilities.Waiter;

public class _08_Alerts extends Base {
    /*
    TASK -1
        Go to https://www.etsy.com/
    Click on ”Sign in” button
    Validate “Sign in” modal is displayed
    Validate heading1 of the modal is “Sign in
     */

    @Test(priority = 1, description = "TASK-1 - Regular HTML Alert")
    public void testEtsySignInModal() {
        driver.get("https://www.etsy.com/");

        etsySearchPage.signInButton.click();

        Assert.assertTrue(etsySearchPage.signInModal.isDisplayed());
        Assert.assertEquals(etsySearchPage.signInModalHeading.getText(), "Sign in");
    }

        /* Task -2 Information alert
    Go to http://the-internet.herokuapp.com/
    Click on "JavaScript Alerts" link
    Click on "Click for JS Alert" button
    Validate the text of the alert displayed is "I am a JS Alert"
    Click on "OK" button on the alert
    Validate "You successfully clicked an alert" message is displayed with its text
     */

    @Test(priority = 2, description = "TASK-2 - Information-Warning alert")
    public void testInformationWarningAlert() {
        driver.get("http://the-internet.herokuapp.com/");
        Waiter.pause(2);

        heroAppPage.clickOnLink("JavaScript Alerts");
        Waiter.pause(2);
        heroAppPage.clickOnAlertButton("Click for JS Alert");
        Waiter.pause(2);
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        alert.accept(); // Click on OK
        Waiter.pause(5);
        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You successfully clicked an alert");
    }
/*
    1.Go to http://the-internet.herokuapp.com/
    2.Click on “JavaScript Alerts” link
    3.Click on “Click for JS Confirm” button
    4.Validate the text of the alert displayed is “I am a JS Confirm”
    5.Click on ”Cancel” button on the alert
    6.Validate “You clicked: Cancel” message is displayed with its text
    7.Click on “Click for JS Confirm” button again
    8.Click on ”OK” button on the alert
    9.Validate “You clicked: Ok” message is displayed with its text
 */

    @Test(priority = 3, description = " TASK-3 Confirmation Alert")
    public void testConfirmationAlert() {
        driver.get("http://the-internet.herokuapp.com/");
        Waiter.pause(2);
        heroAppPage.clickOnLink("JavaScript Alerts");
        Waiter.pause(2);
        heroAppPage.clickOnAlertButton("Click for JS Confirm");
        Waiter.pause(2);
        Assert.assertEquals(AlertHandler.getAlertSText(driver), "I am a JS Confirm");

        //driver.switchTo().alert().dismiss(); //Cancel
        AlertHandler.dismissAlert(driver);
        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You clicked: Cancel");

        heroAppPage.clickOnAlertButton("Click for JS Confirm");
        Waiter.pause(2);

        //driver.switchTo().alert().accept(); // OK
        AlertHandler.acceptAlert(driver);
        Waiter.pause(2);

        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You clicked: Ok");
        Waiter.pause(5);
    }


    /*
    TASK-4 Prompt Alert
    Go to http://the-internet.herokuapp.com/
    Click on "JavaScript Alerts" link
    Click on "Click for JS Prompt" button
    Validate the text of the alert displayed is "I am a JS prompt"
    Click on "Cancel" button on the alert
    Validate "You entered: null" message is displayed with its text
    Click on "Click for JS Prompt" button again
    Type "Hello" in the alert input box
    Click on "OK" button on the alert
    Validate "You entered: Hello" message is displayed with its text
 */

  /*
    TASK-4 Prompt Alert
    Go to http://the-internet.herokuapp.com/
    Click on "JavaScript Alerts" link
    Click on "Click for JS Prompt" button
    Validate the text of the alert displayed is "I am a JS prompt"
    Click on "Cancel" button on the alert
    Validate "You entered: null" message is displayed with its text
    Click on "Click for JS Prompt" button again
    Type "Hello" in the alert input box
    Click on "OK" button on the alert
    Validate "You entered: Hello" message is displayed with its text
     */

    @Test(priority = 4, description = "TASK-4 Prompt Alert")
    public void testPromptAlert() {
        driver.get("http://the-internet.herokuapp.com/");
        Waiter.pause(2);
        heroAppPage.clickOnLink("JavaScript Alerts");
        Waiter.pause(2);
        heroAppPage.clickOnAlertButton("Click for JS Prompt");
        Waiter.pause(2);

        Assert.assertEquals(AlertHandler.getAlertSText(driver), "I am a JS prompt");
        AlertHandler.dismissAlert(driver);
        Waiter.pause(2);

        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You entered: null");

        heroAppPage.clickOnAlertButton("Click for JS Prompt");
        Waiter.pause(2);
        AlertHandler.sendKeysToAlert(driver, "Hello");
        Waiter.pause(2);
        AlertHandler.acceptAlert(driver);
        Waiter.pause(2);
        Assert.assertEquals(heroAppPage.resultParagraph.getText(), "You entered: Hello");
    }

    /*
    TASK-5 - Amazon Address Modal
    Go to https://www.amazon.com/
    Click on "Select your address" link in the top navigation bar
    Validate "Choose your location" modal is displayed
    Enter your zip code to input box
    Click on "Apply" button
    Validate the zip code entered displayed in the delivery message
     */


    @Test(priority = 5, description = "TASK-5 - Amazon Address Modal")
    public void testAmazonAddressModal() {
        driver.get("https://www.amazon.com/");
        Waiter.pause(2);
        amazonTestPage.selectAddressLink.click();
        Waiter.pause(2);
        Assert.assertTrue(amazonTestPage.addressModal.isDisplayed());
        Waiter.pause(2);
        String zipCode = "60018";

        amazonTestPage.zipCodeInputBox.sendKeys(zipCode);
        Waiter.pause(2);
        amazonTestPage.applyButton.click();

        Assert.assertTrue(amazonTestPage.deliveryMessage.getText().contains(zipCode));
        Waiter.pause(2);
    }

}



