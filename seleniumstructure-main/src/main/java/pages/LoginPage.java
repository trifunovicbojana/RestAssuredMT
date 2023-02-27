package pages;

import com.sixsentix.qa.driverFactory.DriverFactory;
import com.sixsentix.qa.util.FunctionsPage;
import com.sixsentix.qa.util.Resources;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.dashboard.DashboardPage;

import java.util.HashMap;


public class LoginPage extends FunctionsPage {

    public LoginPage(WebDriver driver, String subPage) {
        super(driver);
        switch (subPage) { //ToDo -> one way to init map through constructor -> another way is shown in DashboardPage class
            case "emptyErrors":
                initMapWithEmptyErrors();
                break;
            case "invalidEmail":
            case "invalidEmailWithoutMonkey":
                initMapWithInvalidEmail();
                break;
            case "invalidPassword":
                initMapWithInvalidPassword();
                break;
            case "invalidPasswordOver30Characters":
                initMapWithInvalidPasswordOver30Characters();
                break;
            default:
                driver.get(Resources.loginPage.getResource());
                initMap();
                break;

        }
    }

    SoftAssert softAssert = new SoftAssert();
    HashMap<String, By> mapOfPageElements = new HashMap<>();

    public void goToSite(String str) {
        driver.get(str);
    }

    public void checkElement() {
        waitIsGone(By.xpath("//input[@value='Search Google ' and @name='btnK']"), "googleSearchButton");
    }

    private void initMap() {
        mapOfPageElements.put("emailInputField", By.xpath("//*[@qa-id='emailInputField']"));
        mapOfPageElements.put("passwordInputField", By.xpath("//*[@qa-id='passwordInputField']"));
        mapOfPageElements.put("loginButton", By.xpath("//*[@qa-id='loginButton']"));
        mapOfPageElements.put("logo", By.xpath("//*[@qa-id='logo']"));
        mapOfPageElements.put("h2Welcome", By.xpath("//*[@qa-id='h2Welcome']"));
        mapOfPageElements.put("h3Description", By.xpath("//*[@qa-id='h3Description']"));
    }

    private void initMapWithEmptyErrors() {
        mapOfPageElements.put("usernameInputFieldEmptyError", By.xpath("//*[@qa-id='emailWrapper']//div[text()='Please enter your E-mail!']"));
        mapOfPageElements.put("passwordInputFieldEmptyError", By.xpath("//*[@qa-id='passwordWrapper']//div[text()='Please enter your Password!']"));
    }

    private void initMapWithInvalidEmail() {
        mapOfPageElements.put("usernameInputFieldInvalidError", By.xpath("//*[@qa-id='emailWrapper']//div[text()='Please enter valid E-mail']"));
    }

    private void initMapWithInvalidPassword() {
        mapOfPageElements.put("wrongCredentialsMessage", By.xpath("//div[text()='Wrong credentials!']"));
    }

    private void initMapWithInvalidPasswordOver30Characters() {
        mapOfPageElements.put("wrongCredentialsMessage", By.xpath("//div[text()='The password may not be greater than 20 characters.']"));
    }

    public void checkAllElements() {
        checkIfPageContainsAllElements(mapOfPageElements, softAssert);
    }

    public void inputSetOfData(String data) {
        switch (data) {
            case "admin":
                inputText(mapOfPageElements.get("emailInputField"), "admin@payportal.com", "emailInputField");
                inputText(mapOfPageElements.get("passwordInputField"), "payportal", "passwordInputField");
                break;
            case "client":
                inputText(mapOfPageElements.get("emailInputField"), "client@payportal.com", "emailInputField");
                inputText(mapOfPageElements.get("passwordInputField"), "payportal", "passwordInputField");
                break;
            case "invalidEmail":
                inputText(mapOfPageElements.get("emailInputField"), "Invalid", "emailInputField");
                inputText(mapOfPageElements.get("passwordInputField"), "Invalid", "passwordInputField");
                break;
            case "empty":
                inputText(mapOfPageElements.get("emailInputField"), "", "emailInputField");
                inputText(mapOfPageElements.get("passwordInputField"), "", "passwordInputField");
                break;
            case "invalidPassword":
                inputText(mapOfPageElements.get("emailInputField"), "client@payportal.com", "emailInputField");
                inputText(mapOfPageElements.get("passwordInputField"), "invalidPassword", "passwordInputField");
                break;
            case "invalidEmailWithoutMonkey":
                inputText(mapOfPageElements.get("emailInputField"), "client.payportal.com", "emailInputField");
                inputText(mapOfPageElements.get("passwordInputField"), "payportal", "passwordInputField");
                break;
            case "invalidPasswordOver30Characters":
                inputText(mapOfPageElements.get("emailInputField"), "client@payportal.com", "emailInputField");
                inputText(mapOfPageElements.get("passwordInputField"), RandomStringUtils.randomAlphanumeric(31), "passwordInputField");
                break;
            default:
                break;
        }
    }

    public Object pressLoginButton(String state) {
        switch (state) {
            case "admin":
                clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
                return new DashboardPage(DriverFactory.getDriver(), "admin");
            case "client":
                clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
                return new DashboardPage(DriverFactory.getDriver(), "client");
            case "invalidEmail":
                clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
                return new LoginPage(DriverFactory.getDriver(), "invalidEmail");
            case "empty":
                clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
                return new LoginPage(DriverFactory.getDriver(), "emptyErrors");
            case "invalidPassword":
                clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
                return new LoginPage(DriverFactory.getDriver(), "invalidPassword");
            case "invalidEmailWithoutMonkey":
                clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
                return new LoginPage(DriverFactory.getDriver(), "invalidEmailWithoutMonkey");
            case "invalidPasswordOver30Characters":
                clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
                return new LoginPage(DriverFactory.getDriver(), "invalidPasswordOver30Characters");
            default:
                break;
        }
        return null;
    }

    public DashboardPage pressLoginButtonValidData(String accountType) {
        switch (accountType) {
            case "admin":
                clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
                return new DashboardPage(DriverFactory.getDriver(), "admin");
            case "client":
                clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
                return new DashboardPage(DriverFactory.getDriver(), "client");
            default:
                break;
        }
        return null;
    }

    public LoginPage pressLoginButtonInvalidEmail() {
        clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
        return new LoginPage(DriverFactory.getDriver(), "invalidEmail");
    }

    public LoginPage pressLoginButtonEmptyData() {
        clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
        return new LoginPage(DriverFactory.getDriver(), "emptyErrors");
    }

    public LoginPage pressLoginButtonInvalidPassword() {
        clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
        return new LoginPage(DriverFactory.getDriver(), "invalidPassword");
    }

    public LoginPage pressLoginButtonInvalidEmailWithoutMonkey() {
        clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
        return new LoginPage(DriverFactory.getDriver(), "invalidEmailWithoutMonkey");
    }

    public LoginPage pressLoginButtonInvalidPasswordOver30characters() {
        clickElementXpath(mapOfPageElements.get("loginButton"), "LoginButton");
        return new LoginPage(DriverFactory.getDriver(), "invalidPasswordOver30Characters");

    }

    public void fillLoginData(String accountType) {
        switch (accountType) {
            case "admin":
                inputText(mapOfPageElements.get("emailInputField"), "admin@payportal.com", "emailInputField");
                inputText(mapOfPageElements.get("passwordInputField"), "payportal", "passwordInputField");
                break;
            case "client":
                inputText(mapOfPageElements.get("emailInputField"), "client@payportal.com", "emailInputField");
                inputText(mapOfPageElements.get("passwordInputField"), "payportal", "passwordInputField");
                break;
            default:
                break;
        }
    }

}