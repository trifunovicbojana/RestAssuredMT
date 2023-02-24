package pageObjectModel.CheckoutPage;

import baseUtilities.BrowserManager;
import baseUtilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreditCard extends Functions {

    protected By cardPaymentRadioButton = By.xpath("//label[@for='payment-card']");
    protected By selectCard = By.id("change-card-button");
    protected By addNewCreditCardTab = By.id("addCreditCardTab");
    protected By cctype = By.xpath("//select[@name='c-ct']");
    protected By cardNumber = By.xpath("//input[@id='c-cardnumber']");
    protected By monthCCE = By.id("c-exmth");
    protected By yearCCE = By.id("c-exyr");
    protected By cName = By.id("c-cardname");
    protected By validateCCButton = By.id("PayNowButton");

    protected By cvvNumber = By.id("credit-card-cvv");

    public CreditCard(WebDriver driver) {
        super(driver);
    }

//    public CreditCard(WebDriver driver) {
//    }


    public void chooseCardPayment() {
        waitForElementToBeClickable(cardPaymentRadioButton);
        Click(cardPaymentRadioButton);
    }

    public void clickOnSelectCardButton() throws InterruptedException {
        scrollDown();
        waitForElementToBeClickable(selectCard);
        Thread.sleep(2000);
        Click(selectCard);
    }

    public void clickOnNewCreditCartTab() {
        Click(addNewCreditCardTab);
    }

    public void selectCreditCardType(String cardType) {
        switchToIframe();
        selectaValuedropdown(cctype, cardType);
    }
    public void addCreditCardNumber(String ccnumber) {
        SendKeys(cardNumber, ccnumber);
    }

    public void addCreditCardName(String ccName) {
        SendKeys(cName, ccName);
    }

    public void selectCreditCardMonth(String month) {
        selectaValuedropdown(monthCCE, month);
    }

    public void selectCreditCardYear(String year) {
        selectaValuedropdown(yearCCE, year);
        switchToMainWinow();
    }

    public void clickOnValidateButton() throws InterruptedException {
        switchToMainWinow();
        Thread.sleep(2000);
        waitForElementToBeClickable(validateCCButton);
        Click(validateCCButton);
    }

    public void addCvvNumber() {
        waitForElementToBeClickable(cvvNumber);
        SendKeys(cvvNumber, "123");
    }
    public void addCreditCardCheckout(String cardType, String month, String year, String ccnumber, String ccName ) throws InterruptedException {
        chooseCardPayment();
        clickOnSelectCardButton();
        clickOnNewCreditCartTab();
        selectCreditCardType(cardType);
        addCreditCardName(ccName);
        addCreditCardNumber(ccnumber);
        selectCreditCardMonth(month);
        selectCreditCardYear(year);
        clickOnValidateButton();

    }

//    public void addCreditCard(String cardType, String month, String year, String ccnumber, String ccName) throws InterruptedException {
//        waitForElementToBeClickable(cardPaymentRadioButton);
//        Click(cardPaymentRadioButton);
//        scrollDown();
//        waitForElementToBeClickable(selectCard);
//        Thread.sleep(2000);
//        Click(selectCard);
//        scrollUp();
//        Click(addNewCreditCardTab);
//        System.out.println("hohohoh");
//        switchToIframe();
//        SendKeys(cardNumber, ccnumber);
//        SendKeys(cName, ccName);
//        selectaValuedropdown(cctype, cardType);
//        selectaValuedropdown(monthCCE, month);
//        selectaValuedropdown(yearCCE, year);
//        switchToMainWinow();
//        Thread.sleep(2000);
//        waitForElementToBeClickable(validateCCButton);
//        Click(validateCCButton);
//
//    }


}
