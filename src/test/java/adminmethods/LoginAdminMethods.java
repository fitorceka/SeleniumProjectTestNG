package adminmethods;

import adminpageelements.LoginAdminElements;
import org.openqa.selenium.support.PageFactory;
import utils.*;

public class LoginAdminMethods {

    public static Driver d = Driver.getInstanceOfDriver();
    private final LoginAdminElements loginAdminElements;

    public LoginAdminMethods() {
        loginAdminElements = PageFactory.initElements(d.getDriver(), LoginAdminElements.class);
    }

    //correct admin
    public void loginAsCorrectAdmin() throws InterruptedException {
        String adminEmail = AdminExpectedFiles.adminEmail;
        Waits.waitForElementToBeClickable(loginAdminElements.adminEmailInputBox);
        Thread.sleep(1000);

        if (loginAdminElements.fetchAdminEmailText().isEmpty()) {
            loginAdminElements.adminEmailInputBox.sendKeys(adminEmail);
        }

        loginAdminElements.adminLoginButton.click();
    }

    public void logoutAsAdmin() throws InterruptedException {
        ActionsClass.moveToElementAndClick(loginAdminElements.goToHomeLogo);
        Waits.waitForElementToBeClickable(loginAdminElements.logoutButton);
        Thread.sleep(1000);
        loginAdminElements.logoutButton.click();
    }

    public String returnAdminFullName() {
        return loginAdminElements.fetchAdminNameText();
    }
}
