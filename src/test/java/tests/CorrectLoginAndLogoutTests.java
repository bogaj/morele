package tests;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TopMenuPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CorrectLoginAndLogoutTests extends TestBase {

    @Test(priority = 2)

    public void asUserLoginAndLogoutUsingValidLoginAndPasswordTest() {
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnLoginLink();

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserEmailField("otua.tamotua@op.pl");

        loginPage.typeIntoUserPasswordField("TestyME123$");
        loginPage.clickOnLoginButton();

        topMenuPage.newNameButtonAfterCorrectLogin();
        assertEquals(topMenuPage.newNameButtonAfterCorrectLogin(), "Witaj");

       topMenuPage.moveToWelcomeLink();

        WebElement logoutButton = DriverManager.getWebDriver().findElement(By.xpath("//a[normalize-space()='Wyloguj']"));
        logoutButton.click();
        assertTrue(topMenuPage.loginLinkAfterCorrectLogout().contains("Zaloguj się"));

    }

}
