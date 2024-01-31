package pageObjects.LaptopCategoryPages;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BasePage;
import waits.WaitForElement;

public class LaptopAndTabletsCategoryPage extends BasePage {

    @FindBy(xpath = "(//span[contains(text(),'Laptopy')])[4]")
    private WebElement laptopButton;





    public LaptopCategoryPage selectLaptopCategoryAndGoToLaptopList() {
        WaitForElement.waitUntilElementIsClickable(laptopButton);
        laptopButton.click();
        return new LaptopCategoryPage();
    }
}
