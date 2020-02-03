package userpageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ShoppingCartElements {

    //elements
    @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li[1]/a")
    public WebElement computers;

    @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li[1]/ul/li[2]/a")
    public WebElement notebooks;

    @FindBy(how = How.CSS, using = ".product-title")
    public List<WebElement> productNames;

    @FindBy(how = How.XPATH, using = "//div[@class='buttons']/input[1]")
    public List<WebElement> addItemsToCartButton;

    @FindBy(how = How.CSS, using = ".content")
    public WebElement contentDisplay;

    @FindBy(how = How.CSS, using = ".cart-label")
    public WebElement shoppingCartButton;

    @FindBy(how = How.XPATH, using = "//a[@class='ico-cart']/span[2]")
    public WebElement cartButtonContainer;

    @FindBy(how = How.XPATH, using = "//table[@class='cart']/tbody/tr/td[6]/input")
    public List<WebElement> quantityInTheCart;

    @FindBy(how = How.CSS, using = "#bar-notification div span")
    public WebElement closeAddingMessage;

    @FindBy(how = How.CSS, using = "table.cart tbody tr td:nth-child(1) input")
    public List<WebElement> removeFormCartCheckboxes;

    @FindBy(how = How.CSS, using = "input.button-2.update-cart-button")
    public WebElement updateCartButton;

    @FindBy(how = How.CSS, using = "div.no-data")
    public WebElement textAfterRemovingItems;

    @FindBy(how = How.CSS, using = ".ajax-loading-block-window")
    public WebElement loadingAddingToCart;

    @FindBy(how = How.CSS, using = ".product-subtotal")
    public List<WebElement> prices;

    @FindBy(how = How.CSS, using = ".value-summary strong")
    public WebElement totalPrice;

    @FindBy(how = How.ID, using = "customerCurrency")
    public WebElement currency;

}
