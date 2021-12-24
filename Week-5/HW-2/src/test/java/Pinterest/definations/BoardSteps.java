package Pinterest.definations;

import Pinterest.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;


public class BoardSteps {

    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();

    public BoardSteps() throws MalformedURLException {
    }

    @And("I click the profile tab")
    public void iClickTheProfile() {
        homePage.clickProfileTab();
    }

    @And("I press the create button")
    public void iClickTheCreateButton() {
        profilePage.clickCreateBtn();
    }

    @And("I select the board")
    public void iSelectTheBoard() {
        profilePage.selectBoard();
    }

    @And("I type {string} in the board name field")
    public void iTypeInTheBoardNameField(String boardname) {
        profilePage.writeTheBoardName(boardname);
    }

    @When("I click the done")
    public void iClickTheDone() {
        profilePage.clickDoneBtn();
    }

    @Then("I should see the created board name is {string}")
    public void iShouldSeeTheBoardName(String boardname) {
        profilePage.verifyCreatedBoardName(boardname);
    }
}
