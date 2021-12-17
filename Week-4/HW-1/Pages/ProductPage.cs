using OpenQA.Selenium;
using SeleniumExtras.PageObjects;
using NUnit.Framework;

public class ProductPage
{

    public ProductPage()
    {
        PageFactory.InitElements(Driver.get(), this);
    }

    [FindsBy(How = How.CssSelector, Using = ".pz-button__add-to-cart")]
    private IWebElement elAddToBasket;

    [FindsBy(How = How.CssSelector, Using = ".ins-close-button-c222")]
    private IWebElement elPopup;

    public void clickAddToBasket()
    {
        elAddToBasket.Click();
    }

    public void closePopup()
    {
        elPopup.Click();
    }

    public void verifySuccess(string notification)
    {
        By locator = By.XPath("(//div[contains(.,'" + notification + "')])[6]");
        IWebElement element = Driver.get().FindElement(locator);
        Assert.IsTrue(element.Displayed);
        Driver.closeDriver();
    }

}