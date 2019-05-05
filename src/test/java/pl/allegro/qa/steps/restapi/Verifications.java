package pl.allegro.qa.steps.restapi;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pl.allegro.qa.steps.Hooks;

import java.util.logging.Logger;

public class Verifications {

    private static final Logger LOGGER = Logger.getLogger(Verifications.class.getName());

    @Given("I have a valid token")
    public void i_have_a_valid_token() {
        String token = Hooks.api.getToken();
        LOGGER.info("Verify page title");
        Assert.assertNotNull(token);
    }

    @Then("when I get content of my cart")
    public void when_I_get_content_of_my_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I have two items in it")
    public void i_have_two_items_in_it() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
