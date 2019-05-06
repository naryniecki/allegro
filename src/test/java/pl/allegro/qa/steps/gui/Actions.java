package pl.allegro.qa.steps.gui;

import cucumber.api.java.en.When;
import pl.allegro.qa.pageobjects.Home;
import pl.allegro.qa.pageobjects.ItemsForSale;
import pl.allegro.qa.pageobjects.Offer;
import pl.allegro.qa.pageobjects.Supermarket;
import pl.allegro.qa.steps.Hooks;

import java.util.logging.Logger;

public class Actions {

    private static final Logger LOGGER = Logger.getLogger(pl.allegro.qa.steps.restapi.Actions.class.getName());

    Home home = new Home(Hooks.drv);
    Supermarket supermarket = new Supermarket(Hooks.drv);
    ItemsForSale itemsForSale;
    Offer offer;

    @When("I choose {string} category")
    public void i_choose_a_category(String category) {
        home.clickOnCategory(category);
    }

    @When("I chose {string} subcategory")
    public void i_chose_a_subcategory(String subcategory) {
        itemsForSale = supermarket.clickOnSubCategory(subcategory);
    }

    @When("I sort result by price descending")
    public void i_sort_result_by_price_descending() {
        itemsForSale.sortBy("pd");
    }

    @When("I add two top items from the list to the shopping cart")
    public void i_add_two_top_items_from_the_list_to_the_shopping_cart() {
        offer = itemsForSale.addItemToCart(0);
        offer.addToCart();
        offer.closePreCart();
        LOGGER.info("First item added to the cart");
        itemsForSale = offer.goBack();
        offer = itemsForSale.addItemToCart(1);
        offer.addToCart();
        LOGGER.info("Second item added to the cart");
        offer.goToCart();
    }

    @When("I hove mouse over {string} category and click {string} subcategory")
    public void i_hove_mouse_over_category_and_click_subcategory(String category, String subcategory) {
        itemsForSale = home.clickOnSubcategoryFromHomePage(category, subcategory);
    }

}
