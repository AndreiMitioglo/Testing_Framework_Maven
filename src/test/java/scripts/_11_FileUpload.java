package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _11_FileUpload extends Base{
    @Test(priority = 1, description = "File upload")
    public void testFileUpload1(){
        driver.get("http://the-internet.herokuapp.com/");
        Waiter.pause(2);
        heroAppPage.clickOnLink("File Upload");
        Waiter.pause(2);
        heroAppPage.chooseFileInputBox.sendKeys("C:\\Users\\mitio\\IdeaProjects\\teng_framewok\\myFileAndrei.txt");
        Waiter.pause(2);
        heroAppPage.uploadFileButton.click();
        Waiter.pause(10);

        Assert.assertEquals(heroAppPage.fileUploadedH3.getText(), "File Uploaded!");
        Assert.assertEquals(heroAppPage.uploadedFileText.getText(),"myFileAndrei.txt");



        } /// download file whit click on it
        @Test(priority = 2, description = "File download")
        public void testFileDownload(){
            driver.get("http://the-internet.herokuapp.com/");

            heroAppPage.clickOnLink("File Download");
            heroAppPage.downloadFile.click();
        }


    }


