package pageObjects.LaptopCategoryPages;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BasePage;
import waits.WaitForElement;

public class LaptopCategoryPage extends BasePage {
    @FindBy(xpath = "//span[normalize-space()='Laptopy i tablety']")
    private WebElement laptopTabletButton;




    public LaptopAndTabletsCategoryPage selectLaptopAndTabletCategory() {
        WaitForElement.waitUntilElementIsClickable(laptopTabletButton);
        laptopTabletButton.click();
        return new LaptopAndTabletsCategoryPage();
    }
}
