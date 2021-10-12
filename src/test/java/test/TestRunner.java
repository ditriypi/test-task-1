package test;

import Browser.BrowserChoice;
import Browser.DriverList;
import Page.BasePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestRunner  {
    private final String BaseURL = "https://sample-project.tech-stack.dev/";

    public BasePage loadApplication(){
        BrowserChoice.setDriver(DriverList.CHROME_DRIVER);
        BrowserChoice.getDriver().get(BaseURL);
       return new BasePage();

    }


    @AfterTest(alwaysRun = true)
    public void tearDown(){
        BrowserChoice.quitDriver();
        System.out.println("<....Browser Close.....>");
    }

}
