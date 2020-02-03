package userpageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LinksAndTexts {

    @FindBy(how = How.CSS, using = "div.footer a")
    public List<WebElement> footerLinks;

    @FindBy(how = How.CSS, using = ".cart-label")
    public WebElement shoppingCart;

    @FindBy(how = How.CSS, using = "#flyout-cart div div")
    public WebElement emptyShoppingCartText;

}
