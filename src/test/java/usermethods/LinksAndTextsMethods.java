package usermethods;

import org.openqa.selenium.support.PageFactory;
import userpageelements.LinksAndTexts;
import utils.ActionsClass;
import utils.Driver;
import utils.Waits;

public class LinksAndTextsMethods {

    private static Driver d = Driver.getInstanceOfDriver();
    private LinksAndTexts linksAndTexts;

    public LinksAndTextsMethods() {

        linksAndTexts = PageFactory.initElements(d.getDriver(), LinksAndTexts.class);

    }

    //methods
    public int footerLinks() {

        return linksAndTexts.footerLinks.size();

    }

    //shopping cart that has no products in it.
    public String emptyShoppingCart() {

        ActionsClass.mouseOnElement(linksAndTexts.shoppingCart);
        Waits.waitForElementToBeVisible(linksAndTexts.emptyShoppingCartText);
        return linksAndTexts.emptyShoppingCartText.getText();

    }
}
