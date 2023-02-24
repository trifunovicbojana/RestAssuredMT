package pageObjectModel;

import baseUtilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Functions {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public By usernameField = By.id("username");
    public By passwordField = By.id("password");
    public By loginButton = By.xpath("//button[normalize-space()='Login']");
    public By soldTo = By.xpath("//input[@uid='300552312']");
    public By selectSoldTo = By.className("soldToContinue_300552312");
    public By exitCookies = By.xpath("//button[@title='Close']");
    public By countryRegionPopupClose = By.xpath("//*[@id=\"mtModal\"]/div/div/div[1]/button");

    public void validUserLogin(String username, String password) {
       addUsername(username);
       addPassword(password);
       clickLoginButton();
    }
    public void addUsername(String username) {
        SendKeys(usernameField, username);
    }
 public void addPassword(String password) {
        SendKeys(passwordField, password);
 }
 public void clickLoginButton() {
        Click(loginButton);
 }
    public void chooseSoldTo() {
        Click(soldTo);
        Click(selectSoldTo);
    }

    public void exitCookies() {
        Click(exitCookies);
    }

    public void exitCountryRegionPopUp() {
        Click(countryRegionPopupClose);
    }

    public void checkCountryRegionPopUp() {
        boolean popUpCountry = elementIsDispalyed(countryRegionPopupClose);
        if (popUpCountry == true) {
            exitCountryRegionPopUp();
        }

    }
}