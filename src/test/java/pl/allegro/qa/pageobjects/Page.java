package pl.allegro.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    WebDriver drv;

    WebDriverWait wait;

    public Page(WebDriver drv) {
        this.drv = drv;
        this.wait = new WebDriverWait(drv, 10);
        PageFactory.initElements(drv, this);
    }
}
