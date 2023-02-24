package testStepDefinitions;

import baseUtilities.BrowserManager;
import baseUtilities.DataReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjectModel.SummaryPage;


public class Summary {
    SummaryPage summaryPage = new SummaryPage(BrowserManager.getDriver());
    DataReader dataReader = new DataReader();



    @When("user Checks the Data on Summary Page")
        public void user_checks_the_data_on_summary_page () {
            summaryPage.bufferDeliveryAddressSummary();
            summaryPage.verifyDelliveryAddressSummary("Test CompanyAddress Line1Beograd Alabama 12345 USA");
            summaryPage.bufferBillingAddressSummary();
            summaryPage.veriffyBillingAddressSummary("Test CompanyAddress Line1Beograd Alabama 12345 USA");

        }
        @Then("user Buys the Product")
        public void user_buys_the_product () throws InterruptedException {
            summaryPage.clickOnTermsAndConditionsCB();
            summaryPage.clickOnPlaceOrderButton();


    }
}
