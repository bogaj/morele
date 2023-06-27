package pageObjects;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class SearchEnginePage {

private WebElement searchResult;


    public SearchEnginePage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void searchResultListCompareToSearch(String nameOfProduct) {
        List<WebElement> searchResult = DriverManager.getWebDriver().findElements(By.xpath("(//div[@class='cat-product card'])"));

        for (WebElement result : searchResult) {
            String resultText = result.getText();
            assertTrue(resultText.contains(nameOfProduct));
        }


    }}
