package pl.allegro.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Cart extends Page {

    private final static String title = "";

    @FindBy(css = "section[ng-repeat='offer in group.offers']")
    List<WebElement> itemsInCart;

    public Cart(WebDriver drv) {
        super(drv);
    }

    public int countItemsInCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[ng-repeat='offer in group.offers']")));
        return itemsInCart.size();
    }
}
