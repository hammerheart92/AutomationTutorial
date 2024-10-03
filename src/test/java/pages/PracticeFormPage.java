package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    public WebElement fistNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(id = "userEmail")
    public WebElement emailElement;
    @FindBy(xpath = "//div[@class = '//input[@name='gender']/../label")
    public List<WebElement> genderOptionsList;
    @FindBy(id = "userNumber")
    public WebElement mobileNumberElement;
    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthElement;
    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthElement;
    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearElement;
    @FindBy(xpath = "//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]")
    public List<WebElement> daysList;
    @FindBy(id = "subjectsInput")
    public WebElement subjectsElement;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    public WebElement hobbiesOptionsList;
    @FindBy(id = "uploadPicture")
    public WebElement pictureElement;
    @FindBy(id = "currentAddress")
    public WebElement currentAdressElement;
    @FindBy(xpath = "//div[text()='Select State']")
    public WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    public WebElement stateInputElement;
    @FindBy(id = "react-select-4-input")
    public WebElement cityInputElement;
    @FindBy(id = "submit")
    public WebElement submitElement;
    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement thankYouElement;

}
