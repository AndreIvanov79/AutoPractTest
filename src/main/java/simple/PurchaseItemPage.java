package simple;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseItemPage {
    @Test
    public void testPurchaseItemPage() throws InterruptedException {

        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        Thread.sleep(5000);  // Let the user actually see something!

        WebElement loginButton = driver.findElement(By.className("login"));
        loginButton.click();

        Thread.sleep(5000);  // Let the user actually see something!

        WebElement emailField= driver.findElement(By.id("email"));
        emailField.sendKeys("newMyMail@mail.com");

        WebElement password=driver.findElement(By.id("passwd"));
        password.sendKeys("my-123456");

        WebElement signInButton= driver.findElement(By.id("SubmitLogin"));
        signInButton.click();

        Thread.sleep(5000);

        WebElement womenCategory=driver.findElement(By.xpath("//*[@id='block_top_menu']//a[@title='Women']"));
        womenCategory.click();

        Thread.sleep(3000);

        WebElement blouse=driver.findElement(By.xpath("//*[@data-id-product='2']/span"));
        blouse.click();

        Thread.sleep(10000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement  proceedChekoutButton1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='layer_cart']//div[@class='button-container']/a")));
        proceedChekoutButton1.click();

        Thread.sleep(10000);

       // WebDriverWait wait2 = new WebDriverWait(driver, 10);
        WebElement  proceedChekoutButton2= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")));
        proceedChekoutButton2.click();

        Thread.sleep(5000);

       // WebDriverWait wait3 = new WebDriverWait(driver, 10);
        WebElement  proceedChekoutButton3= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='processAddress']")));
        proceedChekoutButton3.click();

        Thread.sleep(5000);

        WebElement agreeCheckBox=driver.findElement(By.id("cgv"));
        agreeCheckBox.click();

       // WebDriverWait wait4 = new WebDriverWait(driver, 10);
        WebElement  proceedChekoutButton4= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='processCarrier']")));
        proceedChekoutButton4.click();

        Thread.sleep(5000);

        WebElement payMeyhodButton=driver.findElement(By.className("bankwire"));
        payMeyhodButton.click();

        Thread.sleep(5000);

        WebElement confirmOrderButton=driver.findElement(By.xpath("//*[@id='cart_navigation']/button[@type='submit']"));
        confirmOrderButton.click();

        Thread.sleep(5000);

        WebElement backButton=driver.findElement(By.xpath("//*/p[@class='cart_navigation exclusive']/a[@title='Back to orders']"));
        backButton.click();

        Thread.sleep(10000);

        driver.quit();

    }
}
