package adminpageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class OrdersAndUsersElements {

    @FindBy(how = How.CSS, using = "div.small-box.bg-aqua a")
    public WebElement ordersDetailsPage;

    @FindBy(how = How.XPATH, using = "//div[@id='nopcommerce-common-statistics-box']/div/div[2]/button")
    public WebElement theCollapseExpandButton;

    @FindBy(how = How.CSS, using = "#orders-grid tbody")
    public WebElement ordersBox;

    @FindBy(how = How.CSS, using = "#orders-grid tbody td:nth-child(3) span")
    public List<WebElement> detailsOfTheOrders;

    @FindBy(how = How.XPATH, using = "//div[@class='dataTables_scrollFootInner']/table/tfoot/tr/td[9]/div[5]/span")
    public WebElement totalProfitFromOrders;

    @FindBy(how = How.CSS, using = "div.small-box.bg-green a")
    public WebElement usersDetailsPage;

    @FindBy(how = How.NAME, using = "customers-grid_length")
    public WebElement quantityUsersBox;

    @FindBy(how = How.ID, using = "customers-grid_wrapper")
    public WebElement usersBox;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']/tbody/tr/td[3]")
    public List<WebElement> registeredUsersNames;

    @FindBy(how = How.CSS, using = "div.small-box.bg-green div h3")
    public WebElement registeredUsersNumber;

}
