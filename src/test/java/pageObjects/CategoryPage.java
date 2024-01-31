package pageObjects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LaptopCategoryPages.LaptopCategoryPage;
import waits.WaitForElement;

public class CategoryPage extends BasePage{
@FindBy(xpath ="//span[normalize-space()='Laptopy']" )
private WebElement laptopCategoryLink;




    public LaptopCategoryPage choosingTheMainLaptopCategory (){
        WaitForElement.waitUntilElementIsClickable(laptopCategoryLink);
        laptopCategoryLink.click();
        return new LaptopCategoryPage();
    }
}
