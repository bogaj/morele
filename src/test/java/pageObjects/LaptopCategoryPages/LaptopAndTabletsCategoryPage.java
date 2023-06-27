package pageObjects.LaptopCategoryPages;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LaptopAndTabletsCategoryPage {

    @FindBy(xpath = "(//span[contains(text(),'Laptopy')])[4]")
    private WebElement laptopButton;



    public LaptopAndTabletsCategoryPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void selectLaptopCategoryAndGoToLaptopList() {
        WaitForElement.waitUntilElementIsClickable(laptopButton);
        laptopButton.click();
    }
}
