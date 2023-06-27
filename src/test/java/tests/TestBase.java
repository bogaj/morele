package tests;

import driver.DriverManager;
import driver.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {


    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("https://www.morele.net");

        WebElement cookiesAcceptButton = DriverManager.getWebDriver().findElement(By.xpath("//*[@id=\"cookie_box\"]/div/div/button"));
        cookiesAcceptButton.click();
    }

    @AfterMethod

    public void afterTest() {
        DriverManager.disposeDriver();
    }
}