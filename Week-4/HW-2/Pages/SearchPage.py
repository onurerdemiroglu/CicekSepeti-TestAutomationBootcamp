from time import sleep

from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait


class SearchPage:
    elBestMatch = (By.XPATH, "//button[@aria-label='Sort selector. Best Match selected.']")

    def __init__(self, driver):
        self.driver = driver

    def verifyResultNotification(self, result):
        notification = (By.XPATH, "//h3[text()='" + result + "']")

        assert self.driver.find_element(*notification).is_displayed()

    def chooseSortBy(self, sortCriterion):
        sortCriter = (By.XPATH, "//span[text()='" + sortCriterion + "']")

        self.driver.find_element(*self.elBestMatch).click()
        self.driver.find_element(*sortCriter).click()

    def verifySortBy(self, sortCriterion):
        sortby = (By.XPATH, "//button[@aria-label='Sort selector. " + sortCriterion + " selected.']")
        assert self.driver.find_element(*sortby).is_displayed()
