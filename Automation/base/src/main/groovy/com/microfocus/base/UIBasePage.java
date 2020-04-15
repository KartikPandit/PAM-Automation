package com.microfocus.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UIBasePage {
    private static final int TIMEOUT = 20;
    private static final int POLLING = 1000;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public UIBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    protected void waitForElementToAppear(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    public static boolean doesElementExist(WebDriver driver, final WebElement locator, int pollingCycle, int timeout) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait = wait.pollingEvery(pollingCycle, TimeUnit.SECONDS).withTimeout(timeout, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            wait.until(webDriver -> ExpectedConditions.visibilityOf(locator));
            WebElement element = locator;
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
            return locator.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}
