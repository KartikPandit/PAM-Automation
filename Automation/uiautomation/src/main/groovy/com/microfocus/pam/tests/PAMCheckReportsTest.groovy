package com.microfocus.pam.tests

import com.microfocus.base.UIBaseTest
import org.testng.annotations.Test
import ui.pages.PAMLogin

class PAMCheckReportsTest extends UIBaseTest {
    @Test(priority=1)
    void checkKeyStrokeReplay(){
        new PAMLogin(driver)
        .login("admin","novell123")
        .clickReportsTab()
        .clickAllSessions()
        .clickDetails("admin")
        .clickKeystrokeReplay()
        .clickPlayButton()
        .getCommands()
    }
}
