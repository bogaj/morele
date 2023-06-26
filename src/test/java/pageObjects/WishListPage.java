package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    @FindBy(xpath = "//div[@class='table-row shopping-list-item mUser-table-item mUser-row-date']//div[2]")
    private WebElement productAmountList;
    private WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductsAmount() {
        String howManyProducts = productAmountList.getText();
        return howManyProducts;
    }

}
