package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Testing {
    public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver", "path");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        driver.get("https://www.amazon.com/");
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));


    }
}
