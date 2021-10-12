package Search;

import Browser.BrowserChoice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExplicitWaiting {
    ExpectedCondition condition;
    WebDriverWait wait = new WebDriverWait(BrowserChoice.getDriver(),4);



    public WebElement elementToBeClickable(WebElement webElement){
        ImplicitWaiting.offImplicitWaiting();
       return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public List<WebElement> elementsToBeClickable(WebElement webElement){
        ImplicitWaiting.offImplicitWaiting();
        return wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }
    public void setTypeWaiting(ExpectedCondition ex){condition = ex;}

    public  WebElement returnOwnSearchWait (){
        ImplicitWaiting.offImplicitWaiting();
        return (WebElement) wait.until(condition);
    }
}
