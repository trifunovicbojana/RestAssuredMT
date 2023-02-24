package pageObjectModel;

import baseUtilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends Functions {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public String category;
    public String subcategory;

    public By myAccountUsername = By.className("UserName");
    public By categorySpareParts = By.linkText("Spare parts");
    public By subcategoryUniversal;
    public By categoryUniversal;

    public void chooseProductCategory() throws InterruptedException {
        Thread.sleep(2000);
        Click(categorySpareParts);
    }

    public void chooseProductSubcategoryUniversal(String subcategory) {
        this.subcategory = subcategory;
        this.subcategoryUniversal= By.linkText(subcategory);
        Click(subcategoryUniversal);


    }

    public void chooseProductCategoryUniversal(String category) {
        this.category = category;
        this.categoryUniversal = By.linkText(category);
        waitForElementToBeClickable(categoryUniversal);
        Click(categoryUniversal);
    }

}


