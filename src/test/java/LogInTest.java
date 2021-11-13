import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.LogInPage;
import pageobject.UserHomePage;
import utilites.PropReader;

import java.util.concurrent.TimeUnit;

public class LogInTest {
    public static LogInPage loginPage;
    public static UserHomePage userHomePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", PropReader.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LogInPage(driver);
        userHomePage=new UserHomePage(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(PropReader.getProperty("loginpage"));}
        //driver.get("http://automationpractice.com/index.php");}

    @Test
    public void loginTest() {

        loginPage.clickIt(loginPage.getLoginButton());
        loginPage.inputEmail();
        loginPage.inputPassword();
        loginPage.clickIt(loginPage.getSignInButton());

        String user = userHomePage.getUserName();
        Assert.assertEquals(PropReader.getProperty("username"), user);
    }

    @AfterClass
    public static void tearDown() {
      //  userHomePage.clickLogoutButton();
        driver.quit(); }
}
