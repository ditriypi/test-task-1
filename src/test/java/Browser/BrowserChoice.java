package Browser;

import org.openqa.selenium.WebDriver;

public class BrowserChoice {
 private static WebDriver driver;
public static void setDriver(DriverList list){
    driver = list.getDriver();
}

 public static WebDriver getDriver(){
     if(driver == null) {return  DriverList.DEFAULT_DRIVER.getDriver();}

     else return driver;
 }

 public static void quitDriver(){
    if(driver!= null) {
        getDriver().quit();
    }
 }

}
