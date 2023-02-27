package parallel.uiSteps;

import apiHandlers.ApiUtils;
import com.sixsentix.qa.driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.dashboard.DashboardPage;
import pages.LoginPage;

public class LoginSteps extends ApiUtils {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("User is redirected to the login page")
    public void userIsRedirectedToTheLoginPage() {
        loginPage = new LoginPage(DriverFactory.getDriver(), "");
    }

    @Then("All elements should be present on loginPage page")
    public void allElementsShouldBePresentOnLoginPagePage() {
        loginPage.checkAllElements();
    }


    @When("User inputs {string} set of data in username and password")
    public void userInputsSetOfDataInUsernameAndPassword(String setOfData) {
        loginPage.inputSetOfData(setOfData);
    }

    @And("User press Login button for {string} set of data")
    public void userPressLoginButtonForSetOfData(String setOfData) {
        if (setOfData.equals("admin") || setOfData.equals("client")) {
            dashboardPage = (DashboardPage) loginPage.pressLoginButton(setOfData);
        } else {
            loginPage = (LoginPage) loginPage.pressLoginButton(setOfData);
        }
    }

    @Then("User should be presented with {string} result")
    public void userShouldBePresentedWithResult(String setOfData) {
        switch (setOfData) {
            case "admin":
            case "client":
                dashboardPage.checkAllElements();
                break;
            case "invalidEmail":
            case "invalidEmailWithoutMonkey":
            case "empty":
            case "invalidPassword":
            case "invalidPasswordOver30Characters":
                loginPage.checkElement();
                break;
            default:
                break;
        }
    }


}
