package Pinterest.pages;

import Pinterest.utilities.Driver;
import Pinterest.utilities.Helper;
import Pinterest.utilities.RandomUser;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class HomePage extends Helper {

    RandomUser randomUser = new RandomUser();

    public HomePage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.pinterest.identity:id/email_address")
    public AndroidElement emailAdress;

    @AndroidFindBy(id = "com.pinterest.identity:id/continue_email_bt")
    public AndroidElement continueBtn;

    @AndroidFindBy(id = "com.pinterest:id/profile_menu_view")
    public AndroidElement profileTab;

    @AndroidFindBy(id = "com.pinterest:id/menu_search")
    public AndroidElement searchTab;

    @AndroidFindBy(id = "com.pinterest:id/menu_notifications")
    public AndroidElement notificationTab;

    @AndroidFindBy(xpath = "//*[@content-desc='All recommended Pins']")
    public AndroidElement pinFeed;

    public void writeTheRandomEmail() throws FileNotFoundException {
        String name = getRandomName();
        String surname = getRandomSurname();
        waitForVisibilityOf(emailAdress);
        sendKeysElement(emailAdress, getRandomEmail(name, surname));
        clickElement(continueBtn);
    }

    public void writeTheEmail(String mail) {
        waitForVisibilityOf(emailAdress);
        sendKeysElement(emailAdress, mail);
        clickElement(continueBtn);
    }

    public void clickProfileTab() {
        clickElement(profileTab);
    }

    public void clickSearchTab() {
        clickElement(searchTab);
    }

    public void clickNotificationTab() {
        clickElement(notificationTab);
    }

    public void verifyProfileBtn() {
        Assert.assertTrue(profileTab.isDisplayed());
    }

    public void verifyPinterestFeed() {
        Assert.assertTrue(pinFeed.isDisplayed());
    }
}