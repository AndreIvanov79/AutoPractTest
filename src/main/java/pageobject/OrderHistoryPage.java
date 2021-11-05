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

public class OrderHistoryPage extends AbstractPage{

    public OrderHistoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id='center_column']/h1")
    private WebElement orderHistoryTitle;

    public String getOrderHistoryTitle() {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_2_7_0_581654']//p[@class='product-name']/a")));
        String orderHistoryTitleText = orderHistoryTitle.getText();
        return orderHistoryTitleText;
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }
}
