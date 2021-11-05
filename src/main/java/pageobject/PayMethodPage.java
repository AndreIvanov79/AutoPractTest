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

public class PayMethodPage extends AbstractPage{

    public PayMethodPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='center_column']/h1")
    private WebElement payMethodTitle;

    @FindBy(className = "bankwire")
    private WebElement payMethod;


    public void clickPayMethod(){
        payMethod.click();
    }

    public String getPayMethodTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='center_column']/h1")));
        String payMethodText = payMethod.getText();
        return payMethodText; }
}
