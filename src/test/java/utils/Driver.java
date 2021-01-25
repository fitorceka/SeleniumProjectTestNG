package utils;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static Driver instanceOfDriver = null;
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    private final TakesScreenshot screenshot;

    private Driver() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        screenshot = (TakesScreenshot) driver;
        actions = new Actions(driver);

    }

    public static Driver getInstanceOfDriver() {

        if (instanceOfDriver == null) {
            instanceOfDriver = new Driver();
        }
        return instanceOfDriver;

    }

    public WebDriver getDriver() {
        return driver;
    }

    WebDriverWait getWait() {
        return wait;
    }

    Actions getActions() {
        return actions;
    }

    TakesScreenshot getScreenshot() {
        return screenshot;
    }
}
