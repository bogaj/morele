package tests;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
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
        topMenuPage.clickOnLoginLink()
       .typeIntoUserEmailField("otua.tamotua@op.pl")
        .typeIntoUserPasswordField("TestyME123$")
       .clickOnLoginButton()
       .newNameButtonAfterCorrectLogin();
        assertEquals(topMenuPage.newNameButtonAfterCorrectLogin(), "Witaj");

       topMenuPage.moveToWelcomeLink();

        WebElement logoutButton = DriverManager.getWebDriver().findElement(By.xpath("//a[normalize-space()='Wyloguj']"));
        logoutButton.click();
        assertTrue(topMenuPage.loginLinkAfterCorrectLogout().contains("Zaloguj się"));

    }

}
