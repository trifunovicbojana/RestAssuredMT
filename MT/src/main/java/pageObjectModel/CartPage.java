package pageObjectModel;

import baseUtilities.BrowserManager;
import baseUtilities.Functions;
import com.google.errorprone.annotations.Var;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends Functions {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    PLPage plPage = new PLPage(BrowserManager.getDriver());
    String quantity;
    //  Homepage homepage=new Homepage(BrowserManager.getDriver());


    protected By checkoutButton = By.linkText("CHECKOUT");
    protected By selectAll = By.xpath("//div[@class='selectall']//span[@title='Checkbox']");
    protected By removeAll = By.id("remove_button");
    protected By miniCartIcon = By.xpath(".//div[@class='yCmsComponent']//i[@title='Cart']");
    protected By cartQuantity = By.className("mini-cart-count");
    protected By pricePerItem = By.xpath("//td[@class='itemPrice hidden-xs hidden-sm service-cart-section service-name-tr']");
    protected By yourNetPrice = By.xpath("//div[contains(@class,'eco2-grand-total totalValues')]");


    public void emptyCart() throws InterruptedException {
        clickOnMiniCartIcon();
        Thread.sleep(2000);
        plPage.goToCartPopUp();
        selectAll();
        Thread.sleep(2000);
        clickOnRemoveAll();
    }
    public void clickOnMiniCartIcon() {
        waitForElementToBeClickable(miniCartIcon);
        Click(miniCartIcon);
    }
    public void selectAll() {
        waitForElementToBeClickable(selectAll);
        Click(selectAll);
    }
    public void clickOnRemoveAll() {
        Click(removeAll);
    }

    public void checkCartIsEmpty() throws InterruptedException {
        quantity = getText(cartQuantity);
        boolean empty = quantity.isEmpty();
        System.out.println("empty=" + empty);
        if (empty == false) {
            emptyCart();
        }
    }

    public void verifyPrices() {
        String price = getTextContent(pricePerItem);
        price = price.replaceAll("\\s", "");
        System.out.println(price);
        verifyContains(price, plPage.pricesValuePLP);
        System.out.println(plPage.pricesValuePLP);
    }

    public void verifyDataTotalCart() {
        String price = getTextContent(yourNetPrice);
        price = price.replaceAll("\\s", "");
        System.out.println("price=" + price);
        verifyContains(plPage.pricesValuePLP, price);
    }

    public void clickOnGoToCheckoutButton() {
        waitForElementToBeClickable(checkoutButton);
        Click(checkoutButton);
    }


}



