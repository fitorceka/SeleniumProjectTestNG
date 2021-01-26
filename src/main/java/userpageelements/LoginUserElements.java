package userpageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginUserElements {

    //find elements
    @FindBy(how = How.CSS, using = "div.header-logo a")
    public WebElement goToHome;

    @FindBy(how = How.CSS, using = "a.ico-login")
    public WebElement loginButton;

    @FindBy(how = How.ID, using = "Email")
    public WebElement userEmailBox;

    @FindBy(how = How.ID, using = "Password")
    public WebElement userPasswordBox;

    @FindBy(how = How.XPATH, using = "//input[@class='button-1 login-button']")
    public WebElement login;

    @FindBy(how = How.CSS, using = "a.ico-account")
    public WebElement accountAfterLogin;

    @FindBy(how = How.ID, using = "small-searchterms")
    public WebElement searchBoxOfItems;

    @FindBy(how = How.CSS, using = "#small-search-box-form input:nth-child(2)")
    public WebElement searchButtonOfItems;

    @FindBy(how = How.CSS, using = ".no-result")
    public WebElement productNotAvailableText;

    @FindBy(how = How.CSS, using = ".ico-logout")
    public WebElement logoutButton;

    public void clickLogIn() {
        loginButton.click();
    }

    public void clickLogInAfterEnteringCredentials() {
        login.click();
    }

    public void insertUserEmail(String email) {
        userEmailBox.sendKeys(email);
    }

    public void insertUserPassword(String password) {
        userPasswordBox.sendKeys(password);
    }

    public void clickGoToHome() {
        goToHome.click();
    }

    public void insertValueInSearchBoxOfItems(String value) {
        searchBoxOfItems.sendKeys(value);
    }

    public String fetchProductNotAvailableText() {
        return productNotAvailableText.getText();
    }

    public String fetchAccountTextAfterLogin() {
        return accountAfterLogin.getText();
    }

    public void clickSearchItemsButton() {
        searchButtonOfItems.click();
    }
}
