package adminmethods;

import adminpageelements.OrdersAndUsersElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import utils.Waits;

public class OrdersUsersMethods {

    private static Driver d = Driver.getInstanceOfDriver();
    private OrdersAndUsersElements ordersAndUsersElements;

    public OrdersUsersMethods() {
        ordersAndUsersElements = PageFactory.initElements(d.getDriver(), OrdersAndUsersElements.class);
    }

    public int getTheCompletedOrders() {

        int count = 0;
        if (!ordersAndUsersElements.ordersDetailsPage.isDisplayed()) {
            ordersAndUsersElements.theCollapseExpandButton.click();
        }
        ordersAndUsersElements.ordersDetailsPage.click();
        Waits.waitForElementToBeVisible(ordersAndUsersElements.ordersBox);
        for (WebElement element : ordersAndUsersElements.detailsOfTheOrders) {
            Waits.waitForElementToBeVisible(element);
            if (element.getText().equals("Complete")) {
                count++;
            }
        }
        return count;

    }

    public String getTotalProfit() {

        Waits.waitForElementToBeVisible(ordersAndUsersElements.totalProfitFromOrders);
        return ordersAndUsersElements.totalProfitFromOrders.getText();

    }

    public int getTotalUsers() {

        ordersAndUsersElements.usersDetailsPage.click();
        Select select = new Select(ordersAndUsersElements.quantityUsersBox);
        select.selectByValue("50");
        Waits.waitUntilSizeGreaterThanOne(By.xpath("//table[@id='customers-grid']/tbody/tr/td[3]"), 1);
        return ordersAndUsersElements.registeredUsersNames.size();

    }

    public int registeredUsers() {

        if (!ordersAndUsersElements.ordersDetailsPage.isDisplayed()) {
            ordersAndUsersElements.theCollapseExpandButton.click();
        }
        Waits.waitForElementToBeVisible(ordersAndUsersElements.registeredUsersNumber);
        return Integer.parseInt(ordersAndUsersElements.registeredUsersNumber.getText());

    }
}
