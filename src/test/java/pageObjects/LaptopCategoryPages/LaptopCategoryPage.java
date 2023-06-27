package pageObjects.LaptopCategoryPages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LaptopCategoryPage {
    @FindBy(xpath = "//span[normalize-space()='Laptopy i tablety']")
    private WebElement laptopTabletButton;


    public LaptopCategoryPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void selectLaptopAndTabletCategory() {
        WaitForElement.waitUntilElementIsClickable(laptopTabletButton);
        laptopTabletButton.click();
    }
}
