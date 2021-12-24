package Udemy.tests;

import Udemy.pages.HomePage;
import Udemy.pages.LearningPage;
import Udemy.pages.SearchPage;
import Udemy.utilities.Driver;
import Udemy.utilities.Helper;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;


public class TestCase2 extends Helper {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    LearningPage learningPage = new LearningPage();

    public TestCase2() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @Test(priority = 2)
    public void incorrectSearchTest() {
        homePage
                .clickByText("Browse")
                .clickSearchTab();
        searchPage
                .clickSearchBox()
                .writeSearchText("FSF3513daddfhasgASF.,^%!2EWsd")
                .pressKey(AndroidKey.ENTER)
                .verifySearchResult("No matching courses");
    }

    @Test(priority = 3)
    public void browseCategory() throws FileNotFoundException {
        String randomCategory = getRandomCategory();
        homePage
                .clickByText("Browse")
                .clickSearchTab();
        learningPage
                .scrollAndClickText(randomCategory)
                .verifyCategory(randomCategory);
    }

}
