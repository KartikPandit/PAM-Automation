package ui.pages

import com.microfocus.base.UIBasePage
import com.microfocus.pam.PAMWebUtil
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class PAMLogin extends UIBasePage {
    private String server = "https://10.71.16.194/pam/#/login"
    private String webuiURL = String.format(server)
    PAMLogin(WebDriver driver){
        super(driver)
        PAMWebUtil.gotoURL(driver, webuiURL)
    }

    private @FindBy(id = "user-name")              WebElement usernameField
    private @FindBy(id = "password")              WebElement passwordField
    private @FindBy(xpath = "//*[contains(text(),'Login')]")  WebElement loginButton

    PAMLogin usernameField(String username) {
        /*PAMWebUtil.switchToDefaultContent(driver)*/
        wait.until(ExpectedConditions.visibilityOf(usernameField))
        usernameField.sendKeys(username)
        return this
    }

    PAMLogin passwordField(String password) {
        /*PAMWebUtil.switchToDefaultContent(driver)*/
        passwordField.sendKeys(password)
        return this
    }
    //Need to create the PAM Main page
    void loginButton() {
        /*PAMWebUtil.switchToDefaultContent(driver)*/
        loginButton.click()
    }

    def login(String username, String password,Boolean isUserLogedIn=false) {
        println("In NPSMain.login... username: '" + username + "'  password: '" + password + "'")
        long startTimeSeconds = System.currentTimeSeconds()
        Thread.sleep(10000)
        if (doesElementExist(driver, loginButton, 1, 20)) {
            println("loging in")
            usernameField(username)
            passwordField(password)
            loginButton()
            Thread.sleep(3000)
        }
        if (doesElementExist(driver, loginButton, 1, 5)) {
            long elapsedTimeSeconds = (System.currentTimeSeconds() - startTimeSeconds)
            throw new Exception("Failed to login to NPSMain after more than " + elapsedTimeSeconds + " seconds")
        } else {
            println("Logged in successfully to NPSMain as " + username + " with password: " + password)
            long elapsedTimeSeconds = (System.currentTimeSeconds() - startTimeSeconds) / 1000
            println("It took more than " + elapsedTimeSeconds + " seconds for the login to be successful!")
            if (elapsedTimeSeconds > 9) {
                println("Login took a LONG time.  It took more than " + elapsedTimeSeconds + " seconds for the login to be successful!")
            }
            if(isUserLogedIn)
                return new PAMUserMain(driver)
            else
                return new PAMAdminMain(driver)
        }
    }


}
