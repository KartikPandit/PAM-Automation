package com.microfocus.pam.tests

import com.microfocus.base.UIBaseTest
import org.testng.Assert
import org.testng.annotations.Test
import ui.pages.PAMLogin

class PAMBrokenLinksTest extends UIBaseTest {
    @Test(priority = 1, description = "Click on help and check if help table opens")
  void clickHelp() {
      new PAMLogin(driver)
              .login("kartik", "novell123",true)
              .clickUserDropDown()
              .clickHelp()
      List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
      driver.switchTo().window(browserTabs.get(1));
      Thread.sleep(10000)
      println("Page title:" + driver.getTitle())
        Assert.assertEquals(driver.getTitle(), "Help for Privileged Account Manager User Console")
      driver.close();
      driver.switchTo().window(browserTabs.get(0));
  }

    @Test(priority = 2, description = "Click on help and check if help table opens")
    void clickNoificationButton() {
        new PAMLogin(driver)
                .login("kartik","novell123",true)
                .clickBellIcon()
                .clickNotificationClose()
    }
}
