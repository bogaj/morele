package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TopMenuPage;

import static org.testng.AssertJUnit.assertEquals;

public class CorrectLoginTests extends TestBase {

    @Test(priority = 1)
    public void correctLoginTest() {
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnLoginLink()
                .typeIntoUserEmailField("otua.tamotua@op.pl")
                .typeIntoUserPasswordField("TestyME123$")
                .clickOnLoginButton();

        assertEquals(topMenuPage.newNameButtonAfterCorrectLogin(), "Witaj");
    }
}