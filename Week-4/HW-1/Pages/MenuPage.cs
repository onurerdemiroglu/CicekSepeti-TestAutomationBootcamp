using OpenQA.Selenium;
using SeleniumExtras.PageObjects;
using OpenQA.Selenium.Interactions;

public class MenuPage
{

    public MenuPage()
    {
        PageFactory.InitElements(Driver.get(), this);
    }

    [FindsBy(How = How.XPath, Using = "(//picture[@class='product-item__image'])[1]")]
    private IWebElement elFirstProduct;

    public void clickFirstProduct()
    {
        elFirstProduct.Click();
    }

}