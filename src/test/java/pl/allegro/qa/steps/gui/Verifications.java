package pl.allegro.qa.steps.gui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pl.allegro.qa.pageobjects.Home;
import pl.allegro.qa.steps.Hooks;
import pl.allegro.qa.steps.restapi.Actions;

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
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
