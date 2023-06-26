package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
@FindBy(xpath ="//span[normalize-space()='Laptopy']" )
private WebElement laptopCategoryLink;
    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void choosingTheMainLaptopCategory (){

        laptopCategoryLink.click();
    }
}
