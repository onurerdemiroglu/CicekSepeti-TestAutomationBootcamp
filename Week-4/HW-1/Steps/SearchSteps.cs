using System;
using TechTalk.SpecFlow;
using OpenQA.Selenium;

[Binding]
public class SearchSteps
{
    private readonly ScenarioContext context;

    public SearchSteps(ScenarioContext scenarioContext)
    {
        context = scenarioContext;
    }
    HomePage homePage = new HomePage();
    MenuPage menuPage = new MenuPage();
    ProductPage productPage = new ProductPage();
    SearchPage searchPage = new SearchPage();


    [Given(@"I search for (.*)")]
    public void iSearchFor(string searchKeyword)
    {
        homePage.searchBox(searchKeyword);
    }

    [When(@"I click the search button")]
    public void iClickTheSearchButton()
    {
        homePage.clickSearchButton();
    }

    [Then(@"search result should be seen '(.*)'")]
    public void SearchResultShouldBeSeen(string notification)
    {
        searchPage.verifyResult(notification);
    }


}