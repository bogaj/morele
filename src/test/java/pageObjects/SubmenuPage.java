package pageObjects;

import driver.manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class SubmenuPage {


    public SubmenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }
}
