package testStepDefinitions;

import baseUtilities.BrowserManager;
import baseUtilities.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjectModel.*;


public class endToEnd {

    LoginPage loginPage = new LoginPage(BrowserManager.getDriver());
    Homepage homepage = new Homepage(BrowserManager.getDriver());
    CartPage cartPage = new CartPage(BrowserManager.getDriver());
    PLPage plPage=new PLPage(BrowserManager.getDriver());
    DataReader dataReader = new DataReader();

    @Given("User is on Login page as a guest")
    public void user_is_on_login_page_as_a_guest() {
        loginPage.checkCountryRegionPopUp();
        loginPage.exitCookies();

    }

    @Given("Logged User {string} {string} is on Homepage")
    public void logged_user_is_on_homepage(String username, String password) {
        loginPage.exitCookies();
        loginPage.validUserLogin(username, password);
        loginPage.chooseSoldTo();
    }
    @When("guest user adds product to cart using category bar")
    public void guest_user_adds_product_to_cart_using_category_bar() throws InterruptedException {
        homepage.chooseProductCategoryUniversal(dataReader.getPropertyValue("Category"));
        homepage.chooseProductSubcategoryUniversal("Single Channel Manual Pipettes");
        plPage.bufferProductPricesRainin();
        plPage.navigateToPdpRainin();
        plPage.addProductToCartRainin();
        plPage.goToCartPopUp();
        cartPage.verifyPrices();
        cartPage.verifyDataTotalCart();
        cartPage.clickOnGoToCheckoutButton();
    }
    @When("user Adds Product to cart using category bar")
    public void user_adds_product_to_cart_using_category_bar() throws InterruptedException {
        cartPage.checkCartIsEmpty();
        homepage.chooseProductCategory();
        plPage.bufferProductPrices();
        plPage.addProductToCartPLP();
        plPage.goToCartPopUp();
        cartPage.verifyPrices();
        cartPage.verifyDataTotalCart();
        cartPage.clickOnGoToCheckoutButton();
    }
    @When("user adds Personal Information")
    public void user_adds_personal_information() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




    }
