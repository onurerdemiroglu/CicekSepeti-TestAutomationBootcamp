using System;
using TechTalk.SpecFlow;
using OpenQA.Selenium;

[Binding]
public class BasketSteps
{
    private readonly ScenarioContext context;

    public BasketSteps(ScenarioContext scenarioContext)
    {
        context = scenarioContext;
    }
    HomePage homePage = new HomePage();
    MenuPage menuPage = new MenuPage();
    ProductPage productPage = new ProductPage();


    [Given(@"navigate to website")]
    public void navigateToWebsite()
    {
        Driver.get().Navigate().GoToUrl("https://www.evidea.com/");
        Driver.get().Manage().Window.Maximize();
        Driver.get().Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(30);
    }


    [Given(@"I choose '(.*)' from the dropdown menu")]
    public void iChooseFromTheMenu(string menu)
    {
        homePage.dropDownMenu(menu);
    }

    [Given(@"I choose '(.*)' from the dropdown sub menu")]
    public void iChooseFromTheSubMenu(string submenu)
    {
        homePage.dropDownSubMenu(submenu);
    }

    [Given(@"I open the first product page")]
    public void iOpenTheFirstProductPage()
    {
        menuPage.clickFirstProduct();
    }

    [Given(@"I click the add to basket button")]
    public void iClickTheAddToBasketButton()
    {
        productPage.clickAddToBasket();
    }

    [When(@"I click the close popup button")]
    public void iClickTheClosePopupButton()
    {
        productPage.closePopup();
    }

    [Then(@"Verify success add product result '(.*)'")]
    public void verifySuccessAddProductResult(string notification)
    {
        productPage.verifySuccess(notification);
    }




}