package Page;

import User.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {


   //Locator
    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement  signIn;

    //Page Object

    private  WebElement getConfirmPassword(){return confirmPassword;}

    private  WebElement getSignIn(){return signIn;}

    private WebElement getEmail() {return email;}

    private WebElement getPassword() {return password;}

     private void clickOnSingIn()  {
        getSignIn().click();
     }

     private void sendEmailInEmailField(User user){
        getEmail().sendKeys(user.getEmail());
     }
     private void sendPasswordInPasswordField(User user)  {
        getPassword().sendKeys(user.getPassword());
     }

     private   void  setConfirmPasswordInConfirmField(User user)  {
             getConfirmPassword().sendKeys(user.getConfirm());
     }

      //Business logic

       public RegistrationPage sendDataInRegistrationField(User user)  {
        sendEmailInEmailField(user);
        sendPasswordInPasswordField(user);
        setConfirmPasswordInConfirmField(user);

        return  new RegistrationPage();
       }

      public LoggedAccountPage clickSingInAndRegisteredAccount(){
        clickOnSingIn();

        return  new LoggedAccountPage();
      }
}
