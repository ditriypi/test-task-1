package Page;



import User.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  BasePage{

    //Locators
    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//a[@href='/forgot']")
    WebElement forgotPassword;

    @FindBy(xpath = "//div[@class='form-group'] //button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger fade show']")
    WebElement wrongDataAlert;

   //Page Object
   private WebElement getWrongDataAlert() {return wrongDataAlert;}

    private WebElement getEmail() {return email;}

    private WebElement getPassword() {return password;}

    private WebElement getForgotPassword() {return forgotPassword;}

    private WebElement getLoginButton() {return loginButton;}

   private void sendEmailInEmailField(User user){
        getEmail().sendKeys(user.getEmail());
   }

   private void sendPasswordInPasswordField(User user){
        getPassword().sendKeys(user.getPassword());
   }

   private void clickOnLoginButton(){
        getLoginButton().click();
   }

   public String getTextFromAlert(){
      return getWrongDataAlert().getText();
   }

    //Business logic
    public LoginPage sendLoginAndPasswordInLoginFields(User user){
        sendEmailInEmailField(user);
        sendPasswordInPasswordField(user);

        return  new LoginPage();
    }
    public LoggedAccountPage clickSingInAndLogin(){
        clickOnLoginButton();

        return new LoggedAccountPage();

    }

}
