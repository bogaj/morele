package tests;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.LaptopCategoryPages.LaptopAndTabletsCategoryPage;
import pageObjects.LaptopCategoryPages.LaptopCategoryPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AddProductToWishListTests extends TestBase {

    @Test(priority = 7)
    public void adProductToWishListTest() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnLoginLink()
                .typeIntoUserEmailField("otua.tamotua@op.pl")
                .typeIntoUserPasswordField("TestyME123$")
                .clickOnLoginButton()
                .newNameButtonAfterCorrectLogin();

        assertEquals(topMenuPage.newNameButtonAfterCorrectLogin(), "Witaj");

        CategoryPage categoryPage = new CategoryPage();
        categoryPage.choosingTheMainLaptopCategory()


 .selectLaptopAndTabletCategory()
.selectLaptopCategoryAndGoToLaptopList();

        WebElement addToWishListIcon = DriverManager.getWebDriver().findElement(By.xpath("(//i[@class='icon-like'])[3]"));
        addToWishListIcon.click();

        WebElement heartIconToWishList = DriverManager.getWebDriver().findElement(By.xpath("(//div[@class='shopping-lists-item '])[1]"));
        heartIconToWishList.click();

        topMenuPage.clickOnWishList();

        WishListPage wishListPage = new WishListPage();
        assertTrue(wishListPage.getProductsAmount().contains("1"));


    }


}
