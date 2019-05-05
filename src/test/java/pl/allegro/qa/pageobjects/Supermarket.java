package pl.allegro.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Supermarket extends Page {

    private final static String title = "Supermarket - Allegro.pl: produkty spożywcze, artykuły dla zwierząt i środki czystości";

    public Supermarket(WebDriver drv) {
        super(drv);
    }

    public ItemsForSale clickOnSubCategory(String subcategory) {
        drv.findElement(By.cssSelector("a[title='" + subcategory + "']")).click();
        return new ItemsForSale(drv);
    }
}
