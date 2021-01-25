package usermethods;

import org.openqa.selenium.support.PageFactory;
import userpageelements.LinksAndTexts;
import utils.ActionsClass;
import utils.Driver;
import utils.Waits;

public class LinksAndTextsMethods {

    private static final Driver driver = Driver.getInstanceOfDriver();
    private final LinksAndTexts linksAndTexts;

    public LinksAndTextsMethods() {
        linksAndTexts = PageFactory.initElements(driver.getDriver(), LinksAndTexts.class);
    }

    //methods
    public int footerLinks() {
        return linksAndTexts.fetchFooterLinksSize();
    }

    //shopping cart that has no products in it.
    public String emptyShoppingCart() {
        ActionsClass.mouseOnElement(linksAndTexts.shoppingCart);
        Waits.waitForElementToBeVisible(linksAndTexts.emptyShoppingCartText);
        return linksAndTexts.fetchEmptyShoppingCartText();
    }
}
