package pageObjectModel.CheckoutPage;

import baseUtilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtherInformationSection extends Functions {
    protected By poNumberCheckout =By.id("checkoutform_form_referenceNumber");

    public OtherInformationSection(WebDriver driver) {
        super(driver);
    }

    public void addPoNumber() {
        SendKeys(poNumberCheckout,"12345" );

    }
}
