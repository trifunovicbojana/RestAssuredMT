package pageObjectModel;

import baseUtilities.BrowserManager;
import baseUtilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PLPage extends Functions {



    protected By addProductToCart = By.xpath("//button[@id='sendClickEventToGTM_64090106']");
    protected By addProductToCartRainin = By.xpath("//button[@id='sendClickEventToGTM_30456871']");
    protected By productHeaderRainin = By.xpath("//a[@id='sendClickEventToGTM_30456871']");
    protected By GoToCartPopUp = By.linkText("GO TO CART");
   // public By pricesPLP = By.xpath("//div[contains(@class, 'product-item-64090106')]");
    protected By pricesPLP=By.xpath("//div[@class='price product-item product-item-64090106 price-loaded']");
    protected By pricesPLPRainin=By.xpath("//div[@class='price product-item product-item-30456871 price-loaded']");

    public static String pricesValuePLP;

        public PLPage(WebDriver driver) {
            super(driver);
        }

        public void bufferProductPrices () {
        scrollDown();
        waitForElementToBeClickable(pricesPLP);
        String prices= getTextContent(pricesPLP);
        prices= prices.replaceAll(" ","");
        pricesValuePLP=prices.substring(10);
    }
    public void navigateToPdpRainin () {
        Click(productHeaderRainin);
    }
    public void addProductToCartRainin() {
        Click(addProductToCartRainin);
    }

    public void bufferProductPricesRainin () {
        scrollDown();
        waitForElementToBeClickable(pricesPLPRainin);
        String prices= getTextContent(pricesPLPRainin);
        prices= prices.replaceAll(" ","");
        pricesValuePLP=prices.substring(10);
    }

    public void addProductToCartPLP() {
        Click(addProductToCart);
    }
    public void goToCartPopUp() {
        waitForElementToBeClickable(GoToCartPopUp);
        Click(GoToCartPopUp);
    }
}
