package bootcamp.step_def;

import bootcamp.pages.*;
import bootcamp.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class MyStepdefs {
    Homepage Homepage = new Homepage();
    SearchResultPage SearchResultPage = new SearchResultPage();
    LoginPage LoginPage = new LoginPage();
    ProductsPage ProductsPage = new ProductsPage();


    @Given("navigate to website")
    public void navigateToWebsite() {
        Driver.get().get("https://www.boyner.com.tr/");

    }

    @Given("I am at the Login page")
    public void iAmAtTheLoginPage() {
        Homepage.openLoginPage();
    }

    @When("I type {string} in the email field")
    public void iTypeInTheEmailField(String mail) {
        LoginPage.fillMail(mail);
    }

    @And("I enter {string} in the password field")
    public void iEnterInThePasswordField(String password) {
        LoginPage.fillPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        LoginPage.clickLoginBtn();
    }

    @Then("I should see the name and surname as a {string}")
    public void iShouldSeeTheNameAndSurnameAsA(String nameAndSurname) {
        Homepage.verifyLoginSuccess(nameAndSurname);
    }


    @When("I search for {string}")
    public void iSearchFor(String searchArg) {
        Homepage.Search(searchArg);
    }

    @And("I click the search button")
    public void iClickTheSearchButton() {
        Homepage.searchBtn();
    }

    @Then("search result should be seen {string}")
    public void searchResultShouldBeSeen(String text) {
        SearchResultPage.verifySearchResult(text);
    }


    @Given("I choose the {string} from the slide menu")
    public void iChooseTheFromTheSlideMenu(String slideText){
        Homepage.clickSlideMenu(slideText);
    }

    @When("I open the first product page")
    public void iOpenTheFirstProductPage() {
        ProductsPage.clickFirstProduct();
    }

    @And("I click the add to basket button")
    public void iClickTheAddToBasketButton() {
        ProductsPage.clickToBasketBtn();
    }

    @Then("verify success add product result {string}")
    public void verifySuccessAddProductResult(String successNotification){
        ProductsPage.isDisplayedSuccessBasked(successNotification);
    }
}
