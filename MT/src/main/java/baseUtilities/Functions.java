package baseUtilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class Functions {
  static  WebDriver driver;
    String option;
    WebDriverWait waitForElement;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    SoftAssert softAssert = new SoftAssert();

    public Functions(WebDriver driver) {
        this.driver = driver;
        this.waitForElement = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public void SendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void Click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean elementIsDispalyed(By locator) {
        if (driver.findElement(locator).isDisplayed())
            return true;
        else return false;
    }

    public String getValue(By locator) {
        return driver.findElement(locator).getAttribute("innerHTML");

    }

    public String getTextContent(By locator) {
        return driver.findElement(locator).getAttribute(("textContent"));
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void waitForElementToBeClickable(By locator) {
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void scrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
    }

    public void scrollUp() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,-350)");
    }

    public void selectaValuedropdown(By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByValue(value);
    }

    public void switchToIframe() {
        driver.switchTo().frame("paymetricIFrame");

    }

    public void switchToMainWinow() {
        driver.switchTo().parentFrame();
    }

    public void softVerifyElementIsDisplayed(By locator) {
        try {
            softAssert.assertTrue(driver.findElement(locator).isDisplayed());
            softAssert.assertAll();
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    public void verifyContains(String textExpected, String textActual) {
        Assert.assertTrue(textExpected.contains(textActual));
    }
}