package pageObjects;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SubmenuPage {


    public SubmenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }
}
