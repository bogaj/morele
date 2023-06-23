import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class moreleTests {

    private WebDriver driver;
    String loginEmail = "anianowak2112@o2.pl";
    String correctPassword = "Test@mgr123!";


    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_setting_values.geolocation", 2);
        prefs.put("profile.default_content_setting_values.media_stream_camera", 2);
        prefs.put("profile.default_content_setting_values.media_stream_microphone", 2);
        prefs.put("profile.default_content_setting_values.permissionSecondary", 2);

        options.setExperimentalOption("prefs", prefs);


        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");

        driver = new ChromeDriver(options);

        driver.navigate().to("https://www.morele.net");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));




        WebElement cookiesAcceptButton = driver.findElement(By.xpath("//*[@id=\"cookie_box\"]/div/div/button"));
        cookiesAcceptButton.click();
    }

    @Test(priority = 1)
    public void correctLoginTest() {
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Zaloguj się')]"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys(loginEmail);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-log']"));
        passwordField.sendKeys(correctPassword);

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Zaloguj się')]"));
        submitButton.click();

        WebElement welcomeSign = driver.findElement(By.xpath("//span[normalize-space()='Witaj']"));
        assertEquals(welcomeSign.getText(), "Witaj");
    }

    @Test(priority = 2)

    public void asUserLoginAndLogoutUsingValidLoginAndPasswordTest() {
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Zaloguj się')]"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys(loginEmail);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-log']"));

        passwordField.sendKeys(correctPassword);

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Zaloguj się')]"));
        submitButton.click();

        WebElement welcomeSign = driver.findElement(By.xpath("//span[normalize-space()='Witaj']"));
        assertEquals(welcomeSign.getText(), "Witaj");

        Actions actions = new Actions(driver);
        actions.moveToElement(welcomeSign).perform();

        WebElement logoutButton = driver.findElement(By.xpath("//a[normalize-space()='Wyloguj']"));
        logoutButton.click();

        loginButton = driver.findElement(By.xpath("//span[contains(text(),'Zaloguj się')]"));
        assertTrue(loginButton.getText().contains("Zaloguj się"));
    }

    @Test(priority = 3)
    public void loginUsingIncorrectEmailTest() {

        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Zaloguj się')]"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("2122");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-log']"));

        passwordField.sendKeys("Test@mgr1s23!");
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Zaloguj się')]"));
        submitButton.click();
        WebElement incorrectEmailNotification = driver.findElement(By.xpath("//div[@class='form-control-error']"));

        //nie wiem którą asercję, pierwsza pobiera tekst i porównuje z docelowym druga sprawdza czy locator się wyświetla

        assertEquals(incorrectEmailNotification.getText(), "Podaj poprawny adres e-mail!");
        //    assertTrue(incorrectEmailNotification.isDisplayed());
    }

    @Test(priority = 4)
    public void loginUsingIncorrectDataTest() {

        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Zaloguj się')]"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("2122@wp.pl");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-log']"));

        passwordField.sendKeys("Test@mgr1shr23!");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Zaloguj się')]"));
        submitButton.click();
        WebElement incorrectLoginBanner = driver.findElement(By.xpath("//div[@class='mn-item mn-type-danger mn-item-push']"));

        //nie wiem którą asercję, pierwsza pobiera tekst i porównuje z docelowym druga sprawdza czy locator się wyświetla

