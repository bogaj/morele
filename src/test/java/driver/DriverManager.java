package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

       // if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
         //              driver = new ChromeDriver();
    //    }

        return driver;
    }
    public static void initialize(WebDriver driver) {
        DriverManager.driver = driver;
    }
    public static void disposeDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}