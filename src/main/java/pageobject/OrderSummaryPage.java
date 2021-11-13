package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSummaryPage extends AbstractPage{

    public OrderSummaryPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']/h1")
    private WebElement summaryTitle;

    @FindBy(xpath = "//*[@id='cart_navigation']/button[@type='submit']")
    private WebElement confirmButton;

    public WebElement getConfirmButton(){
        return confirmButton;
    }

    public String getSummaryTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_2_7_0_581654']//p[@class='product-name']/a")));
        String summaryTitleText = summaryTitle.getText();
        return summaryTitleText;
    }

}
