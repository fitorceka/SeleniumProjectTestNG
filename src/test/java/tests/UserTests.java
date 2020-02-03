package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import usermethods.LinksAndTextsMethods;
import usermethods.LoginUserMethods;
import usermethods.ShoppingCartMethods;
import utils.Driver;
import utils.UserExpectedFiles;

@Listeners(utils.Listeners.class)

public class UserTests {

    private static Driver d = Driver.getInstanceOfDriver();
    private LoginUserMethods loginUserMethods = new LoginUserMethods();
    private LinksAndTextsMethods linksAndTextsMethods = new LinksAndTextsMethods();
    private ShoppingCartMethods shoppingCartMethods = new ShoppingCartMethods();

    public UserTests() {
    }

    //opens chrome browser
    @BeforeTest
    public void openBrowser() {

        String url = UserExpectedFiles.url;
        d.getDriver().get(url);

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

    @Test
    public void checkSuccessfulLoginAndItemsNotAvailable() {

        String expectedAccountText = UserExpectedFiles.textAfterLogin;
        String actualAccountText = loginUserMethods.getTextOfAccountAfterLogin();
        // successful log in
        Assert.assertEquals(actualAccountText, expectedAccountText);

        String expectedErrorTextForItemNotAvailable = UserExpectedFiles.textForNotAvailableItems;
        String actualErrorTextForItemNotAvailable = loginUserMethods.productNotAvailable();
        // product not available in the store
        Assert.assertEquals(actualErrorTextForItemNotAvailable, expectedErrorTextForItemNotAvailable);

    }

    @Test
    public void checkFooterLinksAndEmptyCartText() {

        int expectedFooterLinks = UserExpectedFiles.footerLinks;
        int actualFooterLinks = linksAndTextsMethods.footerLinks();
        //links in the footer
        Assert.assertEquals(actualFooterLinks, expectedFooterLinks);

        String expectedEmptyCartText = UserExpectedFiles.emptyShoppingCartText;
        String actualEmptyCartText = linksAndTextsMethods.emptyShoppingCart();
        // display text of an empty shopping cart
        Assert.assertEquals(actualEmptyCartText, expectedEmptyCartText);

    }

    @Test
    public void checkShoppingCartByAddingAndRemovingItems() {

        String expectedMessageAfterAddingItems = UserExpectedFiles.afterAddingItemsCart;
        String actualMessageAfterAddingItems = shoppingCartMethods.clickOnNotebooks();
        Assert.assertEquals(actualMessageAfterAddingItems, expectedMessageAfterAddingItems);

        int expectedNumberOfItemsInCart = shoppingCartMethods.cartButtonNumber();
        int actualNumberOfItemsInCart = shoppingCartMethods.itemsQuantityInCart();
        // items number that are in the cart
        Assert.assertEquals(actualNumberOfItemsInCart, expectedNumberOfItemsInCart);

        int expectedTotalPriceOfAddedItems = shoppingCartMethods.totalPriceOfAddedItems();
        int actualTotalPriceOfAddedItems = shoppingCartMethods.totalPricesSum();
        //total price of items in the cart
        Assert.assertEquals(actualTotalPriceOfAddedItems, expectedTotalPriceOfAddedItems);

        String expectedTextAfterRemovingItems = UserExpectedFiles.afterRemovingItemsFromCart;
        String actualTextAfterRemovingItems = shoppingCartMethods.removeItemFromCart();
        //message after removing the items from cart
        Assert.assertEquals(actualTextAfterRemovingItems, expectedTextAfterRemovingItems);

    }

    @AfterTest
    public void closeBrowser() {

        d.getDriver().close();

    }
}
