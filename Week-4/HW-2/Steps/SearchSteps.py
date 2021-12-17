from behave import *
from selenium.webdriver.common.by import By
from Pages.HomePage import HomePage
from Pages.SearchPage import SearchPage


class SearchSteps(HomePage, SearchPage):
    def __init__(self, driver):
        self.driver = driver
        super().__init__(driver)

    @given('I search for "{searchKeyword}"')
    def iSearchFor(self, searchKeyword):
        HomePage(self.driver).searchBox(searchKeyword)

    @when('I click the search button')
    def iClickTheSearchButton(self):
        HomePage(self.driver).clickSearchBtn()

    @then('search result should be seen "{result}"')
    def searchResultShouldBeSeen(self, result):
        SearchPage(self.driver).verifyResultNotification(result)

    @when('I sort result list based on "{sortCriterion}"')
    def iSortResultListBasedOn(self, sortCriterion):
        SearchPage(self.driver).chooseSortBy(sortCriterion)

    @Then('I should see the search result list sorted by "{sortCriterion}"')
    def iSortResultListBasedOn(self, sortCriterion):
        SearchPage(self.driver).verifySortBy(sortCriterion)