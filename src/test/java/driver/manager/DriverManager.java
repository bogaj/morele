package driver.manager;

import org.openqa.selenium.WebDriver;

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