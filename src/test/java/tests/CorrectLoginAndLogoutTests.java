package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TopMenuPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CorrectLoginAndLogoutTests extends TestBase {

    @Test(priority = 2)

    public void asUserLoginAndLogoutUsingValidLoginAndPasswordTest() {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserEmailField("otua.tamotua@op.pl");

        loginPage.typeIntoUserPasswordField("TestyME123$");
        loginPage.clickOnLoginButton();

        topMenuPage.newNameButtonAfterCorrectLogin();
        assertEquals(topMenuPage.newNameButtonAfterCorrectLogin(), "Witaj");

       topMenuPage.moveToWelcomeLink();

        WebElement logoutButton = driver.findElement(By.xpath("//a[normalize-space()='Wyloguj']"));
        logoutButton.click();
        assertTrue(topMenuPage.loginLinkAfterCorrectLogout().contains("Zaloguj się"));

    }

}
