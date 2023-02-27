package parallel.uiSteps;

import com.sixsentix.qa.driverFactory.DriverFactory;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.dashboard.DashboardPage;

public class DashboardSteps {

    LoginPage loginPage;
    DashboardPage dashboardPage;


    @When("User logs in with {string} account")
    public void userLogsInWithAccount(String accountType) {
        loginPage = new LoginPage(DriverFactory.getDriver(), "");
        loginPage.fillLoginData(accountType);
        dashboardPage = loginPage.pressLoginButtonValidData(accountType);
    }

}
