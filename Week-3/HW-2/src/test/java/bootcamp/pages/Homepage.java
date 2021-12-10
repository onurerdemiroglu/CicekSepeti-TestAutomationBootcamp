package bootcamp.pages;

import bootcamp.utils.Driver;
import bootcamp.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {

    public Homepage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(id = "pw-search-input")
    public WebElement searchBox;

    @FindBy(id = "pw-search-submit")
    public WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Üye Girişi')]")
    public WebElement loginPage;

    @FindBy(className = "cname")
    public WebElement nameSurname;


    public void openLoginPage() {
        loginPage.click();
    }

    public void Search(String text) {
        searchBox.click();
        searchBox.sendKeys(text);
    }

    public void searchBtn() {
        searchButton.click();
    }

    public void verifyLoginSuccess(String nameAndSurname) {

        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(nameSurname));
        wait.until(ExpectedConditions.elementToBeClickable(nameSurname));

        Assert.assertEquals(nameSurname.getText(), nameAndSurname);
    }

    public void clickSlideMenu(String slideText){
        String locator = "(//div[contains(text(),'" + slideText + "')])[1]";
        WebElement element =  Driver.get().findElement(By.xpath(locator));

        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
