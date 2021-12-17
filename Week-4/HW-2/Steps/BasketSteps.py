from behave import *
from selenium.webdriver.common.by import By

from Pages.HomePage import HomePage
from Pages.MenuPage import MenuPage
from Pages.ProductPage import ProductPage
from Pages.BasketPage import BasketPage

class BasketSteps(HomePage, MenuPage, ProductPage, BasketPage):
    def __init__(self, driver):
        self.driver = driver
        super().__init__(driver)

    @given('I choose "{menu}" from the dropdown menu')
    def iChooseFromTheDropdownMenu(self, menu):
        HomePage(self.driver).clickDropdownMenu(menu)

    @step('I choose "{submenu}" from the dropdown sub menu')
    def iChooseFromTheSubMenu(self, submenu):
        HomePage(self.driver).clickDropdownSubMenu(submenu)

    @step("I open the first product page")
    def iOpenTheFirstProductPage(self):
        MenuPage(self.driver).clickFirstProductPage()

    @step("I click the add to basket button")
    def iClickTheAddToBasketButton(self):
        ProductPage(self.driver).clickAddToBasketButton()

    @then('Verify success add product result "{result}"')
    def verifySuccessAddProductResult(self, result):
        BasketPage(self.driver).verifyCheckOutText(result)
