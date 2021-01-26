package usermethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import userpageelements.ShoppingCartElements;
import utils.ActionsClass;
import utils.Driver;
import utils.Waits;

public class ShoppingCartMethods {

    private static Driver d = Driver.getInstanceOfDriver();
    private ShoppingCartElements shoppingCartElements;

    public ShoppingCartMethods() {

        shoppingCartElements = PageFactory.initElements(d.getDriver(), ShoppingCartElements.class);

    }

    //methods
    public String clickOnNotebooks() {

        ActionsClass.mouseOnElement(shoppingCartElements.computers);
        Waits.waitForElementToBeVisible(shoppingCartElements.notebooks);
        ActionsClass.moveToElementAndClick(shoppingCartElements.notebooks);
        return addItemsToCart();

    }

    private String addItemsToCart() {

        for (int i=0; i<shoppingCartElements.productNames.size(); i++) {
            WebElement element = shoppingCartElements.productNames.get(i);
            Waits.waitForElementToBeVisible(element);
            if(!(element.getText().contains("Apple"))) {
                WebElement element1 = shoppingCartElements.addItemsToCartButton.get(i);
                element1.click();
                Waits.waitForElementToBeInvisible(shoppingCartElements.loadingAddingToCart);
            }
        }
        Waits.waitForElementToBeVisible(shoppingCartElements.contentDisplay);
        String text = shoppingCartElements.contentDisplay.getText();
        shoppingCartElements.closeAddingMessage.click();
        ActionsClass.mouseOnElement(shoppingCartElements.shoppingCartButton);
        shoppingCartElements.shoppingCartButton.click();
        Select select = new Select(shoppingCartElements.currency);
        select.selectByVisibleText("US Dollar");
        return text;

    }

    public int cartButtonNumber() {

        String container = shoppingCartElements.cartButtonContainer.getText();
        //get only the digits from the string
        container = container.replaceAll("\\D+","");
        return Integer.parseInt(container);

    }

    public int itemsQuantityInCart() {

        int quantity = 0;
        for (WebElement element : shoppingCartElements.quantityInTheCart) {
            quantity = quantity + Integer.parseInt(element.getAttribute("value"));
        }
        return quantity;

    }

    public String removeItemFromCart() {

        for (WebElement element : shoppingCartElements.removeFormCartCheckboxes) {
            if(!element.isSelected()) {
                element.click();
            }
        }
        shoppingCartElements.updateCartButton.click();
        return shoppingCartElements.textAfterRemovingItems.getText();

    }

    public int totalPricesSum() {

        int totalPrice = 0;
        for (WebElement element : shoppingCartElements.prices) {
            //get only the digits from the string
            String price = element.getText().replaceAll("\\D+","");
            price = price.substring(0, price.length() - 2);
            totalPrice = totalPrice + Integer.parseInt(price);
        }
        return totalPrice;

    }

    public int totalPriceOfAddedItems() {

        String totalPrice = shoppingCartElements.totalPrice.getText().replaceAll("\\D+","");
        totalPrice = totalPrice.substring(0, totalPrice.length() - 2);
        return  Integer.parseInt(totalPrice);

    }
}
