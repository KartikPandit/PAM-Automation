package ui.pages

import com.microfocus.base.UIBasePage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PAMUserMain extends UIBasePage {
    PAMUserMain(WebDriver driver){
        super(driver)
    }
    private @FindBy(xpath = '//*[@class="modal-footer"]//span[contains(text(),"Launch")]')
    WebElement launchButton
    private @FindBy(css='li.dropdown.nav-profile.open > ul > li:nth-child(4) > a')
    WebElement helpButton
    private @FindBy(css='.icon-only-button > .icon-bell-outline')
    WebElement bellIcon
    private @FindBy(css='div.modal-footer > button')
    WebElement notificationClose
    private @FindBy(/*css='li.dropdown.nav-profile > a'*/ xpath='//*[@id="navbar"]/ul[2]/li[3]/a')
    WebElement userDropDown

    PAMUserMain clickHostLink(String host){
        Thread.sleep(10000)
        waitForElementToAppear(driver.findElement(By.linkText(host)))
        driver.findElement(By.linkText(host)).click()
        return new PAMUserMain(driver)
    }

    PAMUserMain clickLaunch(){
        Thread.sleep(10000)
        waitForElementToAppear(launchButton)
        launchButton.click()
        return this
    }

    PAMUserMain clickUserDropDown(){
        Thread.sleep(20000)
        waitForElementToAppear(userDropDown)
        userDropDown.click()
        return this
    }

    PAMUserMain clickBellIcon(){
        Thread.sleep(20000)
        println("Clicking Bell Icon")
        waitForElementToAppear(bellIcon)
        bellIcon.click()
        return this
    }

    PAMUserMain clickHelp(){
        waitForElementToAppear(helpButton)
        helpButton.click()
        return this
    }

    PAMUserMain clickNotificationClose(){
        waitForElementToAppear(notificationClose)
        notificationClose.click()
        return this
    }
}
