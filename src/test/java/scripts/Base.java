package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;

import utilities.Driver;

import javax.swing.border.SoftBevelBorder;
import java.util.concurrent.TimeUnit;

public class Base {
      // declare
    WebDriver driver;
    WebDriverWait explicitWait;
    Wait fluentWait;
    SoftAssert softAssert;
    Actions actions;
    JavascriptExecutor js;
    EtsySearchPage etsySearchPage;
    TGApplicationPage tgApplicationPage;
    GoogleSearchPage googleSearchPage;
    GoogleSearchResultPage googleSearchResultPage;
    HeroAppPage heroAppPage;
    FaceBookPage faceBookPage;
    ExpediaPage expediaPage;
    EbayTestPage ebayTestPage;
    RedIffHomePage redIffHomePage;
    AmazonTestPage amazonTestPage;
    TGHomePage tgHomePage;

    // instantient
    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
        etsySearchPage = new EtsySearchPage(driver);
        tgApplicationPage = new TGApplicationPage(driver);
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
        heroAppPage= new HeroAppPage(driver);
        faceBookPage = new FaceBookPage(driver);
        expediaPage = new ExpediaPage(driver);
        ebayTestPage = new EbayTestPage(driver);
        softAssert= new SoftAssert();
        actions= new Actions(driver);
        js = (JavascriptExecutor) driver;
        redIffHomePage= new RedIffHomePage(driver);
        amazonTestPage = new AmazonTestPage(driver);
        tgHomePage = new TGHomePage(driver);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }

}