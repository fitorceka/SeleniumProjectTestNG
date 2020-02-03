package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Waits {

    private static Driver d = Driver.getInstanceOfDriver();


    public static void waitForElementToBeVisible(WebElement element) {
        d.getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeInvisible(WebElement element) {
        d.getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        d.getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeClickableAndClick(WebElement element) {
        d.getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitUntilSizeGreaterThanOne(By list, int size) {
        d.getWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(list, 1));
    }

}
