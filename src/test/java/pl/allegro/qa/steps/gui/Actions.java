package pl.allegro.qa.steps.gui;

import cucumber.api.java.en.When;
import pl.allegro.qa.pageobjects.Home;
import pl.allegro.qa.pageobjects.ItemsForSale;
import pl.allegro.qa.pageobjects.Supermarket;
import pl.allegro.qa.steps.Hooks;

import java.util.logging.Logger;

public class Actions {

    private static final Logger LOGGER = Logger.getLogger(pl.allegro.qa.steps.restapi.Actions.class.getName());

    Home home = new Home(Hooks.drv);
    Supermarket supermarket = new Supermarket(Hooks.drv);
    ItemsForSale itemsForSale;

    @When("I choose {string} category")
    public void i_choose_a_category(String category) {
        LOGGER.info("Click " + category + "category");
        home.clickOnCategory(category);
    }

    @When("I chose {string} subcategory")
    public void i_chose_a_subcategory(String subcategory) {
        LOGGER.info("Click " + subcategory + "category");
        itemsForSale = supermarket.clickOnSubCategory(subcategory);
    }

    @When("I sort result by price descending")
    public void i_sort_result_by_price_descending() {
        LOGGER.info("Sort items by price descending");
        itemsForSale.sortBy("pd");
    }

    @When("I add two top items from the list to the shopping cart")
    public void i_add_two_top_items_from_the_list_to_the_shopping_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
