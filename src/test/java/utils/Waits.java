package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Waits {

    private static final Driver driver = Driver.getInstanceOfDriver();


    public static void waitForElementToBeVisible(WebElement element) {
        driver.getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeInvisible(WebElement element) {
        driver.getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        driver.getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeClickableAndClick(WebElement element) {
        driver.getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitUntilSizeGreaterThanOne(By list, int size) {
        driver.getWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(list, 1));
    }

}
