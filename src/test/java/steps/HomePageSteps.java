package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.FileNotFoundException;

public class HomePageSteps extends BaseSteps {

    @Given("^I am navigated to the home page$")
    public void iAmNavigatedToTheHomePage() {
        getHomePage().launchApp();
        Assert.assertTrue(getHomePage().amIOnHomePage());
    }

    @When("^I click on a random popular box$")
    public void iClickOnARandomPopularBox() {
        getHomePage().chooseRandomPopularBox().click();

    }

    @When("^I click on a (.*?) popular box$")
    public void iClickOnAPopularBox(String dataset) throws FileNotFoundException {
        getHomePage().choosePopularBox(data(dataset).get("name"));
    }

    @When("^I add the (.*?) popular box to my shopping cart$")
    public void iAddThePopularBoxToMyShoppingCart(String dataset) throws InterruptedException, FileNotFoundException {
        getHomePage().addPopularBoxToCart(data(dataset).get("name"));
    }

    @When("^I go to my shopping cart$")
    public void iGoToMyShoppingCart() {
        getHomePage().goToCart();
        Assert.assertTrue(getShoppingCartPage().ifNavigatedToShoppingCartPage());
    }
}
