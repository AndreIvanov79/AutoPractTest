package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilites.DataGenerator;

public class LogInPage extends AbstractPage{

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']/h1")
    private WebElement signInTitle;

    @FindBy(className = "login")
    private WebElement loginButton;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(id = "email_create")
    private WebElement emailForCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement createButton;

    public WebElement getLoginButton(){
        return loginButton;
    }

    public WebElement getSignInButton(){
        return signInButton;
    }

    public WebElement getCreateButton(){
        return createButton;
    }

    public void fillEmailForCreate(){
        emailForCreate.sendKeys(DataGenerator.generateRandomEmail(8));
    }

    public void clickCreateButton(){
        createButton.click();
    }

    public void clickSignInOnMainPage(){
        loginButton.click();
    }

    public void inputEmailO(){
        email.sendKeys("MyMail@mail.com");
    }

    public void inputPassword(){
        password.sendKeys("john111smith");
    }

    public void clickSignInButton(){
       signInButton.click();
    }

    public String getSignInTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_2_7_0_581654']//p[@class='product-name']/a")));
        String signInTitleText = signInTitle.getText();
        return signInTitleText;
    }

}
