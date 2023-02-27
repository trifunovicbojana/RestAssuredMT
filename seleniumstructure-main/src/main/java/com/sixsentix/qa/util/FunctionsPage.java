package com.sixsentix.qa.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")


public abstract class FunctionsPage {

    protected WebDriverWait wait;
    protected WebDriver driver;
    private final Clock clock;
    private final Duration timeout = Duration.ofSeconds(10);
    private final Duration refreshPeriod = Duration.ofMillis(500);

    Logger logger = LoggerFactory.getLogger(FunctionsPage.class);

    public FunctionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.clock = Clock.systemDefaultZone();
    }

    protected void setTimeoutTo1() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    protected void setTimeoutTo5() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected void setTimeoutTo10() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitIsPresent(By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    protected List<WebElement> waitListIsPresent(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    protected void waitIsDisplayed(By by) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    protected void waitIsClickable(By by) {

        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    /**
     * This function is used for checking if all predefined elements are PRESENT and DISPLAYED on the given page.
     *
     * @param mapOfPageElements -> Providing HashMap of all elements that should be present on the given page in String,By format.
     * @param softAssert        -> Providing SoftAssert object so that all elements can be checked before throwing any exception.
     */
    public void checkIfPageContainsAllElements(HashMap<String, By> mapOfPageElements, SoftAssert softAssert) {
        if (mapOfPageElements.size() != 0) {

            checkIfEachElementIsPresentAndDisplayed(mapOfPageElements, softAssert);
            softAssert.assertAll();

        }
    }

    private void checkIfEachElementIsPresentAndDisplayed(HashMap<String, By> mapOfPageElements, SoftAssert softAssert) {
        for (Map.Entry<String, By> item : mapOfPageElements.entrySet()) {
            WebElement element;
            try {
                element = waitIsPresent(item.getValue());
                waitIsDisplayed(item.getValue());
                if (!element.isDisplayed()) {
                    softAssert.fail(item.getKey() + " element is not displayed.");
                }
            } catch (NoSuchElementException | TimeoutException e) {
                softAssert.fail(item.getKey() + " element is not present.");
            }
        }
    }


    /**
     * This function is used for checking if all predefined elements are PRESENT on the given page.
     * It's NOT checking if they are VISIBLE because on large pages that have scrolling .isDisplayed will break.
     *
     * @param mapOfPageElements -> Providing HashMap of all elements that should be present on the given page in String,By format.
     * @param softAssert        -> Providing SoftAssert object so that all elements can be checked before throwing any exception.
     */
    public void checkIfAllElementsArePresentOnThePage(HashMap<String, By> mapOfPageElements, SoftAssert softAssert) {
        if (mapOfPageElements.size() != 0) {

            checkIfEachElementIsPresent(mapOfPageElements, softAssert);
            softAssert.assertAll();

        }
    }

    private void checkIfEachElementIsPresent(HashMap<String, By> mapOfPageElements, SoftAssert softAssert) {
        for (Map.Entry<String, By> item : mapOfPageElements.entrySet()) {
            WebElement element;
            try {
                waitIsPresent(item.getValue());
            } catch (NoSuchElementException | TimeoutException e) {
                softAssert.fail(item.getKey() + " element is not present.");
            }
        }
    }

    public void checkIfPageContainsAllElementsUsingIframe(HashMap<String, By> mapOfPageElements, HashMap<String, String> mapOfPageIframes, SoftAssert softAssert) {
        if (mapOfPageElements.size() != 0) {

            String key;
            for (Map.Entry<String, By> item : mapOfPageElements.entrySet()) {
                key = item.getKey();
                driver.switchTo().defaultContent();
                WebElement element;

                for (Map.Entry<String, String> iframe : mapOfPageIframes.entrySet()) {
                    if (iframe.getKey().equals(key)) {
                        driver.switchTo().frame(iframe.getValue());
                    }
                }

                try {
                    element = waitIsPresent(item.getValue());
                    if (element != null) {
                        if (!element.isDisplayed()) {
                            softAssert.fail(key + " element is not displayed.");
                        }
                    } else {
                        softAssert.fail(key + " element is not present.");
                    }

                } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
                    softAssert.fail(key + " element is not present.");
                }
            }
            softAssert.assertAll();
        }
    }

    protected void waitIsGone(By by, String elementName) {
        Instant end = clock.instant().plus(timeout);
        setTimeoutTo1();
        for (Instant i = clock.instant(); i.isBefore(end); ) {
            i = i.plus(refreshPeriod);
            try {
                Thread.sleep(500);
                waitIsPresent(by);

            } catch (Exception e) {
                setTimeoutTo10();
                break;
            }
            if (i.getEpochSecond() >= end.getEpochSecond()) {
                Assert.fail("Element " + elementName + " with locator: " + by + " is still visible.");
            }
        }
        setTimeoutTo10();
    }

    protected void switchToIframe(String iFrame) {
        try {
            driver.switchTo().frame(iFrame);
        } catch (NoSuchFrameException e) {
            Assert.fail("The iFrame " + iFrame + "doesn't exist. Check structure.");
        }
    }

    protected void switchToIframeAndClickElement(String iFrame, By by, String elementName) {
        try {
            driver.switchTo().frame(iFrame);
        } catch (NoSuchFrameException e) {
            Assert.fail("The iFrame " + iFrame + "doesn't exist. Check structure.");
        }

        WebElement element;
        try {
            element = waitIsPresent(by);
            try {
                waitIsClickable(by);
                element.click();
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                element = waitIsPresent(by);
                waitIsClickable(by);
                element.click();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            logger.atError().log("Couldn't find " + elementName + " with locator: " + by);
            Assert.fail("Couldn't find " + elementName + " with locator: " + by);
        }
        driver.switchTo().defaultContent();
    }

    protected void switchToIframeAndInputText(String iFrame, By by, String text, String elementName) {
        try {
            driver.switchTo().frame(iFrame);
        } catch (NoSuchFrameException e) {
            Assert.fail("The iFrame " + iFrame + "doesn't exist. Check structure.");
        }
        try {
            WebElement element = waitIsPresent(by);
            waitIsDisplayed(by);
            element.sendKeys(text);
        } catch (NoSuchElementException | TimeoutException | ElementNotInteractableException e) {
            logger.atError().log("Couldn't find " + elementName + " with locator: " + by);
            Assert.fail("Couldn't find " + elementName + " with locator: " + by + e);
        } catch (StaleElementReferenceException e) {
            WebElement element = waitIsPresent(by);
            element.clear();
            element.sendKeys(text);
        }

        driver.switchTo().defaultContent();
    }

    protected void clickElementXpath(By by, String elementName) {

        WebElement element;

        try {
            element = waitIsPresent(by);
            try {
                waitIsClickable(by);
                element.click();
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                element = waitIsPresent(by);
                waitIsClickable(by);
                element.click();
            }
        } catch (NoSuchElementException | TimeoutException | ElementClickInterceptedException e) {
            logger.atError().log("Couldn't find or click " + elementName + " with locator: " + by);
            Assert.fail("Couldn't find or click " + elementName + " with locator: " + by);
        }
    }

    protected void clickButtonElementXpathJS(By by, String elementName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element;

        try {
            element = waitIsPresent(by);
            try {
                waitIsClickable(by);
                js.executeScript("arguments[0].click();", element);
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                element = waitIsPresent(by);
                waitIsClickable(by);
                js.executeScript("arguments[0].click();", element);
            }
        } catch (NoSuchElementException | TimeoutException e) {
            logger.atError().log("Couldn't find " + elementName + " with locator: " + by);
            Assert.fail("Couldn't find " + elementName + " with locator: " + by);
        }
    }

    protected void clickRadioButtonElementXpath(By by, String elementName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element;
        try {
            element = waitIsPresent(by);
            js.executeScript("arguments[0].style.opacity=1", element);

            try {
                waitIsClickable(by);
                js.executeScript("arguments[0].click();", element);
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                element = waitIsPresent(by);
                waitIsClickable(by);
                js.executeScript("arguments[0].click();", element);
                logger.atError().log("Element " + elementName + " with locator: " + by + " thrown StaleElementReferenceException exception before click");
            }
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            logger.atError().log("Couldn't find " + elementName + " with locator: " + by);
            Assert.fail("Couldn't find " + elementName + " with locator: " + by);
        }

    }

    protected void inputTextIntoDropdown(By by, String text, String elementName) {
        try {
            WebElement element = waitIsPresent(by);
            element.sendKeys(text + "\n");
        } catch (NoSuchElementException | TimeoutException | ElementNotInteractableException e) {
            e.printStackTrace();
            logger.atError().log("Couldn't find " + elementName + " with locator: " + by);
            Assert.fail("Couldn't find " + elementName + " with locator: " + by);
        } catch (StaleElementReferenceException e) {
            WebElement element = waitIsPresent(by);
            element.clear();
            element.sendKeys(text + "\n");
        }
    }

    protected void inputText(By by, String text, String elementName) {
        try {
            WebElement element = waitIsPresent(by);
            waitIsClickable(by);
            element.sendKeys(text);
        } catch (NoSuchElementException | TimeoutException | ElementNotInteractableException e) {
            e.printStackTrace();
            logger.atError().log("Couldn't find " + elementName + " with locator: " + by);
            Assert.fail("Couldn't find " + elementName + " with locator: " + by);
        } catch (StaleElementReferenceException e) {
            WebElement element = waitIsPresent(by);
            element.clear();
            element.sendKeys(text);
        }
    }

    protected void inputCurrentDate(By by, String elementName) {
        Format f = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = f.format(new Date());

        try {
            WebElement element = waitIsPresent(by);
            element.sendKeys(currentDate);
        } catch (NoSuchElementException | TimeoutException e) {
            logger.atError().log("Couldn't find " + elementName + " with locator: " + by);
            Assert.fail("Couldn't find " + elementName + " with locator: " + by);
        } catch (StaleElementReferenceException e) {
            WebElement element = waitIsPresent(by);
            element.clear();
            element.sendKeys(currentDate);

        }
    }

    protected void inputFutureDate(By by, String elementName) {
        String DATE_FORMAT = "MM/dd/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        // Get current date
        Date currentDate = new Date();

        // convert date to localdatetime
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        // plus one
        localDateTime = localDateTime.plusMonths(1);
        Date futureDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());


        try {
            WebElement element = waitIsPresent(by);
            element.sendKeys(dateFormat.format(futureDate));
        } catch (NoSuchElementException | TimeoutException e) {
            logger.atError().log("Couldn't find " + elementName + " with locator: " + by);
            Assert.fail("Couldn't find " + elementName + " with locator: " + by);
        } catch (StaleElementReferenceException e) {
            WebElement element = waitIsPresent(by);
            element.clear();
            element.sendKeys(dateFormat.format(futureDate));
        }
    }

    protected void isTextEqual(By by, String expectedText, String elementName) {
        WebElement element;
        element = waitIsPresent(by);
        String actualText = element.getText();
        if (!actualText.equals(expectedText)) {
            Assert.fail("Element:  " + elementName + " actually have text [ " + actualText + " ] but it should have text [ " + expectedText + " ]");
        }
    }

    protected static class LocatorAndText {

        public LocatorAndText(By locator, String text) {
            this.locator = locator;
            this.text = text;
        }

        By locator;
        String text;

        public By getLocator() {
            return locator;
        }

        public void setLocator(By locator) {
            this.locator = locator;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    protected void checkMultipleTexts(Map<String, LocatorAndText> mapOfElements, SoftAssert softAssert) {
        for (Map.Entry<String, LocatorAndText> item : mapOfElements.entrySet()) {
            LocatorAndText locatorAndText = item.getValue();
            WebElement element;

            try {
                element = waitIsPresent(locatorAndText.getLocator());
                waitIsDisplayed(locatorAndText.getLocator());
                waitIsClickable(locatorAndText.getLocator());

                if (item.getKey().equals("urlInputField")) { //Za URL polje tekst mora da se izvuce preko atributa.
                    String actualText = waitIsPresent(locatorAndText.getLocator()).getAttribute("value");
                    if (!actualText.equals(locatorAndText.getText())) {
                        softAssert.fail("Element: urlInputField actually have text [ " + actualText + " ] but it should have text [ " + locatorAndText.getText() + " ]");
                    }
                } else if (!element.getText().equals(locatorAndText.getText())) {
                    softAssert.fail(item.getKey() + " element text doesn't match the expected text. Text is: " + element.getText() + ", but it should be: " + locatorAndText.getText());
                }
            } catch (NoSuchElementException | TimeoutException e) {
                softAssert.fail(item.getKey() + " element is not present.");
            } catch (StaleElementReferenceException s) {
                element = waitIsPresent(locatorAndText.getLocator());
                waitIsDisplayed(locatorAndText.getLocator());
                waitIsClickable(locatorAndText.getLocator());
                if (!element.getText().equals(locatorAndText.getText())) {
                    softAssert.fail(item.getKey() + " element text doesn't match the expected text. Text is: " + element.getText() + ", but it should be: " + locatorAndText.getText());
                }
            }

        }
        softAssert.assertAll();
    }

    protected void checkMultipleTextsForInputFields(Map<String, LocatorAndText> mapOfElements, SoftAssert softAssert) {
        for (Map.Entry<String, LocatorAndText> item : mapOfElements.entrySet()) {
            LocatorAndText locatorAndText = item.getValue();
            WebElement element;

            try {
                waitIsPresent(locatorAndText.getLocator());
                waitIsDisplayed(locatorAndText.getLocator());
                String actualText = waitIsPresent(locatorAndText.getLocator()).getAttribute("value");
                if (!actualText.equals(locatorAndText.getText())) {
                    softAssert.fail("Element: urlInputField actually have text [ " + actualText + " ] but it should have text [ " + locatorAndText.getText() + " ]");
                }
            } catch (NoSuchElementException | TimeoutException | IllegalArgumentException e) {
                softAssert.fail(item.getKey() + " element is not present.");
            }

        }
        softAssert.assertAll();
    }

    protected void enterDataIntoMultipleInputFields(Map<String, LocatorAndText> mapOfElements, SoftAssert softAssert) {
        for (Map.Entry<String, LocatorAndText> item : mapOfElements.entrySet()) {
            LocatorAndText locatorAndText = item.getValue();
            WebElement element;
            try {
                element = waitIsPresent(locatorAndText.getLocator());
                waitIsDisplayed(locatorAndText.getLocator());
                waitIsClickable(locatorAndText.getLocator());
                element.sendKeys(locatorAndText.getText());
            } catch (NoSuchElementException | TimeoutException | ElementNotInteractableException e) {
                softAssert.fail(item.getKey() + " element is not present.");
            } catch (StaleElementReferenceException e) {
                element = waitIsPresent(locatorAndText.getLocator());
                waitIsClickable(locatorAndText.getLocator());
                element.clear();
                element.sendKeys(locatorAndText.getText());
            }

        }
        softAssert.assertAll();
    }


    protected void enterDataInMultipleDropdowns(Map<String, LocatorAndText> mapOfElements, SoftAssert softAssert) {
        for (Map.Entry<String, LocatorAndText> item : mapOfElements.entrySet()) {
            LocatorAndText locatorAndText = item.getValue();
            WebElement element;
            try {
                element = waitIsPresent(locatorAndText.getLocator());
                element.sendKeys(locatorAndText.getText() + "\n");
            } catch (NoSuchElementException | TimeoutException | ElementNotInteractableException e) {
                e.printStackTrace();
                logger.atError().log("Couldn't find " + item.getKey() + " with locator: " + locatorAndText.getLocator());
                softAssert.fail("Couldn't find " + item.getKey() + " with locator: " + locatorAndText.getLocator());
            } catch (StaleElementReferenceException e) {
                element = waitIsPresent(locatorAndText.getLocator());
                element.clear();
                element.sendKeys(locatorAndText.getText() + "\n");
            }

        }
        softAssert.assertAll();
    }
}
