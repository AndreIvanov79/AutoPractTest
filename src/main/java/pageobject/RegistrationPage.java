package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.DataGenerator;
import util.PropReader;

import java.util.List;
import java.util.Map;

public class RegistrationPage extends AbstractPage{

    public RegistrationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "uniform-id_gender1")
    private WebElement maleCheckBox;

    @FindBy(id = "uniform-id_gender2")
    private WebElement femaleCheckBox;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private List<WebElement> days;

    @FindBy(id = "months")
    private List<WebElement> months;

    @FindBy(id = "years")
    private List<WebElement> years;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private List<WebElement> state;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "phone_mobile")
    private WebElement phone;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    String newFirstName=DataGenerator.generateRandomString(6);
    String newLastName=DataGenerator.generateRandomString(6);
    String currentUserName=newFirstName+" "+newLastName;

    public void fillMandatoryFields(){
        maleCheckBox.click();
        firstName.sendKeys(newFirstName);
        lastName.sendKeys(newLastName);
        password.sendKeys("pass2222");
        address.sendKeys("Lincoln Avenue 11");
        city.sendKeys("New York");
        selectState("New York");
        postcode.sendKeys("11112");
        phone.sendKeys("1212121");
        selectDay("12");
        selectMonth("12");
        selectYear("2002");
    }

    public String getCurrentUserName(){
        return currentUserName;
    }

    public void selectDay(String day) {
        for (WebElement count : days) {
            new Select(count).selectByValue(day);
        }
    }

    public void selectMonth(String month) {
        for (WebElement count : months) {
            new Select(count).selectByValue(month);
        }
    }

    public void selectYear(String year) {
        for (WebElement count : years) {
            new Select(count).selectByValue(year);
        }
    }

    public void selectState(String st) {
        for (WebElement count : state) {
            new Select(count).selectByVisibleText(st);
        }
    }

    public void clickSubmitButton(){
        submitButton.click();
    }
}
