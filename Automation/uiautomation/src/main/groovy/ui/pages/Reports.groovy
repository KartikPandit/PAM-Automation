package ui.pages

import com.microfocus.base.UIBasePage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class Reports extends UIBasePage{
    Reports(WebDriver driver){
        super(driver)
    }

    @FindBy(css='table > tbody > tr:nth-child(1) > td > a')  WebElement allSessionLink


    AllSessions clickAllSessions(){
        waitForElementToAppear(allSessionLink)
        allSessionLink.click()
        return new AllSessions(driver)
    }

    private class AllSessions extends UIBasePage{
        AllSessions(WebDriver driver){
            super(driver)
        }

       Details clickDetails(String user){
           //get all rows
           List<WebElement> allRows = driver.findElements(By.xpath("//*[contains(@class,'dx-row dx-data-row dx-row-lines')]"));
           int totalNumberOfRows=allRows.size()
           //iterate through the rows
           for (int i=1;i<totalNumberOfRows;i++) {
               //get the column which contains the user name and get text
               String userName = driver.findElement(By.cssSelector('.dx-scrollable-content div table tbody tr:nth-child('+i+') td:nth-child(3)')).getText();

               //Compare if the user name equals user
               if (userName == user) {
                   System.out.println("Table Data : " + userName);
                   System.out.println("Table Row : " + i);

                   //get the column containing the link and click on it.
                   driver.findElement(By.cssSelector('.dx-scrollable-content div table tbody tr:nth-child('+i+') td:nth-child(11) div a:nth-child(2)')).click()
               }
               return new Details(driver)
           }
       }
    }
}
