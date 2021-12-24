package Pinterest.pages;

import Pinterest.utilities.Driver;
import Pinterest.utilities.Helper;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.net.MalformedURLException;

public class NotificationPage extends Helper {

    public NotificationPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]")
    public AndroidElement elMessagesTab;

    @AndroidFindBy(id = "com.pinterest.Pinterest:id/people_facet_search_et")
    public AndroidElement searchBox;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.pinterest:id/name_tv'])[1]")
    public AndroidElement elSearchUser;

    @AndroidFindBy(id = "com.pinterest.Pinterest:id/next_btn")
    public AndroidElement elNextBtn;

    public void clickMessagesTab() {
        clickElement(elMessagesTab);
    }

    public void searchUser(String searchUser) {
        sendKeysElement(searchBox, searchUser);
    }

    public void clickSearchUser() {
        clickElement(elSearchUser);
        clickElement(elNextBtn);
    }

}