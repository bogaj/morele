package pageObjects.LaptopCategoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopAndTabletsCategoryPage {

    @FindBy(xpath = "(//span[contains(text(),'Laptopy')])[4]")
    private WebElement laptopButton;

    private WebDriver driver;

    public LaptopAndTabletsCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectLaptopCategoryAndGoToLaptopList() {
        laptopButton.click();
    }
}
