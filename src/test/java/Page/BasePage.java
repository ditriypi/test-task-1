package Page;

import Browser.BrowserChoice;
import Search.ImplicitWaiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


   public BasePage(){
        PageFactory.initElements(BrowserChoice.getDriver(),this);
        ImplicitWaiting.setImplicitWaiting();
    }


    //Locator
    @FindBy(xpath = "//a[@class ='nav-link' ] [@href='/login']")
    WebElement login;

   @FindBy(xpath = "//a[contains(text(),'Home')]")
   WebElement home;

   @FindBy(xpath = "//a[@href='/contact']")
   WebElement contact;

   @FindBy(xpath = "//a[@href='/signup']")
   WebElement createAccount;

   //Page Object
    private WebElement getLogin() {return login;}

    private WebElement getHome() {return home;}

    private WebElement getContact() {return contact;}

    private WebElement getCreateAccount() {return createAccount;}

    private void clickOnLoginButton(){
        getLogin().click();
    }
    private void clickOnRegistrationButton(){
        getCreateAccount().click();
    }



    //Business logic
    public LoginPage goToLoginPage(){
       clickOnLoginButton();

        return new LoginPage();
    }
    public RegistrationPage goToRegistrationPage(){
        clickOnRegistrationButton();

        return new RegistrationPage();
    }
}
