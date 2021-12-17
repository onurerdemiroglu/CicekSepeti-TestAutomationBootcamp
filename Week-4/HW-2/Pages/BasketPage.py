from selenium.webdriver.common.by import By


class BasketPage:

    def __init__(self, driver):
        self.driver = driver

    def verifyCheckOutText(self, result):
        notification = (By.XPATH, "//*[text()='" + result + "']")

        assert self.driver.find_element(*notification).is_displayed()
