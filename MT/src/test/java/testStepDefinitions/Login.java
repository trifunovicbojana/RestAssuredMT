package testStepDefinitions;

import baseUtilities.BrowserManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjectModel.Homepage;
import pageObjectModel.LoginPage;

public class Login {

    @Given("User is on login page")
    public void user_is_on_login_page() {

    }
    LoginPage login=new LoginPage(BrowserManager.getDriver());
    Homepage homepage=new Homepage(BrowserManager.getDriver());

 @When("user enters valid credentials {string} and {string}")
  public void user_enters_valid_credentials_and(String username1, String password1) {
        login.Click(login.exitCookies);
        login.SendKeys(login.usernameField, username1);
        login.SendKeys(login.passwordField, password1);
        login.Click(login.loginButton);
 }

 @When("chooses soldTo {string}")
 public void chooses_sold_to(String string) {
       login.Click(login.soldTo);
       login.Click(login.selectSoldTo);
  }

    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
    Assert.assertEquals(homepage.elementIsDispalyed(homepage.myAccountUsername),true);
    Assert.assertEquals(homepage.getText(homepage.myAccountUsername),"Borko MTMO US DP");

    }


}