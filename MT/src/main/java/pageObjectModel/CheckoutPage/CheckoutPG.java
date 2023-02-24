package pageObjectModel.CheckoutPage;

import baseUtilities.BrowserManager;
import baseUtilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectModel.PLPage;


public class CheckoutPG extends Functions{
String deliveryA;
String billingA;
    public CheckoutPG(WebDriver driver) {
        super(driver);
    }
    PLPage plPage =new PLPage(BrowserManager.getDriver());



    protected By validateOrderButton=By.id("checkoutFormSubmitAction");

    protected By delyveryEditButton=By.xpath("//div[contains(@class,'delivery-btn-left')]");
    protected By addNewDeliveryAddressButton=By.id("newDelAddress");
    protected By billingEditButton=By.xpath("//button[@class='btn btn-3 sm sm-height30 billing-edit-btn edit-btn-width']");
    protected By addNewBillingAddressButton=By.id("newAddressInvoice");

    protected By companyName1=By.id("firstname");
    protected By addressLine1=By.id("streetname");
    protected By city=By.id("town");
    protected By zipCode=By.id("postalCode");
    protected By state=By.xpath("//select[contains(@id,'egionIso')]");

    protected By saveAddress=By.id("addressSavebtn");
    protected By companyname1Errormessage =By.xpath("//small[contains(@data-bv-for,'firstname')][normalize-space()='Please enter a value.']");
    protected By addressLine1ErrorMessage=By.xpath("//small[contains(@data-bv-for,'streetname')][normalize-space()='Please enter a value.']");
    protected By cityErrorMessage=By.xpath("//small[contains(@data-bv-for,'streetname')][normalize-space()='Please enter a value.']");
    protected By postalCodeErrorMessage=By.xpath("//small[contains(@data-bv-for,'town')][normalize-space()='Please enter a value.']");
    protected By stateErrorMessage=By.xpath("//small[contains(@data-bv-for,'regionIso')][normalize-space()='Please enter a value.']");

    protected By deliveryAddressSaved=By.xpath("//p[@class='deliverAddressPanel margin-top-20']");
    protected By billingAddressSaved=By.xpath("//p[contains(@class,'margin-top-20 min-height-150')]");

    protected By yourNetPrice = By.xpath("//div[contains(@class,'eco2-grand-total totalValues')]");



    public void openNewDeliveryAddressForm() {
         waitForElementToBeClickable(delyveryEditButton);
         Click(delyveryEditButton);
         waitForElementToBeClickable(addNewDeliveryAddressButton);
         Click(addNewDeliveryAddressButton);
    }

    public void checkMandatoryFieldsAddress ()
    {
        waitForElementToBeClickable(saveAddress);
        Click(saveAddress);
        softVerifyElementIsDisplayed(companyname1Errormessage);
        softVerifyElementIsDisplayed(addressLine1ErrorMessage);
        softVerifyElementIsDisplayed(cityErrorMessage);
        softVerifyElementIsDisplayed(postalCodeErrorMessage);
        softVerifyElementIsDisplayed(stateErrorMessage);
    }
    public void addNewDeliveryAddress () {
        SendKeys(companyName1, "Test Company");
        SendKeys(addressLine1,"Address Line1");
        SendKeys(city, "Beograd");
        SendKeys(zipCode, "12345");
        selectaValuedropdown(state, "AL");
        Click(saveAddress);
    }
    public void bufferDeliveryAddress () throws InterruptedException {
        Thread.sleep(2000);
      deliveryA=getTextContent(deliveryAddressSaved);
    }
    public void verifyDeliveryAddress(String deliveryExpected) {
        verifyContains(deliveryA, deliveryExpected);
    }
    public void bufferBillingAddressCheckout() throws InterruptedException {
        Thread.sleep(4000);
        billingA = getTextContent(billingAddressSaved);
        System.out.println("billing"+ billingA);
    }
        public void verifyBillingAddress (String billingExpected) {
            verifyContains(billingA, billingExpected);
        }


    public void openNewBillingAddressForm() {
        waitForElementToBeClickable(billingEditButton);
        Click(billingEditButton);
        waitForElementToBeClickable(addNewBillingAddressButton);
        Click(addNewBillingAddressButton);

    }


    public void verifyDataTotalCheckout () {
        String price = getTextContent(yourNetPrice);
        System.out.println("price=" + price);
        price= price.replaceAll("\\s","");
        verifyContains(plPage.pricesValuePLP, price);
    }

public void clickValidateOrderButton() throws InterruptedException {
          Thread.sleep(2000);
          scrollDown();
          waitForElementToBeClickable(validateOrderButton);
          Click(validateOrderButton);
}

    }
