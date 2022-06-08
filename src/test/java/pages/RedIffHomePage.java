package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RedIffHomePage {
    public RedIffHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='cellone']")
    public WebElement cellone;

    @FindBy(xpath = "//div[@class='celltwo']") // this 2 are inside iframe
    public WebElement celltwo;

    @FindBy(id = "moneyiframe") // this is inside iframe
    public WebElement moneiFrame;
}
