package Pinterest.definations;

import Pinterest.pages.HomePage;
import Pinterest.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class LoginSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    public LoginSteps() throws MalformedURLException {
    }

    @Given("I type {string} in the mail field")
    public void iTypeInTheMailField(String mail) {
        homePage.writeTheEmail(mail);
    }

    @And("I type {string} in the password field")
    public void iTypeInThePasswordField(String password) {
        loginPage.writeThePassword(password);
    }

    @When("I click the Log In")
    public void iClickTheLogInButton() {
        loginPage.clickTheLoginButton();
    }


    @Then("I should see the pinterest feed on the homepage")
    public void iShouldSeeThePinterestFeedOnTheHomepage() {
        homePage.verifyPinterestFeed();
    }

}