//        assertEquals(incorrectLoginBanner.getText(),"Dane logowania nie są poprawne. Zalogowanie nie powiodło się.");
        assertTrue(incorrectLoginBanner.isDisplayed());

    }

    @Test(priority = 5)
    public void searchEngineTests() {
        WebElement searchEngineField = driver.findElement(By.xpath("//div[@class='h-quick-search js--fake-search-bar']//input[@placeholder='Szukaj w ofercie 2 milionów produktów']"));
        //czy może być enter czy ma kliknąć w "lupke"?
        searchEngineField.sendKeys("Laptop", Keys.ENTER);

        List<WebElement> searchResult = driver.findElements(By.xpath("(//div[@class='cat-product card'])"));

        for (WebElement result : searchResult) {
            String resultText = result.getText();
            assertTrue(resultText.contains("Laptop"));
        }

    }

    @Test(priority = 6)
    public void choosingLaptopCategoryTest() {
        WebElement laptopButtonFromMenu = driver.findElement(By.xpath("//span[normalize-space()='Laptopy']"));
        laptopButtonFromMenu.click();

        WebElement laptopTabletButton = driver.findElement(By.xpath("//span[normalize-space()='Laptopy i tablety']"));
        laptopTabletButton.click();

        WebElement laptopButton = driver.findElement(By.xpath("(//span[contains(text(),'Laptopy')])[4]"));
        laptopButton.click();

        List<WebElement> laptopListResult = driver.findElements(By.xpath("(//div[@class='cat-product card'])"));

        for (WebElement result : laptopListResult) {
            String resultText = result.getText();
            assertTrue(resultText.contains("Laptop"));
        }

    }


    @Test(priority = 7)
    public void adProductToWishListTest() {

        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Zaloguj się')]"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys(loginEmail);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-log']"));

        passwordField.sendKeys(correctPassword);

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Zaloguj się')]"));
        submitButton.click();

        WebElement welcomeSign = driver.findElement(By.xpath("//span[normalize-space()='Witaj']"));
        assertEquals(welcomeSign.getText(), "Witaj");

        WebElement laptopButtonFromMenu = driver.findElement(By.xpath("//span[normalize-space()='Laptopy']"));
        laptopButtonFromMenu.click();

        WebElement laptopTabletButton = driver.findElement(By.xpath("//span[normalize-space()='Laptopy i tablety']"));
        laptopTabletButton.click();

        WebElement laptopButton = driver.findElement(By.xpath("(//span[contains(text(),'Laptopy')])[4]"));
        laptopButton.click();

        WebElement addToWishListIcon = driver.findElement(By.xpath("(//i[@class='icon-like'])[3]"));
        addToWishListIcon.click();

        WebElement heartIconToWishList = driver.findElement(By.xpath("(//div[@class='shopping-lists-item '])[1]"));
        heartIconToWishList.click();

        WebElement wishListButton = driver.findElement(By.xpath("(//a[@class='h-control-btn'])[1]"));
        wishListButton.click();

        WebElement productAmountList = driver.findElement(By.xpath("//div[@class='table-row shopping-list-item mUser-table-item mUser-row-date']//div[2]"));
        assertTrue(productAmountList.getText().contains("1"));
    }


    @Test(priority = 8)
    public void addToCartWithoutLoginTest() {

        WebElement laptopButtonFromMenu = driver.findElement(By.xpath("//span[normalize-space()='Laptopy']"));
        laptopButtonFromMenu.click();

        WebElement laptopTabletButton = driver.findElement(By.xpath("//span[normalize-space()='Laptopy i tablety']"));
        laptopTabletButton.click();

        WebElement laptopButton = driver.findElement(By.xpath("(//span[contains(text(),'Laptopy')])[4]"));
        laptopButton.click();

        WebElement addToCartButton = driver.findElement(By.xpath("(//div[@class='cat-product-buttons'])[1]"));
        addToCartButton.click();

        WebElement extendedWarrantyButton = driver.findElement(By.xpath("//button[@class='btn btn-md btn-primary w-100 js_extended-send-button']"));
        extendedWarrantyButton.click();

        WebElement productAddedToCartSign = driver.findElement(By.cssSelector("div[class='product-box card card-mobile'] span"));
        assertTrue(productAddedToCartSign.getText().contains("Produkt dodany do koszyka"));
    }

    @Test(priority = 9)
    public void newsletterSignupTest() {
        WebElement discountCodeButton = driver.findElement(By.xpath("//span[normalize-space()='ODBIERZ KOD RABATOWY']"));
        discountCodeButton.click();

        WebElement emailAddressForNewsletterField = driver.findElement(By.xpath("//input[@class='form-control form-control-material js--newsletter-focus']"));
        emailAddressForNewsletterField.sendKeys("etesttes@wp.pl");

        WebElement consentCheckbox = driver.findElement(By.xpath("(//span[@class='input'])[1]"));
        consentCheckbox.click();

        WebElement singUpButton = driver.findElement(By.xpath("(//input[@value='Zapisz mnie'])[1]"));
        singUpButton.click();

        WebElement newsletterSignupMsg = driver.findElement(By.xpath("//h1[@class='newsletter-header__heading subscribtion-value new-subscriber text-center']"));
        assertTrue(newsletterSignupMsg.getText().contains("Dziękujemy za zapisanie się do newslettera!"));
    }

    @Test(priority = 10)
    public void choosingGuideTest() {
        WebElement guideButton = driver.findElement(By.xpath("//span[@class='h-menu-item-value '][normalize-space()='PORADNIKI']"));
        guideButton.click();

        WebElement tabletForCarGuide = driver.findElement(By.xpath("//a[contains(text(),'Jakie pancerne etui na telefon wybrać? Czym się ki')]"));
        tabletForCarGuide.click();

        WebElement headTabletForCarGuide = driver.findElement(By.xpath("//div[@class='single-news-head']"));
        assertTrue(headTabletForCarGuide.getText().contains("Pancerny case na telefon to najlepszy sposób, by ochronić urządzenie będące nieodłącznym elementem naszego życia."));

    }

    @AfterMethod

    public void afterTest() {
   driver.close();
        driver.quit();
    }
}
