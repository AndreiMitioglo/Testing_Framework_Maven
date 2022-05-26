package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TGApplicationPage {



        public  TGApplicationPage(WebDriver driver){
            PageFactory.initElements(driver, this);
        }



        @FindBy(xpath = "//span[text()='Application Form']")
        public WebElement heading1;
}
