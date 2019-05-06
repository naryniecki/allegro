package pl.allegro.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Offer extends Page {

    private final static String title = "";

    @FindBy(id = "add-to-cart-button")
    WebElement addToCart;

    By btnClose = By.className("btn-close");
    By btnToCart = By.id("add-to-cart-si-precart");

    public Offer(WebDriver drv) {
        super(drv);
    }

    public void addToCart() {
        addToCart.click();
    }

    public void closePreCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnClose));
        drv.findElement(btnClose).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnClose));
        drv.findElement(btnToCart).click();
    }

    public ItemsForSale goBack() {
        drv.navigate().back();
        return new ItemsForSale(drv);
    }
}
