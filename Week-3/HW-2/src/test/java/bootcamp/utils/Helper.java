package bootcamp.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;
import java.util.Set;

public class Helper {

    private WebDriver driver = Driver.get();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String clearDataCode(String strReplace) {

        strReplace = strReplace.replace("'", "-");
        strReplace = strReplace.replace(" ", "-");
        strReplace = strReplace.replace("ç", "c");
        strReplace = strReplace.replace("ğ", "g");
        strReplace = strReplace.replace("ı", "i");
        strReplace = strReplace.replace("ö", "o");
        strReplace = strReplace.replace("ş", "s");
        strReplace = strReplace.replace("ü", "u");
        strReplace = strReplace.replace("/", "-");
        strReplace = strReplace.replace("(", "-");
        strReplace = strReplace.replace(")", "-");
        strReplace = strReplace.replace("{", "-");
        strReplace = strReplace.replace("}", "-");
        strReplace = strReplace.replace("%", "-");
        strReplace = strReplace.replace("&", "-");
        strReplace = strReplace.replace("+", "-");
        strReplace = strReplace.replace("?", "-");
        strReplace = strReplace.replace(",", "-");
        strReplace = strReplace.replace(":", "");
        strReplace = strReplace.replace("%22", "-");
        strReplace = strReplace.replace("è", "e");
        strReplace = strReplace.replace("!", "-");
        strReplace = strReplace.replace("é", "e");
        strReplace = strReplace.replace("®", "");
        strReplace = strReplace.replace("à", "a");
        strReplace = strReplace.replace("’", "");
        strReplace = strReplace.replace("→", "");
        strReplace = strReplace.replace("í", "i");
        strReplace = strReplace.replace("î", "i");
        strReplace = strReplace.replace("ê", "e");
        strReplace = strReplace.replace("´", "-");
        strReplace = strReplace.replace("♥", "-");
        strReplace = strReplace.replace("ô", "o");
        strReplace = strReplace.replace("û", "u");
        strReplace = strReplace.replace("É", "E");
        strReplace = strReplace.replace("Ó", "O");
        strReplace = strReplace.replace("ï", "i");
        strReplace = strReplace.replace("°", "-");
        strReplace = strReplace.replace("İ", "i");
        strReplace = strReplace.replace("Ç", "c");
        strReplace = strReplace.replace("İ", "i");
        strReplace = strReplace.replace("ö", "o");
        strReplace = strReplace.replace("Ü", "u");
        strReplace = strReplace.replace("Ş", "s");
        strReplace = strReplace.replace(".", "");
        strReplace = strReplace.replace("Ş", "s");
        strReplace = strReplace.replace("Ğ", "g");
        strReplace = strReplace.replace("Ö", "o");
        strReplace = strReplace.replace(";", "-");
        strReplace = strReplace.replace("%", "");
        strReplace = strReplace.replace("I", "i");
        strReplace = strReplace.replace("&", "-");
        strReplace = strReplace.replace("--", "-");
        strReplace = strReplace.toLowerCase();
        strReplace = strReplace.trim();
        return strReplace;
    }


    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeysElement(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public Boolean isDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public static void clickWithLinkText(String linktext) {
        Driver.get().findElement(By.linkText(linktext)).click();
    }

    public static void switchLastTab() {
        String originTab = Driver.get().getWindowHandle();
        Set<String> allTabs = Driver.get().getWindowHandles();

        for (String tab : allTabs) {
            if (!originTab.equals(tab)) {
                Driver.get().switchTo().window(tab);
            }
        }
    }
}