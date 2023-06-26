package pageObjects.LaptopCategoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopCategoryPage {
    @FindBy(xpath = "//span[normalize-space()='Laptopy i tablety']")
    private WebElement laptopTabletButton;
    private WebDriver driver;

    public LaptopCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectLaptopAndTabletCategory() {
        laptopTabletButton.click();
    }
}
