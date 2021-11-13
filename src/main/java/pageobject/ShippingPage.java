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

public class ShippingPage extends AbstractPage{

    public ShippingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "cgv")
    private WebElement agreeCheckBox;

    @FindBy(xpath = "//*[@id='carrier_area']/h1")
    private WebElement shippingTitle;

    @FindBy(xpath = "//*[@name='processCarrier']")
            private WebElement checkoutButton;

    public void clickProceedCheckoutButton() {
        WebElement proceedChekoutButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='processCarrier']")));
        proceedChekoutButton4.click();
    }

    public String getShippingTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='carrier_area']/h1")));
        String shippingTitleText = shippingTitle.getText();
        return shippingTitleText; }

    public void clickCheckBox(){
        agreeCheckBox.click();
    }
}
