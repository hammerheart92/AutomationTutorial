package pages;

import loggerUtility.LoggerUtility;
import modelObject.PracticeFormModel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement fistNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(xpath = "//input[@name='gender']/following-sibling::label")
    private List<WebElement> genderOptionsList;
    @FindBy(id = "userNumber")
    private WebElement mobileNumberElement;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;
    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthElement;
    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearElement;
    @FindBy(xpath = "//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]")
    private List<WebElement> daysList;
    @FindBy(id = "subjectsInput")
    private WebElement subjectsElement;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    private List<WebElement> hobbiesOptionsList;
    @FindBy(id = "uploadPicture")
    private WebElement pictureElement;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressElement;
    @FindBy(xpath = "//div[text()='Select State']")
    private WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;
    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement thankYouElement;
    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']//td[1]")
    private List<WebElement> labelList;
    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']//td[2]")
    private List<WebElement> valuesList;

    public void fillEntireForm(PracticeFormModel testData) {
        elementMethods.fillElement(fistNameElement, testData.getFirstNameValue());
        LoggerUtility.infoLog("The user fills the First Name field with " + testData.getFirstNameValue() + " value");
        elementMethods.fillElement(lastNameElement, testData.getLastNameValue());
        LoggerUtility.infoLog("The user fills the Last Name field with " + testData.getLastNameValue() + " value");
        elementMethods.fillElement(emailElement, testData.getEmailValue());
        LoggerUtility.infoLog("The user fills the Email field with " + testData.getEmailValue() + " value");
        switch (testData.getGenderValue()) {
            case "Male":
                elementMethods.clickJSElement(genderOptionsList.get(0));
                LoggerUtility.infoLog("The user selects Gender option " + testData.getGenderValue());
                break;
            case "Female":
                elementMethods.clickJSElement(genderOptionsList.get(1));
                LoggerUtility.infoLog("The user selects Gender option " + testData.getGenderValue());
                break;
            case "Other":
                elementMethods.clickJSElement(genderOptionsList.get(2));
                LoggerUtility.infoLog("The user selects Gender option " + testData.getGenderValue());
                break;
        }
        elementMethods.fillElement(mobileNumberElement, testData.getMobileNumberValue());
        LoggerUtility.infoLog("The user fills the Mobile number field with " + testData.getMobileNumberValue() + " value");
        elementMethods.clickElement(dateOfBirthElement);
        LoggerUtility.infoLog("The user clicks on Date of Birth option");
        elementMethods.selectDropdownElement(monthElement, testData.getMonthValue());
        LoggerUtility.infoLog("The user selects month option: " + testData.getMonthValue());
        elementMethods.selectDropdownElement(yearElement, testData.getYearValue());
        LoggerUtility.infoLog("The user selects year option: " + testData.getYearValue());

        for (int index = 0; index < daysList.size(); index++) {
            if (daysList.get(index).getText().equals(testData.getDayValue())) {
                elementMethods.clickJSElement(daysList.get(index));
                LoggerUtility.infoLog("The user selects day option: " + testData.getDayValue());
                break;
            }
        }
        for (int index = 0; index < testData.getSubjectValues().size(); index++) {
            elementMethods.fillPressElement(subjectsElement, testData.getSubjectValues().get(index), Keys.ENTER);
            LoggerUtility.infoLog("The user types and selects Subjects option : " + testData.getSubjectValues().size());

        }
        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (testData.getHobbiesValues().contains(currentText)) {
                elementMethods.clickJSElement(hobbiesOptionsList.get(index));
                LoggerUtility.infoLog("The user selects Hobbies " + testData.getHobbiesValues());
            }
        }

        File file = new File(testData.getPathFile());
        elementMethods.fillElement(pictureElement, file.getAbsolutePath());
        LoggerUtility.infoLog("The user uploads a Picture" + testData.getPathFile());
        elementMethods.fillElement(currentAddressElement, testData.getCurrentAddressValue());
        LoggerUtility.infoLog("The user fills the Current Address field with: " + testData.getCurrentAddressValue() + " value");
        elementMethods.clickJSElement(stateElement);
        LoggerUtility.infoLog("The user clicks on Select State option");
        elementMethods.fillPressElement(stateInputElement, testData.getStateInputValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user selects State option with: " + testData.getStateInputValue() + " value");
        elementMethods.fillPressElement(cityInputElement, testData.getCityInputValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user selects City option with: " + testData.getCityInputValue() + " value");
        elementMethods.clickJSElement(submitElement);
        LoggerUtility.infoLog("The user clicks on Submit button");
    }

    public void validateFormValues(PracticeFormModel testData) {

        elementMethods.waitVisibleElement(thankYouElement);
        LoggerUtility.infoLog("The user waits a little");

        Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");
        LoggerUtility.infoLog("The user validates the presence of Thanks for submitting the form value of the Label List");
        Assert.assertEquals(labelList.get(0).getText(), "Student Name");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getFirstNameValue() + " " + testData.getLastNameValue() + " value of the Label List");
        Assert.assertEquals(labelList.get(1).getText(), "Student Email");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getEmailValue() + " value of the Label List");
        Assert.assertEquals(labelList.get(2).getText(), "Gender");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getGenderValue() + " value of the Label List");
        Assert.assertEquals(labelList.get(3).getText(), "Mobile");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getMobileNumberValue() + " value of the Label List");
        Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getDayValue() + " " + testData.getMonthValue() + " " + testData.getYearValue() + " value of the Label List");
        String subjectsString = String.join(", ", testData.getSubjectValues());
        Assert.assertEquals(labelList.get(5).getText(), "Subjects");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getSubjectValues() + " value of the Label List");
        String hobbiesString = String.join(", ", testData.getHobbiesValues());
        Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getHobbiesValues() + " value of the Label List");
        Assert.assertEquals(labelList.get(7).getText(), "Picture");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getPathFile() + " value of the Label List");
        Assert.assertEquals(labelList.get(8).getText(), "Address");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getCurrentAddressValue() + " value of the Label List");
        Assert.assertEquals(labelList.get(9).getText(), "State and City");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getStateInputValue() + " " + testData.getCityInputValue() + " value of the Label List");

        Assert.assertEquals(valuesList.get(0).getText(), testData.getFirstNameValue() + " " + testData.getLastNameValue());
        LoggerUtility.infoLog("The user validates the presence of " + testData.getFirstNameValue() + " " + testData.getLastNameValue() + " value of the values List");
        Assert.assertEquals(valuesList.get(1).getText(), testData.getEmailValue());
        LoggerUtility.infoLog("The user validates the presence of " + testData.getEmailValue() + " value of the values List");
        Assert.assertEquals(valuesList.get(2).getText(), testData.getGenderValue());
        LoggerUtility.infoLog("The user validates the presence of " + testData.getGenderValue() + " value of the values List");
        Assert.assertEquals(valuesList.get(3).getText(), testData.getMobileNumberValue());
        LoggerUtility.infoLog("The user validates the presence of " + testData.getMobileNumberValue() + " value of the values List");
        Assert.assertEquals(valuesList.get(4).getText(), testData.getDayValue() + " " + testData.getMonthValue() + "," + testData.getYearValue());
        LoggerUtility.infoLog("The user validates the presence of " + testData.getDayValue() + " " + testData.getMonthValue() + " " + testData.getYearValue() + " value of the values List");
        Assert.assertEquals(valuesList.get(5).getText(), subjectsString);
        LoggerUtility.infoLog("The user validates the presence of " + testData.getSubjectValues() + " value of the values List");
        Assert.assertEquals(valuesList.get(6).getText(), hobbiesString);
        LoggerUtility.infoLog("The user validates the presence of " + testData.getHobbiesValues() + " value of the values List");
        File file = new File(testData.getPathFile());
        Assert.assertEquals(valuesList.get(7).getText(), file.getName());
        LoggerUtility.infoLog("The user validates the presence of " + testData.getPathFile() + " value of the values List");
        Assert.assertEquals(valuesList.get(8).getText(), testData.getCurrentAddressValue());
        LoggerUtility.infoLog("The user validates the presence of " + testData.getCurrentAddressValue() + " value of the values List");
        Assert.assertEquals(valuesList.get(9).getText(), testData.getStateInputValue() + " " + testData.getCityInputValue());
        LoggerUtility.infoLog("The user validates the presence of " + testData.getStateInputValue() + " " + testData.getCityInputValue() + " value of the values List");
    }

}
