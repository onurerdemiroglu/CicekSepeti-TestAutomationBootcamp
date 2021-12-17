from selenium.webdriver.common.by import By


class MenuPage:
    elFirstProductPage = (By.XPATH, "(//img[@class='s-item__image-img'])[4]")

    def __init__(self, driver):
        self.driver = driver

    def clickFirstProductPage(self):
        self.driver.find_element(*self.elFirstProductPage).click()
