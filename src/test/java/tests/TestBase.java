package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.BrowserFactory;
import driver.BrowserType;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static navigation.AppURLs.APPLICATION_URL;

public class TestBase {

@BeforeClass
@Step("Załadowanie ustawień z pliku configuration.properties")
public void beforeClass(){
    PropertiesLoader propertiesLoader = new PropertiesLoader();
    Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
    ConfigurationProperties.setProperties(propertiesFromFile);
}
@Step("Ustawienie przeglądarki i wejście na stronę")
    @BeforeMethod
    public void beforeTest() {

        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);

        WebElement cookiesAcceptButton = DriverManager.getWebDriver().findElement(By.xpath("//*[@id=\"cookie_box\"]/div/div/button"));
        cookiesAcceptButton.click();
    }

    @Step("Zamknięcie przeglądarki")
    @AfterMethod

    public void afterTest() {
        DriverManager.disposeDriver();
    }
}