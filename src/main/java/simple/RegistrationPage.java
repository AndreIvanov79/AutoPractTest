package simple;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

public class RegistrationPage {
    @Test
    public void testRegistrationPage() throws InterruptedException {

        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        Thread.sleep(3000);  // Let the user actually see something!

        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();

        Thread.sleep(5000);  // Let the user actually see something!

        WebElement emailField= driver.findElement(By.id("email_create"));
        WebElement createButton= driver.findElement(By.id("SubmitCreate"));
        Thread.sleep(3000);

        emailField.sendKeys("newMyMail@mail.com");
        Thread.sleep(2000);
        createButton.click();
        Thread.sleep(5000);

        WebElement mrCheckBox=driver.findElement(By.id("id_gender1"));
        mrCheckBox.click();

        WebElement firstName=driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Tom");

        WebElement lastName=driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Soyer");

        WebElement password=driver.findElement(By.id("passwd"));
        password.sendKeys("my-123456");

        WebElement address1=driver.findElement(By.id("address1"));
        address1.sendKeys("Lincoln Avenue 34");

        WebElement city=driver.findElement(By.id("city"));
        city.sendKeys("New York");

        WebElement state=driver.findElement(By.id("id_state"));
        state.click();
        WebElement stateList=driver.findElement(By.cssSelector("#id_state > option:nth-child(34)"));
        stateList.click();

        WebElement postCode=driver.findElement(By.id("postcode"));
        postCode.sendKeys("33880");

        WebElement mobilePhone=driver.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("123123");

        WebElement submitButton=driver.findElement(By.id("submitAccount"));
        submitButton.click();

        Thread.sleep(10000);
        driver.quit();

    }
}
