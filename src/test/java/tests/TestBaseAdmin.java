package tests;

import adminmethods.LoginAdminMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.AdminExpectedFiles;
import utils.Driver;

public class TestBaseAdmin {

    private static final Driver driver = Driver.getInstanceOfDriver();
    private final LoginAdminMethods loginMethods = new LoginAdminMethods();

    //opens Chrome Browser
    @BeforeTest
    public void openBrowser() {
        String url = AdminExpectedFiles.url;
        driver.getDriver().get(url);
    }

    //log in as admin before each method
    @BeforeMethod
    public void loginAsTheCorrectAdmin() throws InterruptedException {
        //the login method
        loginMethods.loginAsCorrectAdmin();
    }

    //logs out after each method
    @AfterMethod
    public void logoutAsCurrentAdmin() throws InterruptedException {
        //the logout method
        loginMethods.logoutAsAdmin();
    }

    @AfterTest
    public void closeBrowser() {
        driver.getDriver().close();
    }
}
