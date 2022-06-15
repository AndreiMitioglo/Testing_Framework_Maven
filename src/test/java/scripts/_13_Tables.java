package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.util.List;

public class _13_Tables extends Base {
/*
    Go to http://the-internet.herokuapp.com/
    Click on "Sortable Data Tables" link
    Validate the table 1 headers to be displayed as below
    Last Name
    First Name
    Email
    Due
    Web Site
    Action
     */

    @Test(priority = 1, description = "Tables | headers")
    public void testTableHeaders() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        //Locate a List of web elements that returns all 6 headers and validate their texts with expected texts

        List<WebElement> headers = driver.findElements(By.cssSelector("#table1 th"));
        Waiter.pause(10);

        String[] texts = {"Last Name",
                "First Name",
                "Email",
                "Due",
                "Web Site",
                "Action"};
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(headers.get(i).getText(), texts[i]);
            Assert.assertTrue(headers.get(i).isDisplayed());

        }
    }

    @Test(priority = 2, description = "Tables | first row")
    public void testFirstRow() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        List<WebElement> infoFirstRow = driver.findElements(By.cssSelector("#table1>tbody>tr:nth-child(1)>td"));
        // xpath //table[@id='table1']/tbody/tr[1]/td
        String[] textsExpected = {"Smith", "John",
                "jsmith@gmail.com",
                "$50.00",
                "http://www.jsmith.com",
                "edit delete"};

        for (int i = 0; i < textsExpected.length; i++) {
            Assert.assertEquals(infoFirstRow.get(i).getText(), textsExpected[i]);
            Assert.assertTrue(infoFirstRow.get(i).isDisplayed());

        }
    }

    @Test(priority = 3, description = "Tables | names column")
    public void findNamesColumn() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        List<WebElement> infoSecondColumn = driver.findElements(By.xpath("(//table[@id='table1']//tr)/td[2]"));
        // css -> #table1>tbody td:nth-child(2)
        String[] namesExpected = {"John", "Frank", "Jason", "Tim"};


        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(infoSecondColumn.get(i).getText(), namesExpected[i]);
            Assert.assertTrue(infoSecondColumn.get(i).isDisplayed());
        }
    }
    @Test(priority = 4, description = "Tables | all cells")
    public void testAllCells(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        List<WebElement> allCells = driver.findElements(By.cssSelector("#table1 td"));
        System.out.println(allCells.size()); // 24

        for(WebElement element : allCells){
            System.out.println(element.getText());
            Assert.assertNotEquals(element.getText(), "");
        }
    }


}