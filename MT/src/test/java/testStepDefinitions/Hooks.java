package testStepDefinitions;

import baseUtilities.BrowserManager;
import baseUtilities.Functions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public WebDriver driver;

//    public Hooks() {
//        super(getDriver());
//    }
    BrowserManager browserManager=new BrowserManager();

    @Before(value = "@MTMOUSDP")
    public void openBrowserMTMOUSDP() {
        browserManager.openBrowser("https://botest-us-partner.store.mt.com/");
    }

    @Before(value = "@Rainin")
    public void openBrowserRainin() {
        browserManager.openBrowser("https://test.shoprainin.com/");
    }

}

    // @After
    // public void closeBrowser(){
    //      driver.quit();
    //  }
