import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pageobject.*;
import utilites.PropReader;

import java.util.concurrent.TimeUnit;

public class PurchaseItemTest {
    public static LogInPage loginPage;
    public static UserHomePage userHomePage;
    public static ConfirmAddressPage confirmAddressPage;
    public static OrderHistoryPage orderHistoryPage;
    public static OrderConfirmationPage orderConfirmationPage;
    public static OrderSummaryPage orderSummaryPage;
    public static PayMethodPage payMethodPage;
    public static ShippingPage shippingPage;
    public static ShoppingCartSummaryPage shoppingCartSummaryPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", PropReader.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LogInPage(driver);
        userHomePage=new UserHomePage(driver);
        catalogPage=new CatalogPage(driver);
        confirmAddressPage=new ConfirmAddressPage(driver);
        orderConfirmationPage=new OrderConfirmationPage(driver);
        orderHistoryPage=new OrderHistoryPage(driver);
        orderSummaryPage=new OrderSummaryPage(driver);
        payMethodPage=new PayMethodPage(driver);
        shippingPage=new ShippingPage(driver);
        shoppingCartSummaryPage=new ShoppingCartSummaryPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PropReader.getProperty("loginpage"));}

        Actions actions=new Actions(driver);


    @Test
    public void purchaseItemTest() {
        loginPage.clickIt(loginPage.getLoginButton());
        loginPage.inputEmail();
        loginPage.inputPassword();
        loginPage.clickIt(loginPage.getSignInButton());

        String user = userHomePage.getUserName();
        Assert.assertEquals(PropReader.getProperty("username"), user);

        userHomePage.clickIt(userHomePage.getWomenCategory());

        actions.moveToElement(catalogPage.getBlouseImage()).build().perform();
        catalogPage.clickIt(catalogPage.getAddToCartButton());
        catalogPage.clickIt(catalogPage.getCheckoutButton());

        shoppingCartSummaryPage.clickIt(shoppingCartSummaryPage.getProceedChekoutButton());

        confirmAddressPage.clickIt(confirmAddressPage.getCheckoutButton());

        shippingPage.clickAgreeCheckBox();
        shippingPage.clickIt(shippingPage.getCheckoutButton());

        payMethodPage.clickIt(payMethodPage.getPayMethod());

        orderSummaryPage.clickIt(orderSummaryPage.getConfirmButton());

        orderConfirmationPage.clickIt(orderConfirmationPage.getBackButton());

        String history = orderHistoryPage.getOrderHistoryTitle();

        Assert.assertEquals(PropReader.getProperty("orderhistory"), history);

        orderHistoryPage.clickIt(orderHistoryPage.getBackToAccount());
    }

    @AfterClass
    public static void tearDown() {
        userHomePage.clickIt(userHomePage.getLogoutButton());
        driver.quit(); }

}
