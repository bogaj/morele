package tests;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.CategoryPage;
import pageObjects.LaptopCategoryPages.LaptopAndTabletsCategoryPage;
import pageObjects.LaptopCategoryPages.LaptopCategoryPage;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertTrue;

public class CartTests extends TestBase {

    @Test(priority = 8)
    public void addToCartWithoutLoginTest() {

        CategoryPage categoryPage = new CategoryPage();
        categoryPage.choosingTheMainLaptopCategory();

        LaptopCategoryPage laptopCategoryPage = new LaptopCategoryPage();
        laptopCategoryPage.selectLaptopAndTabletCategory();

        LaptopAndTabletsCategoryPage laptopAndTabletsCategoryPage = new LaptopAndTabletsCategoryPage();
        laptopAndTabletsCategoryPage.selectLaptopCategoryAndGoToLaptopList();

        WebElement addToCartButton = DriverManager.getWebDriver().findElement(By.xpath("(//div[@class='cat-product-buttons'])[1]"));
        addToCartButton.click();

        WebElement extendedWarrantyButton =DriverManager.getWebDriver().findElement(By.xpath("//button[@class='btn btn-md btn-primary w-100 js_extended-send-button']"));
        WaitForElement.waitUntilElementIsVisible(extendedWarrantyButton);
        extendedWarrantyButton.click();

        WebElement productAddedToCartSign = DriverManager.getWebDriver().findElement(By.cssSelector("div[class='product-box card card-mobile'] span"));
        assertTrue(productAddedToCartSign.getText().contains("Produkt dodany do koszyka"));
    }
}
