package pl.allegro.qa.webdriver;

import java.util.ResourceBundle;

public class BrowserFactory {

    public static Browser getDriverFactory(String browserVewndor, String driverPath) {
        Browser browser = null;

        switch (browserVewndor.toLowerCase()){
            case "chrome":
                browser = new Chrome(driverPath);
                break;
            case "firefox":
                browser = new Firefox(driverPath);
                break;
            case "safari":break;
        }
        return browser;
    }
}
