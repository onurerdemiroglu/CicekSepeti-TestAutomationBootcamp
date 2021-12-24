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

public class SignupPage extends Helper {

    RandomUser randomUser = new RandomUser();

    public SignupPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.udemy.android:id/username_edit")
    public AndroidElement elUsername;

    @AndroidFindBy(id = "com.udemy.android:id/email_edit")
    public AndroidElement elEmail;

    @AndroidFindBy(id = "com.udemy.android:id/password_edit")
    public AndroidElement elPassword;

    @AndroidFindBy(id = "com.udemy.android:id/create_account_button")
    public AndroidElement elCreateBtn;

    public SignupPage clickByText(String text) {
        String locator = "//*[@text='" + text + "']";
        waitForElementToBeClickable(By.xpath(locator));
        AndroidElement elLocator = (AndroidElement) driver.findElement(By.xpath(locator));
        clickElement(elLocator);
        return this;
    }

    public SignupPage writeTheUserName(String text) {
        waitForVisibilityOf(elUsername);
        sendKeysElement(elUsername,text);
        return this;
    }

    public SignupPage writeTheEmail(String text) {
        waitForVisibilityOf(elEmail);
        sendKeysElement(elEmail,text);
        return this;
    }

    public SignupPage writeThePassword(String text) {
        waitForVisibilityOf(elPassword);
        sendKeysElement(elPassword,text);
        return this;
    }

    public void clickCreateAccount() {
        clickElement(elCreateBtn);
    }

}