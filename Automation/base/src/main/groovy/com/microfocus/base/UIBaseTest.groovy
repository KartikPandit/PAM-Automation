package com.microfocus.base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite

class UIBaseTest  {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        /*File folder
        folder=new File(UUID.randomUUID().toString())
        folder.mkdir()*/
        System.setProperty("headless", "false"); // You can set this property elsewhere
        /*String headless = System.getProperty("headless");
        //ChromeDriverManager.chromedriver();
            System.setProperty("webdriver.chrome.driver",
                    "K://Automation//chromedriver_win32//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        String downloadFilepath = "K://Automation";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", folder.getAbsolutePath());
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", false);
        chromePrefs.put("safebrowsing.download_feedback_enabled",false)
        chromePrefs.put("safebrowsing.download_feedback_enabled",false)
        options.setExperimentalOption("prefs",chromePrefs)
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true)
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(cap);*/

       /*
       *Firefox driver
       */
        System.setProperty("webdriver.gecko.driver", "K://Automation//geckodriver-v0.26.0-win64//geckodriver.exe");
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force",false)
        firefoxProfile.setPreference("browser.download.folderList",2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
        firefoxProfile.setPreference("browser.download.dir","K:\\Automation");
        firefoxProfile.setPreference("browser.download.downloadDir","K:\\Automation");
        firefoxProfile.setPreference("browser.download.defaultFolder","K:\\Automation");
        firefoxProfile.setPreference("browser.download.useDownloadDir", true);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","applicatiion/rdp, application/x-java-jnlp-file , text/anytext ,text/plain,text/html,application/plain");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/force-download")
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true)
        cap.setCapability(FirefoxDriver.PROFILE,firefoxProfile)
        driver = new FirefoxDriver(cap);
    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
