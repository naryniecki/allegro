package pl.allegro.qa.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import pl.allegro.qa.api.ApiClient;
import pl.allegro.qa.webdriver.Browser;
import pl.allegro.qa.webdriver.BrowserFactory;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Hooks {

    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());

    private static ResourceBundle testProperties = ResourceBundle.getBundle("tests");
    static Browser browser;
    public static WebDriver drv;
    public static ApiClient api;

    @Before("@gui")
    public void openWebPage() {
        browser = BrowserFactory.getDriverFactory(testProperties.getString("browser"), testProperties.getString("driver"));
        drv = browser.getDriver();
        drv.get(testProperties.getString("gui_url"));
        LOGGER.info("###### Starting GUI test ######");
    }

    @Before("@api")
    public void createApiClientAndGetToken() throws IOException {
        api = new ApiClient(testProperties.getString("auth_url"), testProperties.getString("api_url"), testProperties.getString("client_id"), testProperties.getString("client_secret"));
        api.obtainBearerToken();
        LOGGER.info("###### Starting API test ######");
    }

    @After("@gui")
    public void closeWebPage() {
        drv.close();
        LOGGER.info("###### GUI test ended ######");
    }

    @After("@api")
    public void apiTestTearDown() {
        LOGGER.info("###### API test ended ######");
    }

}