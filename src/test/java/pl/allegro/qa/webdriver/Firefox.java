package pl.allegro.qa.webdriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends Browser {
    protected Firefox(String driverPath) throws RuntimeException {
        System.setProperty("webdriver.gecko.driver", driverPath);

        driver = new FirefoxDriver();
    }
}
