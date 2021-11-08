package stepDefinations.gui;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.SearchResultsPage;

import static org.junit.Assert.assertEquals;


public class SearchSteps {
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @When("^I search for \"([^\"]*)\" on the search bar$")
    public void iSearchForOnTheSearchBar(String product) {

        searchResultsPage.searchFor(product);
    }

    @And("^I select brand \"([^\"]*)\"$")
    public void iSelectBrand(String brandName) {

        searchResultsPage.SearchForBrand(brandName);
    }

    @And("^I search for \"([^\"]*)\" in the searchbar$")
    public void iSearchForInTheSearchbar(String productName) throws Throwable {

        searchResultsPage.searchForSpecific(productName);
    }

    @Then("^I should able to see \"([^\"]*)\" in the search results$")
    public void iShouldAbleToSeeProductInTheSearchResults(String productName) {

        assertEquals(productName, searchResultsPage.verifyProductExists(productName));
    }
}
