package usermethods;

import org.openqa.selenium.support.PageFactory;
import userpageelements.LoginUserElements;
import utils.Driver;
import utils.UserExpectedFiles;
import utils.Waits;

public class LoginUserMethods {

    private static Driver d = Driver.getInstanceOfDriver();
    private LoginUserElements loginUserElements;

    public LoginUserMethods() {

        loginUserElements = PageFactory.initElements(d.getDriver(), LoginUserElements.class);

    }

    //methods
    public void loginWithUserAccount() throws InterruptedException {

        String userEmail = UserExpectedFiles.userEmail;
        String userPassword = UserExpectedFiles.userPassword;
        loginUserElements.loginButton.click();
        Waits.waitForElementToBeClickableAndClick(loginUserElements.userEmailBox);
        Thread.sleep(1000);
        loginUserElements.userEmailBox.sendKeys(userEmail);
        Waits.waitForElementToBeClickableAndClick(loginUserElements.userPasswordBox);
        loginUserElements.userPasswordBox.sendKeys(userPassword);
        Waits.waitForElementToBeClickableAndClick(loginUserElements.login);

    }

    public String getTextOfAccountAfterLogin() {

        String text = loginUserElements.accountAfterLogin.getText();
        return text;

    }

    public void logoutAsUser() throws InterruptedException {

        loginUserElements.goToHome.click();
        Waits.waitForElementToBeVisible(loginUserElements.logoutButton);
        Thread.sleep(1000);
        Waits.waitForElementToBeClickableAndClick(loginUserElements.logoutButton);

    }

    //for product that is not available in the store
    public String productNotAvailable() {

        loginUserElements.searchBoxOfItems.sendKeys(UserExpectedFiles.searchContent);
        loginUserElements.searchButtonOfItems.click();
        Waits.waitForElementToBeVisible(loginUserElements.productNotAvailableText);
        return loginUserElements.productNotAvailableText.getText();

    }
}
