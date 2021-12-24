package Pinterest.pages;

import Pinterest.utilities.Driver;
import Pinterest.utilities.Helper;
import Pinterest.utilities.RandomUser;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class SignupPage extends Helper {

    RandomUser randomUser = new RandomUser();
    private final AndroidDriver driver = Driver.getDriver();

    public SignupPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.pinterest.identity:id/signup_name_edit_text")
    public AndroidElement fullName;

    @AndroidFindBy(id = "com.pinterest.identity:id/signup_password_edit_text")
    public AndroidElement password;

    @AndroidFindBy(id = "com.pinterest.identity:id/signup_age_edit_text")
    public AndroidElement age;

    @AndroidFindBy(id = "com.pinterest.nux:id/country_picker_arrow")
    public AndroidElement pickerArrow;

    @AndroidFindBy(id = "com.pinterest.identity:id/email_sign_next_button")
    public AndroidElement nextBtn;

    @AndroidFindBy(id = "com.pinterest.nux:id/country_next_button")
    public AndroidElement nextCountryBtn;

    @AndroidFindBy(id = "com.pinterest.nux:id/nux_top_bar_next_button")
    public AndroidElement nextTopicsBtn;


    public void writeTheRandomPassword() {
        waitForVisibilityOf(password);
        sendKeysElement(password, getRandomPassword(15));
        clickElement(nextBtn);
    }

    public void writeTheRandomFullName() throws FileNotFoundException {
        waitForVisibilityOf(fullName);
        sendKeysElement(fullName, getRandomName() + " " + getRandomSurname());
        clickElement(nextBtn);
    }

    public void writeTheRandomAge() {
        waitForVisibilityOf(age);
        sendKeysElement(age, getRandomAge());
        clickElement(nextBtn);
    }

    public void selectTheRandomGender() {
        AndroidElement locator = (AndroidElement) driver.findElement(By.xpath("//*[@text='" + getRandomGender() + "']"));
        waitForVisibilityOf(locator);
        clickElement(locator);
    }

    public void selectTheRandomCountry() throws FileNotFoundException {
        waitForVisibilityOf(pickerArrow);
        clickElement(pickerArrow);
        scrollAndClick(getRandomCountry());
        clickElement(nextCountryBtn);
    }

    public void selectTheRandomTopics() {
        int[] ImageView = getUniqueNumber(5, 12);
        for (int i = 0; i < 5; i++) {
            String locator = "(//android.widget.ImageView)[" + ImageView[i] + "]";
            AndroidElement elLocator = (AndroidElement) driver.findElement(By.xpath(locator));
            waitForVisibilityOf(elLocator);
            clickElement(elLocator);
        }
        clickElement(nextTopicsBtn);
    }
}