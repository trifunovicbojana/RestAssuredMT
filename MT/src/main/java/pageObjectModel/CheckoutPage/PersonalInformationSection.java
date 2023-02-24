package pageObjectModel.CheckoutPage;

import baseUtilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInformationSection extends Functions {


    public PersonalInformationSection(WebDriver driver) {
        super(driver);

    }
        protected By GuestTittle= By.id("guestTitle");
        protected By guestFirstName =By.id("guestFirstName");
        protected By guestLastName=By.id("guestLastName");
        protected By guestEmail=By.id("guestEmail");
        protected By guestPhoneNumber=By.id("guestPhoneNumber");

}
