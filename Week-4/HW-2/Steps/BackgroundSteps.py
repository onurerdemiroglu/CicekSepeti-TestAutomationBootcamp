from behave import *
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager


class BackgroundSteps():
    def __init__(self, driver):
        super().__init__(driver)

    @given('navigate to website')
    def navigateToWebsite(self):
        self.driver = webdriver.Chrome(ChromeDriverManager().install())
        self.driver.maximize_window()
        self.driver.implicitly_wait(30)
        self.driver.get("https://www.ebay.com/")
