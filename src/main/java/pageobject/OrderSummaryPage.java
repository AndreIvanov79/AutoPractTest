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

public class OrderSummaryPage extends AbstractPage{

    public OrderSummaryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='center_column']/h1")
    private WebElement summaryTitle;

    @FindBy(xpath = "//*[@id='cart_navigation']/button[@type='submit']")
    private WebElement confirmButton;

    public void clickConfirmButton(){
        confirmButton.click();
    }

    public String getSummaryTitle() {
        wait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_2_7_0_581654']//p[@class='product-name']/a")));
        String summaryTitleText = summaryTitle.getText();
        return summaryTitleText;
    }

}
