package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.CategoryPage;
import pageObjects.LaptopCategoryPages.LaptopAndTabletsCategoryPage;
import pageObjects.LaptopCategoryPages.LaptopCategoryPage;

import static org.testng.AssertJUnit.assertTrue;

public class CartTests extends TestBase {

    @Test(priority = 8)
    public void addToCartWithoutLoginTest() {

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.choosingTheMainLaptopCategory();

        LaptopCategoryPage laptopCategoryPage = new LaptopCategoryPage(driver);
        laptopCategoryPage.selectLaptopAndTabletCategory();

        LaptopAndTabletsCategoryPage laptopAndTabletsCategoryPage = new LaptopAndTabletsCategoryPage(driver);
        laptopAndTabletsCategoryPage.selectLaptopCategoryAndGoToLaptopList();

        WebElement addToCartButton = driver.findElement(By.xpath("(//div[@class='cat-product-buttons'])[1]"));
        addToCartButton.click();

        WebElement extendedWarrantyButton = driver.findElement(By.xpath("//button[@class='btn btn-md btn-primary w-100 js_extended-send-button']"));
        extendedWarrantyButton.click();

        WebElement productAddedToCartSign = driver.findElement(By.cssSelector("div[class='product-box card card-mobile'] span"));
        assertTrue(productAddedToCartSign.getText().contains("Produkt dodany do koszyka"));
    }
}
