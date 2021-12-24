package Pinterest.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Helper extends RandomUser {

    public Helper() throws MalformedURLException {
    }


    private AndroidDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);


    public String getText(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public Boolean isDisplayed(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void waitForElementIsInvisible(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForVisibilityOfElementLocated(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForVisibilityOf(AndroidElement by) {
        wait.until(ExpectedConditions.visibilityOf(by));
    }

    public void mouseOver(By by) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(by)).build().perform();
    }

    public void dragAndDrop(By From, By To) {
        AndroidElement Drag = (AndroidElement) driver.findElement(From);
        AndroidElement Drop = (AndroidElement) driver.findElement(To);

        Actions act = new Actions(driver);
        act.dragAndDrop(Drag, Drop).build().perform();
    }

    public int[] getUniqueNumber(int arraySize, int max) {
        return ThreadLocalRandom.current().ints(1, max).distinct().limit(arraySize).toArray();
    }

    public void scrollAndClick(String selector) {
        String locator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + selector + "\").instance(0))";
        driver.findElementByAndroidUIAutomator(locator).click();
    }

    public void clickElement(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeysElement(AndroidElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public void androidKeyEvent(AndroidKey KEY) {
        driver.pressKey(new KeyEvent(KEY));
    }

}
