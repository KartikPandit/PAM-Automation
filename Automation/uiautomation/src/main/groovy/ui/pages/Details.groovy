package ui.pages

import com.microfocus.base.UIBasePage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class Details extends UIBasePage{
    Details(WebDriver driver){
        super(driver)
    }

    @FindBy(css='tabset > ul > li:nth-child(3) > a > span')
    WebElement keystrokeReplayTab
    KeystrokeReplayTab clickKeystrokeReplay(){
        waitForElementToAppear(keystrokeReplayTab)
        keystrokeReplayTab.click()
        return new KeystrokeReplayTab(driver)
    }

    private class KeystrokeReplayTab extends UIBasePage{
        KeystrokeReplayTab(WebDriver driver){
            super(driver)
        }
        @FindBy(css='.label-value-block-row > button:nth-child(2) > span')
        WebElement playButton
        KeystrokeReplayTab clickPlayButton(){
            waitForElementToAppear(playButton)
            playButton.click()
            return this
        }

        KeystrokeReplayTab getCommands(){
            Thread.sleep(2000)
            while(playButton.getText()=="PLAY"){
                println (playButton.getText())
                println ("Waiting for Play Over to appear")
            }
            List<WebElement> consoleLines=driver.findElements(By.xpath('//*[@id="SSH_SESSION_REPLAY_DIV"]/div'))
            int numberOfLines=consoleLines.size()
            for(int i=0;i<numberOfLines;i++){
                int linenumber=i+1
                println ("Console line"+linenumber+":"+consoleLines.get(i).getText())
            }
            return this
        }
    }
}
