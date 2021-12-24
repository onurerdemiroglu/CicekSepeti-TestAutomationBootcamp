package Pinterest.pages;

import Pinterest.utilities.Driver;
import Pinterest.utilities.Helper;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginPage extends Helper {

    public LoginPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.pinterest.identity:id/password")
    public AndroidElement elPassword;

    @AndroidFindBy(id = "com.pinterest.identity:id/login_bt")
    public AndroidElement loginBtn;

    public void writeThePassword(String password){
        waitForVisibilityOf(elPassword);
        sendKeysElement(elPassword, password);
    }

    public void clickTheLoginButton(){
        clickElement(loginBtn);
    }
}