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

import static org.openqa.selenium.By.xpath;

public class UserHomePage extends AbstractPage{

    public UserHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='block_top_menu']//a[@title='Women']")
    private WebElement womenCategory;

    @FindBy(xpath = "//*[@id='center_column']//li[2]//img[@class='replace-2x img-responsive']")
    private WebElement itemImage;

    @FindBy(xpath = "//*[@id='center_column']//li[2]//div[2]/div[2]/a[@title='Add to cart']")
    private WebElement inStockButton;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[@id='header']//a[@class='account']/span")
    private WebElement loggedUserName;

    @FindBy(xpath = "//*[@class='logout']")
    private WebElement logoutButton;

    public WebElement getItemImage(){
        return itemImage;
    }


    public String getUserName() {
        String userName = loggedUserName.getText();
        return userName; }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public void clickWomenCategoryButton(){
        womenCategory.click();
    }

    public void clickItemImage() {
       // WebDriverWait wait=new WebDriverWait(,60);
        //WebElement itemImageClick=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='center_column']//li[2]//img[@class='replace-2x img-responsive']")));
        itemImage.click();

    }

    public void clickInStockButton(){
        WebElement inStockButtonClick=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='center_column']//li[2]//div[2]/div[2]/a[@title='Add to cart']")));
        inStockButtonClick.click();
    }

    public void clickCheckOutButton(){
        WebElement  chekoutButtonClick= wait.until(ExpectedConditions.elementToBeClickable(xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")));
        chekoutButtonClick.click();
    }

}
