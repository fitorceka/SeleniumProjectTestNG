package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import usermethods.LoginUserMethods;
import utils.Driver;
import utils.UserExpectedFiles;

public class TestBaseUser {

    private static final Driver driver = Driver.getInstanceOfDriver();
    private final LoginUserMethods loginUserMethods = new LoginUserMethods();

    @BeforeTest
    public void openBrowser() {
        String url = UserExpectedFiles.url;
        driver.getDriver().get(url);
    }

    //logs in as user before each method
    @BeforeMethod
    public void loginAsAnRegisteredUser() throws InterruptedException {
        loginUserMethods.loginWithUserAccount();
    }

    //logs out after each method
    @AfterMethod
    public void logoutOfTheUserAccount() throws InterruptedException {
        loginUserMethods.logoutAsUser();
    }

    @AfterTest
    public void closeBrowser() {
        driver.getDriver().close();
    }
}
