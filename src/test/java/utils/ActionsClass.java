package utils;

import org.openqa.selenium.WebElement;

public class ActionsClass {

    private static Driver d = Driver.getInstanceOfDriver();

    public static void mouseOnElement(WebElement element) {

        d.getActions().moveToElement(element).build().perform();

    }

    public static void moveToElementAndClick(WebElement element) {

        d.getActions().moveToElement(element).click().build().perform();

    }
}
