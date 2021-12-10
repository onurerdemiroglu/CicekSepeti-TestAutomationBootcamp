package bootcamp.pages;

import bootcamp.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    public ProductsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//div[@class='vl-product-info'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "//*[contains(text(),'Sepete Ekle')]")
    public WebElement basketBtn;

    public void clickFirstProduct() {
        firstProduct.click();
    }

    public void clickToBasketBtn() {
        basketBtn.click();
    }

    public void isDisplayedSuccessBasked(String notification){
        String locator = "//*[contains(text(),'" + notification + "')]";

        WebElement element = Driver.get().findElement(By.xpath(locator));
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
    }

}
