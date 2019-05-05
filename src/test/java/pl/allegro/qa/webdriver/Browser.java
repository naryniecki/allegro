package pl.allegro.qa.webdriver;

import org.openqa.selenium.WebDriver;

public abstract class Browser {
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
}
