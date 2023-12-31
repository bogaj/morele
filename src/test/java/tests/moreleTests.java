
package tests;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class moreleTests extends TestBase {


    @Test(priority = 6)
    public void choosingLaptopCategoryTest() {
        WebElement laptopButtonFromMenu = DriverManager.getWebDriver().findElement(By.xpath("//span[normalize-space()='Laptopy']"));
        laptopButtonFromMenu.click();

        WebElement laptopTabletButton = DriverManager.getWebDriver().findElement(By.xpath("//span[normalize-space()='Laptopy i tablety']"));
        laptopTabletButton.click();

        WebElement laptopButton = DriverManager.getWebDriver().findElement(By.xpath("(//span[contains(text(),'Laptopy')])[4]"));
        laptopButton.click();

        List<WebElement> laptopListResult = DriverManager.getWebDriver().findElements(By.xpath("(//div[@class='cat-product card'])"));

        for (WebElement result : laptopListResult) {
            String resultText = result.getText();
            assertTrue(resultText.contains("Laptop"));
        }

    }


    @Test(priority = 9)
    public void newsletterSignupTest() {
        WebElement discountCodeButton = DriverManager.getWebDriver().findElement(By.xpath("//span[normalize-space()='ODBIERZ KOD RABATOWY']"));
        discountCodeButton.click();

        WebElement emailAddressForNewsletterField = DriverManager.getWebDriver().findElement(By.xpath("//input[@class='form-control form-control-material js--newsletter-focus']"));
        emailAddressForNewsletterField.sendKeys("etesttes@wp.pl");

        WebElement consentCheckbox = DriverManager.getWebDriver().findElement(By.xpath("(//span[@class='input'])[1]"));
        consentCheckbox.click();

        WebElement singUpButton = DriverManager.getWebDriver().findElement(By.xpath("(//input[@value='Zapisz mnie'])[1]"));
        singUpButton.click();

        WebElement newsletterSignupMsg = DriverManager.getWebDriver().findElement(By.xpath("//h1[@class='newsletter-header__heading subscribtion-value new-subscriber text-center']"));
        assertTrue(newsletterSignupMsg.getText().contains("Dziękujemy za zapisanie się do newslettera!"));
    }

    @Test(priority = 10)
    public void choosingGuideTest() {
        WebElement guideButton = DriverManager.getWebDriver().findElement(By.xpath("//span[@class='h-menu-item-value '][normalize-space()='PORADNIKI']"));
        guideButton.click();

        WebElement tabletForCarGuide = DriverManager.getWebDriver().findElement(By.xpath("//a[contains(text(),'Jakie pancerne etui na telefon wybrać? Czym się ki')]"));
        tabletForCarGuide.click();

        WebElement headTabletForCarGuide = DriverManager.getWebDriver().findElement(By.xpath("//div[@class='single-news-head']"));
        assertTrue(headTabletForCarGuide.getText().contains("Pancerny case na telefon to najlepszy sposób, by ochronić urządzenie będące nieodłącznym elementem naszego życia."));

    }


}