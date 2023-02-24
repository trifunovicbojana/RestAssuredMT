package pageObjectModel.CheckoutPage;

import baseUtilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarSections extends Functions {
    protected By calendarIcon=By.className("input-group-addon");
    protected By calendarNext=By.className("next");
    protected By calendarActiveDate=By.xpath("//td[@class='day']");

    public CalendarSections(WebDriver driver) {
        super(driver);
    }
    public void addDeliveryDate () throws InterruptedException {
        Click(calendarIcon);
        Click(calendarNext);
        Click(calendarActiveDate);

    }
}
