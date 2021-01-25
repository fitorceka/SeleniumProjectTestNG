package usermethods;

import org.openqa.selenium.support.PageFactory;
import userpageelements.LoginUserElements;
import utils.Driver;
import utils.UserExpectedFiles;
import utils.Waits;

public class LoginUserMethods {

    private static final Driver driver = Driver.getInstanceOfDriver();
    private final LoginUserElements loginUserElements;

    public LoginUserMethods() {
        loginUserElements = PageFactory.initElements(driver.getDriver(), LoginUserElements.class);
    }

    //methods
    public void loginWithUserAccount() throws InterruptedException {

        String userEmail = UserExpectedFiles.userEmail;
        String userPassword = UserExpectedFiles.userPassword;
        loginUserElements.clickLogIn();

        Waits.waitForElementToBeClickableAndClick(loginUserElements.userEmailBox);
        Thread.sleep(1000);

        loginUserElements.insertUserEmail(userEmail);
        Waits.waitForElementToBeClickableAndClick(loginUserElements.userPasswordBox);

        loginUserElements.insertUserPassword(userPassword);
        Waits.waitForElementToBeClickableAndClick(loginUserElements.login);
    }

    public String getTextOfAccountAfterLogin() {
        return loginUserElements.fetchAccountTextAfterLogin();
    }

    public void logoutAsUser() throws InterruptedException {
        loginUserElements.clickGoToHome();
        Waits.waitForElementToBeVisible(loginUserElements.logoutButton);
        Thread.sleep(1000);
        Waits.waitForElementToBeClickableAndClick(loginUserElements.logoutButton);
    }

    //for product that is not available in the store
    public String productNotAvailable() {
        loginUserElements.insertValueInSearchBoxOfItems(UserExpectedFiles.searchContent);
        loginUserElements.clickSearchItemsButton();
        Waits.waitForElementToBeVisible(loginUserElements.productNotAvailableText);
        return loginUserElements.fetchProductNotAvailableText();
    }
}
