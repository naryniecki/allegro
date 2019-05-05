package pl.allegro.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ItemsForSale extends Page {

    @FindBy(css = "button[data-role='search-button']")
    WebElement search;

    @FindBy(className = "_1akfs _o2u5x _c5vsu")
    WebElement sort;

    public ItemsForSale(WebDriver drv) {
        super(drv);
    }

    public void clickSearch() {
        search.click();
    }

    public void sortBy(String by) {
        Select sortBy = new Select(sort);
        sortBy.selectByValue(by);
    }
}
