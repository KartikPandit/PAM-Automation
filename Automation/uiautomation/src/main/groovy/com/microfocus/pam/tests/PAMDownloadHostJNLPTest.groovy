package com.microfocus.pam.tests

import com.microfocus.base.UIBaseTest
import org.testng.annotations.Test
import ui.pages.PAMLogin

import java.awt.Robot
import java.awt.event.KeyEvent

class PAMDownloadHostJNLPTest extends UIBaseTest{

    /* @Test(priority = 1)
     void login(){
         new PAMLogin(driver)
         .usernameField("kartik")
         .passwordField("novell123")
         .loginButton()
     }

     @Test(priority = 2)
     void downloadJNLP(){
         new PAMUserMain(driver)
         .clickHostLink("blr3-16-156")
         .clickLaunch()
         Thread.sleep(20000)
     }*/

    @Test(priority =3)
    void downloadRDPFile(){
        new PAMLogin(driver)
        .login("kartik","novell123",true)
        .clickHostLink("10.71.16.105")
        .clickLaunch()
        Thread.sleep(3000)
        Robot robot=new Robot()
        robot.keyPress(KeyEvent.VK_ENTER)
    }
}
