package com.microfocus.pam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/*import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;*/


import java.util.concurrent.TimeUnit;

public class PAMWebUtil {
    /*public static final Logger log = LogManager.getFormatterLogger(NAMWebUtil.class);*/

    public static void setTimeout(WebDriver webdriver, int secondsWebDriverTimeout) {
        webdriver.manage().timeouts().implicitlyWait(secondsWebDriverTimeout, TimeUnit.SECONDS);
    }


    public static void gotoURL(WebDriver webdriver, String url) {
        gotoURL(webdriver, url, 20);
    }

    public static void gotoFrameURL(WebDriver webdriver, String frameName) {
        webdriver.switchTo().frame(frameName);
        gotoURL(webdriver, webdriver.getCurrentUrl());
    }

    public static void gotoURL(WebDriver webdriver, String url, int timeout) {
        webdriver.switchTo().defaultContent();
        WebDriverWait webdriverwait = new WebDriverWait(webdriver, Integer.toUnsignedLong(timeout));
        setTimeout(webdriver, timeout);
        final String previousURL = webdriver.getCurrentUrl();
        //log.info("Navigating from URL '%s' to '%s'", previousURL, url);
        try {
            webdriver.get(url);
        }
        catch (WebDriverException e)  {
           // log.error("WebDriverException in gotoURL!  ", e);
        }

        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webdriver) {
                return (webdriver.getCurrentUrl() != previousURL);
            }
        };
        webdriverwait.until(condition);
    }

}
