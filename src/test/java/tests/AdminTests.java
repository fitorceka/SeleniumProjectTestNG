package tests;

import adminmethods.LoginAdminMethods;
import adminmethods.OrdersUsersMethods;
import adminmethods.StatisticsBoxesMethods;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.AdminExpectedFiles;

@Listeners(utils.Listeners.class)

public class AdminTests extends TestBaseAdmin {

    private final LoginAdminMethods loginMethods = new LoginAdminMethods();
    private final OrdersUsersMethods ordersUsersMethods = new OrdersUsersMethods();
    private final StatisticsBoxesMethods statisticsBoxesMethods = new StatisticsBoxesMethods();

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
}
