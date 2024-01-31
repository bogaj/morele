package pageObjects;


import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class WishListPage extends BasePage {
    @FindBy(xpath = "//div[@class='table-row shopping-list-item mUser-table-item mUser-row-date']//div[2]")
    private WebElement productAmountList;




    public String getProductsAmount() {
        WaitForElement.waitUntilElementIsVisible(productAmountList);
        String howManyProducts = productAmountList.getText();
        return howManyProducts;
    }

}
