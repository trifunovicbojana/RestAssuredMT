package baseUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class BrowserManager {
    public static WebDriver driver;
    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // C://Users//btrifunovic//Downloads//chromedriver_win32//chromedriver.exe
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        return driver;
    }


    public void openBrowser(String url) {
        createDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

        public static WebDriver getDriver() {
            return driver;
        }
}
