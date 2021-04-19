package steps;

import io.cucumber.java.en.Then;

import java.io.FileNotFoundException;

public class ShoppingCartPageSteps extends BaseSteps {

    @Then("^I can see the (.*?) popular box in my shopping cart$")
    public boolean iCanSeeThePopularBoxInMyShoppingCart(String dataset) throws FileNotFoundException {
        return getShoppingCartPage().isThePopularBoxInShoppingCart(data(dataset).get("name"));
    }
}
