package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
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

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this); //wywołanie PageFactory w konstruktorze żeby nie duplikować kodu podczas wywołania nowego obiektu
    }

    public void typeIntoUserEmailField(String usernameEmail) {
        userEmailField.sendKeys(usernameEmail);
    }

    public void typeIntoUserPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String incorrectEmailLoginNotification() {
        String wrongEmailNotification = incorrectEmailNotification.getText();
        return wrongEmailNotification;
    }

    public String incorrectLoginDataPopup() {
        String wrongDataPopup = incorrectLoginPopup.getText();
        return wrongDataPopup;
    }
}
