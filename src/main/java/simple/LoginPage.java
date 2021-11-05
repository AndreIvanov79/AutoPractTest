package simple;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    @Test
    public void testLoginPage() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");

        WebElement loginButton = driver.findElement(By.className("login"));
        loginButton.click();

        WebElement emailField= driver.findElement(By.id("email"));
        emailField.sendKeys("newMyMail@mail.com");

        WebElement password=driver.findElement(By.id("passwd"));
        password.sendKeys("my-123456");

        WebElement signInButton= driver.findElement(By.id("SubmitLogin"));
        signInButton.click();

        driver.quit();

    }
}
