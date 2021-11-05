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

public class ShoppingCartSummaryPage extends AbstractPage{

    public ShoppingCartSummaryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='product_2_7_0_581654']//p[@class='product-name']/a")
    private WebElement productName;

    @FindBy(xpath = "//*/p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
            private WebElement proceedChekoutButton;


    public void clickProceedCheckoutButton() {
        WebElement proceedChekoutButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")));
        proceedChekoutButton.click();
    }

    public String getProductName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_2_7_0_581654']//p[@class='product-name']/a")));
        String productNameText = productName.getText();
        return productNameText;
    }
}
