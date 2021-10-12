package test;


import Page.BasePage;
import Page.LoggedAccountPage;
import Page.LoginPage;

import User.User;
import User.UserRepository;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginTest extends TestRunner {

    @DataProvider
    public Object[][]  getExistUser() {
        return new Object[][]{{UserRepository.getExistUser()}};


    }


    //Positive test
    @Test(dataProvider = "getExistUser")
    public void loginWithRightCredentials(User exUser){
        BasePage basePage = loadApplication();

        LoginPage loginPage = basePage.goToLoginPage()
                .sendLoginAndPasswordInLoginFields(exUser);

        LoggedAccountPage loggedAccountPage = loginPage.clickSingInAndLogin();

        String accountName = loggedAccountPage.getAccountNameText();

        Assert.assertEquals(accountName.toLowerCase(),exUser.getEmail());

    }

      @DataProvider
    public Object[][]  getWrongUser() {
        return new Object[][]{{UserRepository.getUserWithWrongPassword()}};
    }

    @Test(dataProvider = "getWrongUser")
    public void loginWithWrongCredentials(User wrongUser){
        BasePage basePage = loadApplication();

        LoginPage loginPage = basePage.goToLoginPage()
                .sendLoginAndPasswordInLoginFields(wrongUser);

        LoggedAccountPage loggedAccountPage = loginPage.clickSingInAndLogin();

        String Alert = loggedAccountPage.getTextFromAlert();
        Assert.assertTrue(Alert.length()>0);
        System.out.println(Alert);
    }

}

