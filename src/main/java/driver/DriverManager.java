package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilites.PropReader;



public class DriverManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", PropReader.getProperty("chromedriver"));
        if (driver == null)
            driver = new ChromeDriver();
        return driver;
    }
}
