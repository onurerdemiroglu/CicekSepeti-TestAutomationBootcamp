package Pinterest.definations;

import Pinterest.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;


public class SignupSteps {

    HomePage homePage = new HomePage();
    SignupPage signupPage = new SignupPage();

    public SignupSteps() throws MalformedURLException {
    }

    @Given("I type random mail in the field")
    public void iTypeMailInTheField() throws FileNotFoundException {
        homePage.writeTheRandomEmail();
    }

    @And("I type random password in the field")
    public void iTypePasswordInTheField() {
        signupPage.writeTheRandomPassword();
    }

    @And("I type random full name in the field")
    public void iTypeFullNameInTheField() throws FileNotFoundException {
        signupPage.writeTheRandomFullName();
    }

    @And("I type random age in the field")
    public void iTypeAgeInTheField() {
        signupPage.writeTheRandomAge();
    }

    @And("I select random gender")
    public void iSelectGender() {
        signupPage.selectTheRandomGender();
    }

    @And("I select random country")
    public void iSelectCountry() throws FileNotFoundException {
        signupPage.selectTheRandomCountry();
    }

    @When("I select random topics")
    public void iSelectTopics() {
        signupPage.selectTheRandomTopics();
    }

    @Then("I should see profile view button")
    public void iShouldSeeProfileViewButton() {
        homePage.verifyProfileBtn();
    }
}
