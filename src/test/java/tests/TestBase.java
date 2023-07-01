package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static navigation.AppURLs.APPLICATION_URL;

public class TestBase {

@BeforeClass
public void beforeClass(){
    PropertiesLoader propertiesLoader = new PropertiesLoader();
    Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
    ConfigurationProperties.setProperties(propertiesFromFile);
}
    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);

        WebElement cookiesAcceptButton = DriverManager.getWebDriver().findElement(By.xpath("//*[@id=\"cookie_box\"]/div/div/button"));
        cookiesAcceptButton.click();
    }

    @AfterMethod

    public void afterTest() {
        DriverManager.disposeDriver();
    }
}