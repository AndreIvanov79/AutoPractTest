import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    public static LogInPage loginPage;
    public static UserHomePage userHomePage;
    public static RegistrationPage registrationPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", PropReader.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LogInPage(driver);
        userHomePage = new UserHomePage(driver);
        registrationPage = new RegistrationPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PropReader.getProperty("loginpage"));}

        @Test
        public void registrationTest() {

            loginPage.clickSignInOnMainPage();
            loginPage.fillEmailForCreate();
            loginPage.clickCreateButton();
            registrationPage.fillMandatoryFields();
            registrationPage.clickSubmitButton();


            String user = userHomePage.getUserName();
            Assert.assertEquals(registrationPage.getCurrentUserName(), user);
        }

        @AfterClass
        public static void tearDown () {
            userHomePage.clickLogoutButton();
            driver.quit();
        }
}
