package tests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pageObjects.TopMenuPage;

import static org.testng.AssertJUnit.assertEquals;

public class CorrectLoginTests extends TestBase {

    @Test(priority = 1)
    @Description("Test poprawnego logowania się")
    @Severity(SeverityLevel.BLOCKER)
    public void correctLoginTest() {
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnLoginLink()
                .typeIntoUserEmailField("otua.tamotua@op.pll")
                .typeIntoUserPasswordField("TestyME123$")
                .clickOnLoginButton().assertThatNewNameButtonAfterCorrectLoginIsDisplayed("Witaj");
    }
}