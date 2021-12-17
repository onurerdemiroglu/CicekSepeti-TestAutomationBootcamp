from selenium.webdriver.common.by import By


class ProductPage:
    elAddToCart = (By.ID, "isCartBtn_btn")

    def __init__(self, driver):
        self.driver = driver

    def clickAddToBasketButton(self):
        self.driver.find_element(*self.elAddToCart).click()
