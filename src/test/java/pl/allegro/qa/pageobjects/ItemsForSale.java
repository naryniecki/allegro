package pl.allegro.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ItemsForSale extends Page {

    @FindBy(css = "select[data-value='m']")
    WebElement sort;

    public ItemsForSale(WebDriver drv) {
        super(drv);
    }

    public void sortBy(String by) {
        Select sortBy = new Select(sort);
        sortBy.selectByValue(by);
    }

    public void addItemToCart(int index) {
        Actions action = new Actions(drv);
//        WebElement item = drv.findElement(By.cssSelector("article[data-analytics-view-custom-page='" + index + "'"));
//        action.moveToElement(item);
//        WebElement picture = drv.findElement(By.cssSelector("img[src^='https']"));
//        action.moveToElement(picture);
//        action.click().build().perform();
//        WebDriverWait wait = new WebDriverWait(drv, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button"))).click();
        List<WebElement> articles = drv.findElements(By.cssSelector("article"));
        articles.get(index).findElement(By.cssSelector("a[href]")).click();
        //action.moveToElement(loc);
    }
}
