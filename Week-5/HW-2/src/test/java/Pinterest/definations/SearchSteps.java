package Pinterest.definations;

import Pinterest.pages.HomePage;
import Pinterest.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;


public class SearchSteps {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();

    public SearchSteps() throws MalformedURLException {
    }

    @And("I click the search tab")
    public void iClickTheSearchTab() {
        homePage.clickSearchTab();
    }

    @When("I search for {string}")
    public void iSearchFor(String keyword) {
        searchPage.writeSearchKeyword(keyword);
    }

    @Then("I should see result {string}")
    public void iShouldSeeResult(String result) {
        searchPage.verifyResult(result);
    }
}



