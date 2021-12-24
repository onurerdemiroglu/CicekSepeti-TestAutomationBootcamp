package Udemy.tests;

import Udemy.pages.AccountPage;
import Udemy.pages.HomePage;
import Udemy.pages.SigninPage;
import Udemy.pages.SignupPage;
import Udemy.utilities.Driver;
import Udemy.utilities.Helper;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;


public class TestCase1 extends Helper {

    HomePage homePage = new HomePage();
    SigninPage signinPage = new SigninPage();
    SignupPage signupPage = new SignupPage();
    AccountPage accountPage = new AccountPage();

    public TestCase1() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @Test(priority = 0)
    public void signUpTest() throws FileNotFoundException {
        String[] randomUser = getRandomUser();

        homePage
                .clickSignIn();
        signupPage
                .clickByText("Create an account")
                .clickByText("Sign up with email")
                .writeTheUserName(randomUser[0])
                .writeTheEmail(randomUser[2])
                .writeThePassword(randomUser[3])
                .clickCreateAccount();
        homePage
                .iShouldSeeAccountTab();
    }

    @Test(priority = 1)
    public void signInTest() {
        String email = "ciceksepetibootcamp@gmail.com";
        String password = "ciceksepetibootcamp";

        homePage
                .clickSignIn();
        signinPage
                .clickByText("Sign in with email")
                .writeTheEmail(email)
                .clickNextBtn()
                .writeThePassword(password)
                .clickSigninBtn();
        homePage
                .clickAccountTab();
        accountPage
                .verifyEmailAdress(email);
    }
}
