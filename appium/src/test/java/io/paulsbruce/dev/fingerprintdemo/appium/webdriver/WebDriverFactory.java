package io.paulsbruce.dev.fingerprintdemo.appium.webdriver;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

/**
 * Created by paul on 6/22/17.
 * A factory to provide various web drivers depending on dev/ci/cloud environments; so far, only dev
 */

public class WebDriverFactory {

    public static WebDriver getDriver() {
        WebDriver driver = null;
        try {
            driver = new LocalDevWebDriver();
        } catch(Exception ex) {
            Logger log = Logger.getAnonymousLogger();
            log.info("APPIUM_ADDRESS: " + System.getenv("APPIUM_ADDRESS"));
            log.warning(ex.toString());
        }
        assert driver != null;
        return driver;
    }



}
