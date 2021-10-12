package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedAccountPage extends LoginPage{

    public WebElement getAccountName() {
        return accountName;
    }

    //Locators
    @FindBy(xpath = "//a[@class='dropdown-toggle nav-link']")
    WebElement accountName;

    //Page Object
    public String getAccountNameText(){
        return getAccountName().getText();
    }
}
