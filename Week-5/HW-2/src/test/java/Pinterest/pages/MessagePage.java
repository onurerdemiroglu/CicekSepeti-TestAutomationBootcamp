package Pinterest.pages;

import Pinterest.utilities.Driver;
import Pinterest.utilities.Helper;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.net.MalformedURLException;

public class MessagePage extends Helper {

    public MessagePage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.pinterest.Pinterest:id/message_edit_text")
    public AndroidElement elMessageBox;

    @AndroidFindBy(id = "com.pinterest.Pinterest:id/send_button")
    public AndroidElement elSendBtn;

    @AndroidFindBy(id = "com.pinterest.Pinterest:id/message_text")
    public AndroidElement elMessage;

    @AndroidFindBy(id = "com.pinterest.Pinterest:id/empty_state_new_message_compose_btn")
    public AndroidElement elNewMessage;


    public void sendMessagesBox(String message) {
        waitForVisibilityOf(elMessageBox);
        clickElement(elMessageBox);
        sendKeysElement(elMessageBox,message);
    }

    public void sendMessagesBtn() {
        clickElement(elSendBtn);
    }

    public void clickNewMsg() {
        clickElement(elNewMessage);
    }

    public void verifyMessage() {
        Assert.assertTrue(elMessage.isDisplayed());
    }

}