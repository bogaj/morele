package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestBase {
    public WebDriver driver;

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
    @AfterMethod

    public void afterTest() {
        driver.close();
        driver.quit();
    }
}