package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TopMenuPage;
import static org.testng.AssertJUnit.assertEquals;

public class CorrectLoginTests extends TestBase {

    @Test(priority = 1)
    public void correctLoginTest() {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnLoginLink();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeIntoUserEmailField("otua.tamotua@op.pl");

        loginPage.typeIntoUserPasswordField("TestyME123$");
            loginPage.clickOnLoginButton();
            topMenuPage.newNameButtonAfterCorrectLogin();

        assertEquals(topMenuPage.newNameButtonAfterCorrectLogin(), "Witaj");
    }
}