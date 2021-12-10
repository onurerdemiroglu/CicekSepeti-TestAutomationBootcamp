package bootcamp.pages;

import bootcamp.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "customerEmail")
    public WebElement mailTextbox;

    @FindBy(id = "customerPassword")
    public WebElement passwordTextbox;

    @FindBy(xpath = "//*[contains(text(),'Giriş Yap')]")
    public WebElement loginBtn;

    public void fillMail(String mail) {
        mailTextbox.click();
        mailTextbox.sendKeys(mail);
    }
    public void fillPassword(String password) {
        passwordTextbox.click();
        passwordTextbox.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

}
