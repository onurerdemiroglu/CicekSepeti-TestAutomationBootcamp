package Pinterest.definations;

import Pinterest.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;


public class FollowSteps {

    SearchPage searchPage = new SearchPage();

    public FollowSteps() throws MalformedURLException {
    }

    @And("I click the profiles tab")
    public void iClickTheProfilesTab() {
        searchPage.clickProfilesBtn();
    }

    @When("I press the Follow button")
    public void iPressTheFollowButton() {
        searchPage.clickFollowBtn();
    }

    @Then("I should see {string}")
    public void iShouldSee(String text) {
        searchPage.verifyFollowing(text);
    }
}
