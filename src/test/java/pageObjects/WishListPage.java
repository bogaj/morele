package pageObjects;


import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class WishListPage {
    @FindBy(xpath = "//div[@class='table-row shopping-list-item mUser-table-item mUser-row-date']//div[2]")
    private WebElement productAmountList;


    public WishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public String getProductsAmount() {
        WaitForElement.waitUntilElementIsVisible(productAmountList);
        String howManyProducts = productAmountList.getText();
        return howManyProducts;
    }

}
