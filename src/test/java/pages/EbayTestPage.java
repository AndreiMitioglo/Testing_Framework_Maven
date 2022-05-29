package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class EbayTestPage {
    /*
   Go to https://www.ebay.com/
   Select "Art" from "All Categories" dropdown
   Click on "Search" button
   Validate "Welcome to eBay Art" heading1
   Validate "Find Prints, Paintings, Posters, and More." heading2

   NOTE: Validation includes headings to be displayed and texts to be exactly matching above texts
    */
    public EbayTestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Test(priority = 3, description = "TC242: Validate Ebay dropdown")
    public void testEbayDropdown(){

    }

}
