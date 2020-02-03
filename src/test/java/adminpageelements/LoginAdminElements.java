package adminpageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginAdminElements {

    //finding web elements
    @FindBy(how = How.ID, using = "Email")
    public WebElement adminEmailInputBox;

    @FindBy(how = How.ID, using = "Password")
    public WebElement adminPasswordInputBox;

    @FindBy(how = How.CSS, using = "input.button-1.login-button")
    public WebElement adminLoginButton;

    @FindBy(how = How.CSS, using = "li.account-info")
    public WebElement adminFullNameAfterLogin;

    @FindBy(how = How.CSS, using = ".nav.navbar-nav li:nth-child(3) a")
    public WebElement logoutButton;

    @FindBy(how = How.CSS, using = ".logo-lg")
    public WebElement goToHomeLogo;

}
