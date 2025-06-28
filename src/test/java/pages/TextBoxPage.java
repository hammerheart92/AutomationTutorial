package pages;

import io.qameta.allure.Step;
import loggerUtility.LoggerUtility;
import modelObject.TextBoxModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage{

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    private WebElement fullNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressElement;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressElement;

    @Step("Fill in the text box form with test data")
    public void fillTextBoxFieldsWithProvidedData(TextBoxModel testData){
        elementMethods.fillElement(fullNameElement, testData.getFullNameValue());
        LoggerUtility.infoLog("the user fills the Full Name field with " + testData.getFullNameValue() + " value");
        elementMethods.fillElement(emailElement, testData.getEmailValue());
        LoggerUtility.infoLog("the user fills the Email field with " + testData.getEmailValue() + "value");
        elementMethods.fillElement(currentAddressElement, testData.getCurrentAddressValue());
        LoggerUtility.infoLog("the user fills the Current Address field with " + testData.getCurrentAddressValue());
        elementMethods.fillElement(permanentAddressElement, testData.getPermanentAddressValue());
        LoggerUtility.infoLog("the user fills the Permanent Address field with " + testData.getPermanentAddressValue());
    }
}
