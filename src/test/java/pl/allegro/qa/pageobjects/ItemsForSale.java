package pl.allegro.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ItemsForSale extends Page {

    private final static String title = "";

    @FindBy(css = "select[data-value='m']")
    WebElement sort;

    By articleVisibile = By.cssSelector("article[data-seen='true']");

    public ItemsForSale(WebDriver drv) {
        super(drv);
    }

    public void sortBy(String by) {
        Select sortBy = new Select(sort);
        sortBy.selectByValue(by);
        wait.until(ExpectedConditions.visibilityOfElementLocated(articleVisibile));
    }

    public Offer addItemToCart(int index) {
        WebElement item = drv.findElement(By.cssSelector("article[data-analytics-view-custom-index0='" + index + "']"));
        item.click();
        return new Offer(drv);
    }
}
