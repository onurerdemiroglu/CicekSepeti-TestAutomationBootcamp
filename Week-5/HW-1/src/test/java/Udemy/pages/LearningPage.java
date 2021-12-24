package Udemy.pages;

import Udemy.utilities.Driver;
import Udemy.utilities.Helper;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LearningPage extends Helper {

    public LearningPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(xpath = "(//*[@resource-id='com.udemy.android:id/title'])[1]")
    public AndroidElement elCategoryName;


    public LearningPage scrollAndClickText(String text) {
        scrollAndClick(text);
        return this;
    }

    public void verifyCategory(String categoryName) {
        waitForVisibilityOf(elCategoryName);
        Assert.assertEquals(elCategoryName.getText(), categoryName);
    }

}