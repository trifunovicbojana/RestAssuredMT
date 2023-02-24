package pageObjectModel;

import baseUtilities.BrowserManager;
import baseUtilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends Functions {
    String deliverAs;
    String billingAs;

    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    PLPage plPage = new PLPage(BrowserManager.getDriver());


    public By checkBoxTC = By.className("checkmark");
    public By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
    public By deliveryAddress = By.xpath("//p[@class='title-desc margin-top-55 ']");
    public By billingAddress = By.xpath("//p[@class='getCompressedAddressString']");
    protected By yourNetPrice = By.xpath("//div[contains(@class,'eco2-grand-total totalValues')]");


    public void clickOnTermsAndConditionsCB() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(checkBoxTC);
        Click(checkBoxTC);
    }

    public void clickOnPlaceOrderButton() {
        waitForElementToBeClickable(placeOrderButton);
        Click(placeOrderButton);
    }

    public void bufferDeliveryAddressSummary() {
        waitForElementToBeClickable(deliveryAddress);
        deliverAs = getTextContent(deliveryAddress);
    }

    public void verifyDelliveryAddressSummary(String deliveryExpected) {
        verifyContains(deliverAs, deliveryExpected);
    }

    public void bufferBillingAddressSummary() {
        billingAs = getTextContent(billingAddress);
    }

    public void veriffyBillingAddressSummary(String billingExpected) {
        verifyContains(billingAs, billingExpected);
    }

    public void verifyDataTotalSummary() {
        String price = getTextContent(yourNetPrice);
        price = price.replaceAll("\\s", "");
        System.out.println("price=" + price);
        verifyContains(plPage.pricesValuePLP, price);

    }
}