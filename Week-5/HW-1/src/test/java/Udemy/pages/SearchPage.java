package Udemy.pages;

import Udemy.utilities.Driver;
import Udemy.utilities.Helper;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class SearchPage extends Helper {

    public SearchPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.udemy.android:id/search_bar_text")
    public AndroidElement elSearch;

    @AndroidFindBy(id = "com.udemy.android:id/zero_state_message")
    public AndroidElement elIncorrectMsg;


    public SearchPage writeSearchText(String keyword) {
        waitForVisibilityOf(elSearch);
        sendKeysElement(elSearch, keyword);
        return this;
    }

    public SearchPage clickSearchBox() {
        clickElement(elSearch);
        return this;
    }

    public SearchPage pressKey(AndroidKey key) {
        androidKeyEvent(key);
        return this;
    }

    public void verifySearchResult(String verify) {
        waitForVisibilityOf(elIncorrectMsg);
        Assert.assertEquals(elIncorrectMsg.getText(), verify);
    }

}