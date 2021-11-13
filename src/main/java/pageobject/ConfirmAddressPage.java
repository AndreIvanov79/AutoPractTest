package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmAddressPage extends AbstractPage{

    public ConfirmAddressPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']/h1")
    private WebElement addressTitle;

    @FindBy(xpath = "//*[@name='processAddress']")
            private WebElement checkoutButton;

    public void clickProceedCheckoutButton() {
        WebElement proceedChekoutButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='processAddress']")));
        proceedChekoutButton3.click();
    }

    public String getAddressTitle() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='center_column']/h1")));
        String addressTitleText = addressTitle.getText();
        return addressTitleText; }
}
