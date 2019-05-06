package pl.allegro.qa.steps.gui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pl.allegro.qa.pageobjects.Cart;
import pl.allegro.qa.pageobjects.Home;
import pl.allegro.qa.steps.Hooks;

import java.util.logging.Logger;

public class Verifications {

    private static final Logger LOGGER = Logger.getLogger(Verifications.class.getName());

    Home home = new Home(Hooks.drv);

    @Given("e-shop site is open")
    public void e_shop_site_is_open() {
        home.closeGdprConsent();
        Assert.assertEquals(home.getTitle(), Hooks.drv.getTitle());
    }

    @Then("I have two items in the shopping cart")
    public void i_have_two_items_in_the_shopping_cart() {
        Cart cart = new Cart(Hooks.drv);
        LOGGER.info("Asserting that two items were added");
        Assert.assertEquals(2, cart.countItemsInCart());
    }
}
