package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_EtsyTest extends Base{

        /*
    1. Go to https://www.etsy.com/
    2. Validate Etsy logo is displayed
    testEtsyLogo
 */



    @Test(priority = 1)
    public void testEtsyLogo(){
        driver.get("https://www.etsy.com/");

        WebElement logo= driver.findElement(By.id("logo"));
        Assert.assertTrue(logo.isDisplayed());
    }

    /*
    1. Go to https://www.etsy.com/
    2. Validate Etsy search input box and search button is displayed

    testEtsySearch
 */
    @Test (priority = 2)
    public void testEtsySearch(){
        driver.get("https://www.etsy.com/");

        WebElement searchInputBox= driver.findElement(By.id("global-enhancements-search-query"));
        Assert.assertTrue(searchInputBox.isDisplayed());

        WebElement searchButton = driver.findElement(By.xpath("//span[@class='wt-icon wt-nudge-b-2 wt-nudge-r-1']"));
       // WebElement searchButton = driver.findElement(By.cssSelector("span[class='wt-icon wt-nudge-b-2 wt-nudge-r-1']"))
        Assert.assertTrue(searchButton.isDisplayed());
    }


    /*
    1. Go to https://www.etsy.com/
    2. Search for "canvas painting"
    3. Validate the results are more than zero
     */



    @Test (priority = 3)
    public void testEtsySearchResult(){
        driver.get("https://www.etsy.com/");
        WebElement searchInputBox= driver.findElement(By.id("global-enhancements-search-query"));

        searchInputBox.sendKeys("canvas painting" + Keys.ENTER); // click on button

        WebElement testSearch= driver.findElement(By.cssSelector(".wt-display-inline-flex-sm>span"));
        System.out.println(testSearch.getText());
       Assert.assertTrue(Integer.parseInt(testSearch.getText().replaceAll("[^0-9]", ""))>0);
        System.out.println(Integer.parseInt(testSearch.getText().replaceAll("[^0-9]", ""))); //1210624


    }
}
