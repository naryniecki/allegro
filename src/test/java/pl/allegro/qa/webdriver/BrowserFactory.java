package pl.allegro.qa.webdriver;

public class BrowserFactory {

    /**
     * Factory to handle different web browsers.
     * @param browserVewndor supported are Chrome, Firefox. Configured in properties file.
     * @param driverPath Parth to browser driver binaries: chromedrive, geckodriver. Configured in properties file.
     * @return
     */
    public static Browser getDriverFactory(String browserVewndor, String driverPath) {
        Browser browser = null;

        switch (browserVewndor.toLowerCase()) {
            case "chrome":
                browser = new Chrome(driverPath);
                break;
            case "firefox":
                browser = new Firefox(driverPath);
                break;
            case "safari":
                break;
        }
        return browser;
    }
}
