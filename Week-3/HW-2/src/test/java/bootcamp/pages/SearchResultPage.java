package bootcamp.pages;

import bootcamp.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    public SearchResultPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "custom-notification-title")
    public WebElement resultFilter;

    public void verifySearchResult(String text) {
        Assert.assertEquals(resultFilter.getText(), text);
    }
}
