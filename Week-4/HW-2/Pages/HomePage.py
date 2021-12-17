from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By


class HomePage:
    elSearchBox = (By.XPATH, "//input[@placeholder='Search for anything']")
    elSearchButton = (By.XPATH, "//input[@value='Search']")

    def __init__(self, driver):
        self.driver = driver

    def searchBox(self, searchKeyword):
        self.driver.find_element(*self.elSearchBox).click()
        self.driver.find_element(*self.elSearchBox).send_keys(searchKeyword)

    def clickSearchBtn(self):
        self.driver.find_element(*self.elSearchButton).click()

    def clickDropdownMenu(self, menu):
        elMenu = (By.XPATH, "(//a[text()='" + menu + "'])[2]")
        menu = self.driver.find_element(*elMenu)

        hover = ActionChains(self.driver).move_to_element(menu)
        hover.perform()

    def clickDropdownSubMenu(self, submenu):
        elSubMenu = (By.XPATH, "//a[text()='" + submenu + "']")
        self.driver.find_element(*elSubMenu).click()
