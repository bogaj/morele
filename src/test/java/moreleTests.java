

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class moreleTests {

    private WebDriver driver;
    // String loginPage = "https://www.morele.net";
    String loginEmail = "anianowak2112@o2.pl";
    String correctPassword = "Test@mgr123!";
    // String cookiesAcceptButtonLocator = "//*[@id=\"cookie_box\"]/div/div/button";


    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.morele.net");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void correctLoginTest() {


        // WebElement cookiesAcceptButton = driver.findElement(By.xpath(cookiesAcceptButtonLocator));
        // cookiesAcceptButton.click();
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

    @Test

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

    @Test
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

        assertEquals(incorrectEmailNotification.getText(),"Podaj poprawny adres e-mail!");
        assertTrue(incorrectEmailNotification.isDisplayed());
    }

    @Test
    public void loginUsingIncorrectDataTest() {



        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Zaloguj się')]"));
        loginButton.click();
        WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
        emailField.sendKeys("2122@wp.pl");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password-log']"));

        passwordField.sendKeys("Test@mgr1s23!");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Zaloguj się')]"));
        submitButton.click();
        WebElement incorrectLoginBanner = driver.findElement(By.xpath("//div[@class='mn-item mn-type-danger mn-item-push']"));

        //nie wiem którą asercję, pierwsza pobiera tekst i porównuje z docelowym druga sprawdza czy locator się wyświetla

        assertEquals(incorrectLoginBanner.getText(),"Dane logowania nie są poprawne. Zalogowanie nie powiodło się.");
       assertTrue(incorrectLoginBanner.isDisplayed());

    }

    @AfterMethod

    public void afterTest() {
          driver.close();
          driver.quit();
    }
}
