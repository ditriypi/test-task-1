package test;

import Page.BasePage;

import Page.LoggedAccountPage;
import Page.RegistrationPage;
import User.User;
import User.UserRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest extends  TestRunner {
    @DataProvider
    public Object[][] createNewUser() {
        return new Object[][]{{UserRepository.getNewUser()}};
    }

    @Test(dataProvider ="createNewUser" )
    public void RegisteredWithRightCredentials(User create) {
        BasePage basePage = loadApplication();

        RegistrationPage registrationPage = basePage.goToRegistrationPage().
                sendDataInRegistrationField(create);

        LoggedAccountPage loggedAccountPage = registrationPage.clickSingInAndRegisteredAccount();
        String accountName = loggedAccountPage.getAccountNameText();

        Assert.assertEquals(accountName.toLowerCase(),create.getEmail());

    }
    @DataProvider
    public Object[][] createInvalidUser() {
        return new Object[][]{{UserRepository.getUserWithWrongPassword()}};
    }
    @Test(dataProvider ="createInvalidUser" )
    public void registeredWithWrongData(User create) {
        BasePage basePage = loadApplication();

        RegistrationPage registrationPage = basePage.goToRegistrationPage().
                sendDataInRegistrationField(create);

        LoggedAccountPage loggedAccountPage = registrationPage.clickSingInAndRegisteredAccount();

        String Alert = loggedAccountPage.getTextFromAlert();
        Assert.assertTrue(Alert.length()>0);



    }

}

