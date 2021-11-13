package pageobject;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage extends AbstractPage{

    public OrderConfirmationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']/h1")
    private WebElement orderConfTitle;

    @FindBy(xpath = "//a[@title='Back to orders']")
    private WebElement backButton;

    public WebElement getBackButton(){
        return backButton;
    }

    public String getOrderConfTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_2_7_0_581654']//p[@class='product-name']/a")));
        String orderConfTitleText = orderConfTitle.getText();
        return orderConfTitleText;
    }

}
