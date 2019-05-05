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
        // Write code here that turns the phrase above into concrete actions
        // Get categories
        // url -X GET -H 'Accept: application/vnd.allegro.public.v1+json' -H 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGxlZ3JvX2FwaSJdLCJleHAiOjE1NTcwMjA1NTMsImp0aSI6IjEyNjliOTFiLTgwZTYtNDc2MC04MTJhLWY5MGM4NDgyNDFlZiIsImNsaWVudF9pZCI6IjljNGQ5YWVjZTRlMTQxZmM5NjgzYjEyOWNiOGM5MzRjIn0.CZzZJ98d32BP5m5ry2AjgRTSpd75nGF5nwHrQXhp39DIiPH9z8Srf7SWiNMZ34MiL1zsMFWhMiGTTyWQgvZAgc0QtZ3s_lHFGZ_IUVfNc1WEzDOKq7C4wiR1zP_2WtECad7EWa-oVV19SVzglqHOc1qGpE6XIpmvUcVtzNPWMxry6h6ir_dBU1iHcQvohWLtAB53HAB-B7kpgcqoe3Eg4mLJLYza0gYEO9On3aRDr4Bs0HeuFvfdg0x0ppf4UUOyCPqLh5Wg8VJOgn9BjpfihEVhN-vUDwhE0d2fWqgAnYakjNPB975WsM1RzBuqFdMhJaWm_W_WBjQaf6-YNPoNyQ' 'https://api.allegro.pl.allegrosandbox.pl/sale/categories'
        try {
            categotyMgmt.getMainCategories();
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
            Assert.fail();
        }
        throw new cucumber.api.PendingException();
    }

    @When("I choose two most expensive")
    public void i_choose_two_most_expensive() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I send a request to add two most expensive items to the shopping cart")
    public void i_send_a_request_to_add_two_most_expensive_items_to_the_shopping_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
