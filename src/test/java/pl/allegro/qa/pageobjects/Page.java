package pl.allegro.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    WebDriver drv;

    public Page(WebDriver drv) {
        this.drv = drv;
        PageFactory.initElements(drv, this);
    }
}
