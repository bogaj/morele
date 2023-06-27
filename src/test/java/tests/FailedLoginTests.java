package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TopMenuPage;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase {


    @Test(priority = 3)
    public void loginUsingIncorrectEmailTest() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnLoginLink();

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserEmailField("otua.tamotua");

        loginPage.typeIntoUserPasswordField("TestyME123$");
        loginPage.clickOnLoginButton();

        assertEquals(loginPage.incorrectEmailLoginNotification(), "Podaj poprawny adres e-mail!");

    }
    @Test(priority = 4)
    public void loginUsingIncorrectDataTest() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnLoginLink();
        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserEmailField("2122@wp.pl");

        loginPage.typeIntoUserPasswordField("Tes34tyMeewww1");
        loginPage.clickOnLoginButton();

        assertEquals(loginPage.incorrectLoginDataPopup(),"Dane logowania nie są poprawne. Zalogowanie nie powiodło się.");

    }

}