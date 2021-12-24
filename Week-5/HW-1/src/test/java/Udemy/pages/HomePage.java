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

public class HomePage extends Helper {

    public HomePage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.udemy.android:id/signin_button")
    public AndroidElement elSignInBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Account tab']")
    public AndroidElement elAccountTab;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Search tab']")
    public AndroidElement elSearchTab;

    public void clickSignIn() {
        clickElement(elSignInBtn);
    }

    public HomePage clickByText(String text) {
        String locator = "//*[@text='" + text + "']";
        waitForElementToBeClickable(By.xpath(locator));
        AndroidElement elLocator = (AndroidElement) driver.findElement(By.xpath(locator));
        clickElement(elLocator);
        return this;
    }

    public void clickAccountTab() {
        clickElement(elAccountTab);
    }

    public void clickSearchTab() {
        clickElement(elSearchTab);
    }

    public void iShouldSeeAccountTab() {
        waitForVisibilityOf(elAccountTab);
        Assert.assertTrue(elAccountTab.isDisplayed());
    }


}