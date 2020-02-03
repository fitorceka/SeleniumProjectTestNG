package tests;

import adminmethods.LoginAdminMethods;
import adminmethods.OrdersUsersMethods;
import adminmethods.StatisticsBoxesMethods;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.AdminExpectedFiles;
import utils.Driver;

@Listeners(utils.Listeners.class)

public class AdminTests {

    private static Driver d = Driver.getInstanceOfDriver();
    private LoginAdminMethods loginMethods = new LoginAdminMethods();
    private OrdersUsersMethods ordersUsersMethods = new OrdersUsersMethods();
    private StatisticsBoxesMethods statisticsBoxesMethods = new StatisticsBoxesMethods();

    public AdminTests() {
    }

    //opens Chrome Browser
    @BeforeTest
    public void openBrowser() {

        String url = AdminExpectedFiles.url;
        d.getDriver().get(url);

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

    @Test(alwaysRun = true)
    public void checkAdminCorrectLogin() {

        String expectedAdminFullName = AdminExpectedFiles.adminFullName;
        String actualAdminFullName = loginMethods.returnAdminFullName();
        //name of the admin after logging in
        Assert.assertEquals(actualAdminFullName, expectedAdminFullName);

    }

    @Test(alwaysRun = true)
    public void checkTotalCompletedOrdersAndTotalProfit() {

        int expectedCompletedOrders = AdminExpectedFiles.completedOrders;
        int actualCompletedOrders = ordersUsersMethods.getTheCompletedOrders();

        String expectedTotalProfit = AdminExpectedFiles.totalProfit;
        String actualTotalProfit = ordersUsersMethods.getTotalProfit();
        //completed orders from the store
        Assert.assertEquals(actualCompletedOrders, expectedCompletedOrders);
        //total profit from the orders
        Assert.assertEquals(actualTotalProfit, expectedTotalProfit);

    }

    @Test(alwaysRun = true)
    public void checkTotalRegisteredUsers() {

        int expectedRegisteredUsers = ordersUsersMethods.registeredUsers();
        int actualRegisteredUsers = ordersUsersMethods.getTotalUsers();
        //quantity of the registered users in the store
        Assert.assertEquals(actualRegisteredUsers, expectedRegisteredUsers);

    }

    @Test(alwaysRun = true)
    public void checkDisplayOfStatisticsBoxes() {

        boolean[] actualExpandBoxes = statisticsBoxesMethods.expandStatisticsBoxes();
        for (boolean b : actualExpandBoxes) {
            //all statistics boxes should be open or displayed
            Assert.assertTrue(b);
        }
        boolean[] actualCollapseBoxes = statisticsBoxesMethods.collapseStatisticsBoxes();
        for (boolean b : actualCollapseBoxes) {
            //all statistics boxes should be closed or not displayed
            Assert.assertFalse(b);
        }

    }

    @AfterTest
    public void closeBrowser() {

        d.getDriver().close();

    }
}
