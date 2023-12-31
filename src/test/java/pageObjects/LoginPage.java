package pageObjects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {
    private Logger logger = LogManager.getLogger(LoginPage.class);
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='password-log']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Zaloguj się')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='form-control-error']")
    private WebElement incorrectEmailNotification;

    @FindBy(xpath = "//div[@class='mn-item mn-type-danger mn-item-push']")
    private WebElement incorrectLoginPopup;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this); //wywołanie PageFactory w konstruktorze żeby nie duplikować kodu podczas wywołania nowego obiektu
    }
@Step("Wpisanie adresu e-mail: {usernameEmail}")
    public LoginPage typeIntoUserEmailField(String usernameEmail) {
        WaitForElement.waitUntilElementIsVisible(userEmailField);
        userEmailField.sendKeys(usernameEmail);
        return this;
    }

    @Step("Wpisanie hasła: {password}")
    public LoginPage typeIntoUserPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }
@Step("Kliknięcie w przycisk do logowania")
    public TopMenuPage clickOnLoginButton() {
        loginButton.click();
        return new TopMenuPage();
    }
@Step("Assercja czy pojawia się informacja o niepoprawnym logowaniu")
    public LoginPage assertThatIncorrectEmailNotificationIsDisplayed(String wrongEmailNotification) {
        logger.info("Sprawdzenie czy wiadomość {} pojawia się",wrongEmailNotification);
        WaitForElement.waitUntilElementIsVisible(incorrectEmailNotification);
    AssertWebElement.assertThat(incorrectEmailNotification).isDisplayed().hasText(wrongEmailNotification);
        return this;
    }

    public String incorrectLoginDataPopup() {
        WaitForElement.waitUntilElementIsVisible(incorrectLoginPopup);
        String wrongDataPopup = incorrectLoginPopup.getText();
        return wrongDataPopup;
    }
}
