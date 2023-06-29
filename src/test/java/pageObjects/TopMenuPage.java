package pageObjects;

import driver.manager.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

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

    public LoginPage clickOnLoginLink() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        return new LoginPage();
    }

    public WishListPage clickOnWishList() {
        wishListButton.click();
        return new WishListPage();
    }

    public TopMenuPage moveToWelcomeLink() {
        Actions actions = new Actions(DriverManager.getWebDriver());
        actions.moveToElement(welcomeSign).perform();
        return this;
    }

    public String newNameButtonAfterCorrectLogin() {
        WaitForElement.waitUntilElementIsVisible(welcomeSign);
        String welcomeAfterCorrectLoginSign = welcomeSign.getText();
        return welcomeAfterCorrectLoginSign;
    }

    public String loginLinkAfterCorrectLogout() {
        WaitForElement.waitUntilElementIsVisible(loginButton);
        String loginLinkSign = loginButton.getText();
        return loginLinkSign;
    }

    public TopMenuPage typeToSearchEngineFieldAndConfirmByEnter(String nameOfProduct) {
        WaitForElement.waitUntilElementIsVisible(searchEngineField);
        searchEngineField.sendKeys(nameOfProduct, Keys.ENTER);
        return this;
    }
}
