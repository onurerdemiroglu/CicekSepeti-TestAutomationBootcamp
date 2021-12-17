using OpenQA.Selenium;
using SeleniumExtras.PageObjects;
using NUnit.Framework;

public class SearchPage
{

    public SearchPage()
    {
        PageFactory.InitElements(Driver.get(), this);
    }

    public void verifyResult(string notification)
    {
        string locator = "//p[text()='" + notification + "']";
        IWebElement elResult = Driver.get().FindElement(By.XPath(locator));
        Assert.IsTrue(elResult.Displayed);
        Driver.closeDriver();
    }
}