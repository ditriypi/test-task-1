package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

 interface IBrowser {
    public  WebDriver getBrowser();
}


class DriverInstanceChrome implements IBrowser{
    @Override
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
class DriverInstanceFierfox implements IBrowser{

    @Override
    public WebDriver getBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return  new FirefoxDriver();

    }
}

class DriverInstanceEge implements IBrowser{

    @Override
    public WebDriver getBrowser() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}

public enum DriverList{

    DEFAULT_DRIVER(new DriverInstanceChrome()),
    CHROME_DRIVER(new DriverInstanceChrome()),
    FIERFOX_DRIVER(new DriverInstanceFierfox()),
    EGE_DRIVER(new DriverInstanceEge());
    private IBrowser browser;
    DriverList(IBrowser browser){
       this.browser = browser;
    }
    WebDriver getDriver(){
        return browser.getBrowser();
    }
}
