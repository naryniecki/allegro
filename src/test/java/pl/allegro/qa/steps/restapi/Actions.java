package pl.allegro.qa.steps.restapi;

import cucumber.api.java.en.When;
import org.junit.Assert;
import pl.allegro.qa.api.CategotyMgmt;
import pl.allegro.qa.steps.Hooks;

import java.io.IOException;
import java.util.logging.Logger;

public class Actions {

    private static final Logger LOGGER = Logger.getLogger(Actions.class.getName());

    CategotyMgmt categotyMgmt = new CategotyMgmt(Hooks.api);

    @When("I get the list of items from a category")
    public void i_get_the_list_of_items_from_a_category() {
        try {
            categotyMgmt.getMainCategories();
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
            Assert.fail();
        }
    }

    @When("I choose two most expensive")
    public void i_choose_two_most_expensive() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @When("I send a request to add two most expensive items to the shopping cart")
    public void i_send_a_request_to_add_two_most_expensive_items_to_the_shopping_cart() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }
}
