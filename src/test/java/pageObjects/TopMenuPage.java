package pageObjects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;



public class TopMenuPage {
private Logger logger = LogManager.getLogger(LoginPage.class);
    @FindBy(xpath = "//span[contains(text(),'Zaloguj si')]")
    private WebElement loginButton;

    @FindBy(xpath = "(//a[@class='h-control-btn'])[1]")
    private WebElement wishListButton;

    @FindBy(xpath = "//span[normalize-space()='Witaj']")
    private WebElement welcomeSign;

    @FindBy(xpath = "//div[@class='h-quick-search js--fake-search-bar']//input[@placeholder='Szukaj w ofercie 2 milionów produktów']")
    private WebElement searchEngineField;



    public TopMenuPage() {

        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @Step("Klinięcie w link do logowania się")
    public LoginPage clickOnLoginLink() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        logger.info("Kliknięcie linku do logowania się");
        return new LoginPage();
    }
@Step("Wybranie przycisku Lista Życzeń")
    public WishListPage clickOnWishList() {
        wishListButton.click();
        return new WishListPage();
    }
@Step("Przesunięcie do napisu 'Witaj'")
    public TopMenuPage moveToWelcomeLink() {
        Actions actions = new Actions(DriverManager.getWebDriver());
        actions.moveToElement(welcomeSign).perform();
        return this;
    }
@Step("Asercja czy następuje zmiana nazwy przycisku do logowawania zalogowaniu się")
    public TopMenuPage assertThatNewNameButtonAfterCorrectLoginIsDisplayed(String welcomeAfterCorrectLoginSign) {
        logger.info("Sprawdzenie czy po zalogowaniu zmieniła się nazwa przycisku do zalogwania na {}",welcomeAfterCorrectLoginSign);
        WaitForElement.waitUntilElementIsVisible(welcomeSign);
    AssertWebElement.assertThat(welcomeSign).isDisplayed().hasText(welcomeAfterCorrectLoginSign);
        return this;
    }
@Step("Asercja czy przycisk do logowania wyświetla 'Zaloguj się' po poprawnym wylogowaniu")
    public TopMenuPage assertThatLoginLinkAfterCorrectLogoutIsDisplayed(String loginLinkSign) {
        logger.info("Sprawdzenie czy przycisk do logowania wyświetla {} po poprawnym wylogowaniu",loginLinkSign);
        WaitForElement.waitUntilElementIsVisible(loginButton);
    AssertWebElement.assertThat(loginButton).isDisplayed().hasText(loginLinkSign);
        return this;
    }
@Step("Wpisanie w wyszukiwarkę wyszukiwanego produktu - {nameOfProduct} i potwierdzenie")
    public TopMenuPage typeToSearchEngineFieldAndConfirmByEnter(String nameOfProduct) {
        WaitForElement.waitUntilElementIsVisible(searchEngineField);
        searchEngineField.sendKeys(nameOfProduct, Keys.ENTER);
        return this;
    }
}
