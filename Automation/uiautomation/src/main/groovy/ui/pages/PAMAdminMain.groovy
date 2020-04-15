package ui.pages

import com.microfocus.base.UIBasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PAMAdminMain extends UIBasePage{
    PAMAdminMain(WebDriver driver){
        super(driver)
    }

    @FindBy(css='li:nth-child(2) > a') WebElement accessTab
    @FindBy(css='li:nth-child(3) > a') WebElement reportsTab

    Reports clickReportsTab(){
        waitForElementToAppear(accessTab)
        reportsTab.click()
        return new Reports(driver)
    }
}
