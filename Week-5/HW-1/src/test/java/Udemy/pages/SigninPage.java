package Udemy.pages;

import Udemy.utilities.Driver;
import Udemy.utilities.Helper;
import Udemy.utilities.RandomUser;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class SigninPage extends Helper {

    RandomUser randomUser = new RandomUser();

    public SigninPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.udemy.android:id/email_edit")
    public AndroidElement elMail;

    @AndroidFindBy(id = "com.udemy.android:id/password")
    public AndroidElement elPassword;

    @AndroidFindBy(id = "com.udemy.android:id/nextBtn")
    public AndroidElement elNextBtn;

    @AndroidFindBy(id = "com.udemy.android:id/signin_button")
    public AndroidElement elSigninBtn;

    public SigninPage clickByText(String text) {
        String locator = "//*[@text='" + text + "']";
        waitForElementToBeClickable(By.xpath(locator));
        AndroidElement elLocator = (AndroidElement) driver.findElement(By.xpath(locator));
        clickElement(elLocator);
        return this;
    }

    public SigninPage writeTheEmail(String text) {
        waitForVisibilityOf(elMail);
        sendKeysElement(elMail, text);
        return this;
    }
    public SigninPage writeThePassword(String text) {
        waitForVisibilityOf(elPassword);
        sendKeysElement(elPassword, text);
        return this;
    }

    public SigninPage clickNextBtn() {
        clickElement(elNextBtn);
        return this;
    }
    public void clickSigninBtn() {
        clickElement(elSigninBtn);
    }

}