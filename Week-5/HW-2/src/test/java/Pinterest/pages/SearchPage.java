package Pinterest.pages;

import Pinterest.utilities.Driver;
import Pinterest.utilities.Helper;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.net.MalformedURLException;

public class SearchPage extends Helper {

    public SearchPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.pinterest:id/search_tv")
    public AndroidElement elSearch;

    @AndroidFindBy(id = "com.pinterest:id/view_search_bar_input")
    public AndroidElement elSearchInput;

    @AndroidFindBy(id = "com.pinterest:id/search_err_message_view")
    public AndroidElement elResult;

    @AndroidFindBy(id = "com.pinterest:id/search_result_people_tab")
    public AndroidElement elProfiles;

    @AndroidFindBy(id = "com.pinterest:id/lego_user_rep_action_button")
    public AndroidElement elFollowBtn;


    public void writeSearchKeyword(String keyword) {
        waitForVisibilityOf(elSearch);
        clickElement(elSearch);
        sendKeysElement(elSearchInput, keyword);
        androidKeyEvent(AndroidKey.ENTER);
    }

    public void verifyResult(String keyword) {
        Assert.assertTrue(elResult.getText().contains(keyword));
    }

    public void clickProfilesBtn() {
        clickElement(elProfiles);
    }

    public void clickFollowBtn() {
        clickElement(elFollowBtn);
    }

    public void verifyFollowing(String text) {
        Assert.assertEquals(elFollowBtn.getText(), text);
    }
}