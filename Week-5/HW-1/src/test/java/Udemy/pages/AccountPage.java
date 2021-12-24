package Udemy.pages;

import Udemy.utilities.Driver;
import Udemy.utilities.Helper;
import Udemy.utilities.RandomUser;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class AccountPage extends Helper {

    public AccountPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.udemy.android:id/email_id")
    public AndroidElement elEmailText;

    public void verifyEmailAdress(String mail) {
        waitForVisibilityOf(elEmailText);
        Assert.assertEquals(elEmailText.getText(), mail);
    }


}