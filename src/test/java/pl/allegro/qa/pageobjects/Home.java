package pl.allegro.qa.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Home extends Page {

    private final static String title = "Allegro.pl – najlepsze ceny, największy wybór i zawsze bezpieczne zakupy online";

    @FindBy(css = "div[data-prototype-id='allegro.rodoConsentModal']")
    WebElement gdprConsent;

    @FindBy(css = "button[data-role='reject-consent']")
    WebElement rejectGdpr;

    @FindBy(css = "div[data-group-id^='departments_']")
    List<WebElement> categories;

    public Home(WebDriver drv) {
        super(drv);
    }

    public void closeGdprConsent() {
        if (gdprConsent.isDisplayed()) rejectGdpr.click();
    }

    public void clickOnCategory(String categoryName) throws NoSuchElementException {
        boolean clicked = false;
        for (WebElement category : categories) {
            if (category.getText().equals(categoryName)) {
                category.click();
                clicked = true;
                break;
            }
        }
        if (!clicked) throw new NoSuchElementException(categoryName + "Not found on the page.");
    }

    public String getTitle() {
        return title;
    }

}
