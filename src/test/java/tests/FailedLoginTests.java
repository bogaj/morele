package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TopMenuPage;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase {


    @Test(priority = 3)
    public void loginUsingIncorrectEmailTest() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnLoginLink()

                .typeIntoUserEmailField("otua.tamotua")
                .typeIntoUserPasswordField("TestyME123$")
                .clickOnLoginButton();
        LoginPage loginPage = new LoginPage();
        assertEquals(loginPage.incorrectEmailLoginNotification(), "Podaj poprawny adres e-mail!");

    }

    @Test(priority = 4)
    public void loginUsingIncorrectDataTest() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnLoginLink()
                .typeIntoUserEmailField("2122@wp.pl")
                .typeIntoUserPasswordField("Tes34tyMeewww1")
                .clickOnLoginButton();
        LoginPage loginPage = new LoginPage();
        assertEquals(loginPage.incorrectLoginDataPopup(), "Dane logowania nie są poprawne. Zalogowanie nie powiodło się.");

    }

}