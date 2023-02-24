package testStepDefinitions;

import baseUtilities.BrowserManager;
import io.cucumber.java.en.When;
import pageObjectModel.CheckoutPage.CheckoutPG;
import pageObjectModel.CheckoutPage.CreditCard;
import pageObjectModel.CheckoutPage.OtherInformationSection;

public class Checkout {

CheckoutPG checkoutPG=new CheckoutPG(BrowserManager.getDriver());
CreditCard creditCard=new CreditCard(BrowserManager.getDriver());
OtherInformationSection otherInformationSection=new OtherInformationSection(BrowserManager.getDriver());

    @When("user opens Delivery address and checks mandatory fields")
    public void user_opens_delivery_address_and_checks_mandatory_fields() {
        checkoutPG.openNewDeliveryAddressForm();
        checkoutPG.checkMandatoryFieldsAddress();
    }

    @When("user Adds Delivery address")
    public void user_adds_delivery_address() throws InterruptedException {
        checkoutPG.addNewDeliveryAddress();
        checkoutPG.bufferDeliveryAddress();
        checkoutPG.verifyDeliveryAddress("Test CompanyAddress Line1Beograd Alabama 12345 USA");

    }

    @When("user Fills credit card data")
    public void user_fills_credit_card_data() throws InterruptedException {
        creditCard.addCreditCardCheckout("vi", "4", "2023", "4111111111111111", "Test");
        creditCard.addCvvNumber();


    }
    @When("user opens Billing address and checks mandatory fields")
    public void user_opens_billing_address_and_checks_mandatory_fields () {
        checkoutPG.openNewBillingAddressForm();
        checkoutPG.checkMandatoryFieldsAddress();
        checkoutPG.addNewDeliveryAddress();


    }
    @When("user Adds Billing address")
    public void user_adds_billing_address () throws InterruptedException {
        otherInformationSection.addPoNumber();
        // checkoutPage.addDeliveryDate();
        checkoutPG.bufferBillingAddressCheckout();
        checkoutPG.verifyBillingAddress("Test CompanyAddress Line1Beograd Alabama 12345 USA");
        checkoutPG.verifyDataTotalCheckout();
        checkoutPG.clickValidateOrderButton();
    }

}
