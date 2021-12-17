using OpenQA.Selenium;
using SeleniumExtras.PageObjects;
using OpenQA.Selenium.Interactions;

public class HomePage
{

    public HomePage()
    {
        PageFactory.InitElements(Driver.get(), this);
    }

    [FindsBy(How = How.XPath, Using = "(//input[@placeholder='Ürün, kategori veya marka adı ile arayınız.'])[1]")]
    private IWebElement elSearchBox;

    [FindsBy(How = How.XPath, Using = "(//button[text()='ARA'])[1]")]
    private IWebElement elSearchButton;


    public void dropDownMenu(string menu)
    {
        By locator = By.XPath("(//a[@title='" + menu + "'])[2]");
        IWebElement menuElement = Driver.get().FindElement(locator);

        Actions action = new Actions(Driver.get());
        action.MoveToElement(menuElement);
        action.Perform();
    }

    public void dropDownSubMenu(string submenu)
    {
        By locator = By.XPath("(//a[@title='" + submenu + "'])[2]");
        IWebElement menuElement = Driver.get().FindElement(locator);
        menuElement.Click();
    }

    public void searchBox(string searchKeyword)
    {
        elSearchBox.Click();
        elSearchBox.SendKeys(searchKeyword);
    }

    public void clickSearchButton()
    {
        elSearchButton.Click();
    }

}