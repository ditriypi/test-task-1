package Search;

import Browser.BrowserChoice;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImplicitWaiting  {
    private static long TIME_PAUSE = 4;


    public static void setImplicitWaiting(){
        BrowserChoice.getDriver().manage().timeouts().implicitlyWait(TIME_PAUSE, TimeUnit.SECONDS);
        System.out.println("<___set Implicit Waiting___>");
    }
    public static void offImplicitWaiting(){
        TIME_PAUSE = 0;
    }


}
