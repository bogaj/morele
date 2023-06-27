package pageObjects;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class CategoryPage {
@FindBy(xpath ="//span[normalize-space()='Laptopy']" )
private WebElement laptopCategoryLink;


    public CategoryPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void choosingTheMainLaptopCategory (){
        WaitForElement.waitUntilElementIsClickable(laptopCategoryLink);
        laptopCategoryLink.click();
    }
}
