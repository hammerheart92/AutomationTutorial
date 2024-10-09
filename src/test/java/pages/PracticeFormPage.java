package pages;

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

    public void fillEntireForm(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String mobileNumberValue,
                               String monthValue, String yearValue, String dayValue, List<String> subjectValues, List<String> hobbiesValues,
                               String pathFile, String currentAddressValue, String stateInputValue, String cityInputValue) {
        elementMethods.fillElement(fistNameElement, firstNameValue);
        loggerUtility.infoLog("The user fills the First Name field with " + firstNameValue + " value");
        elementMethods.fillElement(lastNameElement, lastNameValue);
        loggerUtility.infoLog("The user fills the Last Name field with " + lastNameValue + " value");
        elementMethods.fillElement(emailElement, emailValue);
        loggerUtility.infoLog("The user fills the Email field with " + emailValue + " value");
        switch (genderValue) {
            case "Male":
                elementMethods.clickJSElement(genderOptionsList.get(0));
                loggerUtility.infoLog("The user selects Gender option " + genderValue);
                break;
            case "Female":
                elementMethods.clickJSElement(genderOptionsList.get(1));
                loggerUtility.infoLog("The user selects Gender option " + genderValue);
                break;
            case "Other":
                elementMethods.clickJSElement(genderOptionsList.get(2));
                loggerUtility.infoLog("The user selects Gender option " + genderValue);
                break;
        }
        elementMethods.fillElement(mobileNumberElement, mobileNumberValue);
        loggerUtility.infoLog("The user fills the Mobile number field with " + mobileNumberValue + " value");
        elementMethods.clickElement(dateOfBirthElement);
        loggerUtility.infoLog("The user clicks on Date of Birth option");
        elementMethods.selectDropdownElement(monthElement, monthValue);
        loggerUtility.infoLog("The user selects month option: " + monthValue);
        elementMethods.selectDropdownElement(yearElement, yearValue);
        loggerUtility.infoLog("The user selects year option: " + yearValue);

        for (int index = 0; index < daysList.size(); index++) {
            if (daysList.get(index).getText().equals(dayValue)) {
                elementMethods.clickJSElement(daysList.get(index));
                loggerUtility.infoLog("The user selects day option: " + dayValue);
                break;
            }
        }
        for (int index = 0; index < subjectValues.size(); index++) {
            elementMethods.fillPressElement(subjectsElement, subjectValues.get(index), Keys.ENTER);
            loggerUtility.infoLog("The user types and selects Subjects option : " + subjectValues.size());

        }
        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbiesValues.contains(currentText)) {
                elementMethods.clickJSElement(hobbiesOptionsList.get(index));
                loggerUtility.infoLog("The user selects Hobbies " + hobbiesValues);
            }
        }

        File file = new File(pathFile);
        elementMethods.fillElement(pictureElement, file.getAbsolutePath());
        loggerUtility.infoLog("The user uploads a Picture" + pathFile);
        elementMethods.fillElement(currentAddressElement, currentAddressValue);
        loggerUtility.infoLog("The user fills the Current Address field with: " + currentAddressValue + " value");
        elementMethods.clickJSElement(stateElement);
        loggerUtility.infoLog("The user clicks on Select State option");
        elementMethods.fillPressElement(stateInputElement, stateInputValue, Keys.ENTER);
        loggerUtility.infoLog("The user selects State option with: " + stateInputValue + " value");
        elementMethods.fillPressElement(cityInputElement, cityInputValue, Keys.ENTER);
        loggerUtility.infoLog("The user selects City option with: " + cityInputValue + " value");
        elementMethods.clickJSElement(submitElement);
        loggerUtility.infoLog("The user clicks on Submit button");
    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String mobileNumberValue,
                                   String dayValue, String monthValue, String yearValue, List<String> subjectValues, List<String> hobbiesValues,
                                   String pathFile, String currentAddressValue, String stateInputValue, String cityInputValue) {

        elementMethods.waitVisibleElement(thankYouElement);
        loggerUtility.infoLog("The user waits a little");

        Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");
        loggerUtility.infoLog("The user validates the presence of Thanks for submitting the form value of the Label List");
        Assert.assertEquals(labelList.get(0).getText(), "Student Name");
        loggerUtility.infoLog("The user validates the presence of " + firstNameValue + " " + lastNameValue + " value of the Label List");
        Assert.assertEquals(labelList.get(1).getText(), "Student Email");
        loggerUtility.infoLog("The user validates the presence of " + emailValue + " value of the Label List");
        Assert.assertEquals(labelList.get(2).getText(), "Gender");
        loggerUtility.infoLog("The user validates the presence of " + genderValue + " value of the Label List");
        Assert.assertEquals(labelList.get(3).getText(), "Mobile");
        loggerUtility.infoLog("The user validates the presence of " + mobileNumberValue + " value of the Label List");
        Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
        loggerUtility.infoLog("The user validates the presence of " + dayValue + " " + monthValue + " " + yearValue + " value of the Label List");
        String subjectsString = String.join(", ", subjectValues);
        Assert.assertEquals(labelList.get(5).getText(), "Subjects");
        loggerUtility.infoLog("The user validates the presence of " + subjectValues + " value of the Label List");
        String hobbiesString = String.join(", ", hobbiesValues);
        Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
        loggerUtility.infoLog("The user validates the presence of " + hobbiesValues + " value of the Label List");
        Assert.assertEquals(labelList.get(7).getText(), "Picture");
        loggerUtility.infoLog("The user validates the presence of " + pathFile + " value of the Label List");
        Assert.assertEquals(labelList.get(8).getText(), "Address");
        loggerUtility.infoLog("The user validates the presence of " + currentAddressValue + " value of the Label List");
        Assert.assertEquals(labelList.get(9).getText(), "State and City");
        loggerUtility.infoLog("The user validates the presence of " + stateInputValue + " " + cityInputValue + " value of the Label List");

        Assert.assertEquals(valuesList.get(0).getText(), firstNameValue + " " + lastNameValue);
        loggerUtility.infoLog("The user validates the presence of " + firstNameValue + " " + lastNameValue + " value of the values List");
        Assert.assertEquals(valuesList.get(1).getText(), emailValue);
        loggerUtility.infoLog("The user validates the presence of " + emailValue + " value of the values List");
        Assert.assertEquals(valuesList.get(2).getText(), genderValue);
        loggerUtility.infoLog("The user validates the presence of " + genderValue + " value of the values List");
        Assert.assertEquals(valuesList.get(3).getText(), mobileNumberValue);
        loggerUtility.infoLog("The user validates the presence of " + mobileNumberValue + " value of the values List");
        Assert.assertEquals(valuesList.get(4).getText(), dayValue + " " + monthValue + "," + yearValue);
        loggerUtility.infoLog("The user validates the presence of " + dayValue + " " + monthValue + " " + yearValue + " value of the values List");
        Assert.assertEquals(valuesList.get(5).getText(), subjectsString);
        loggerUtility.infoLog("The user validates the presence of " + subjectValues + " value of the values List");
        Assert.assertEquals(valuesList.get(6).getText(), hobbiesString);
        loggerUtility.infoLog("The user validates the presence of " + hobbiesValues + " value of the values List");
        File file = new File(pathFile);
        Assert.assertEquals(valuesList.get(7).getText(), file.getName());
        loggerUtility.infoLog("The user validates the presence of " + pathFile + " value of the values List");
        Assert.assertEquals(valuesList.get(8).getText(), currentAddressValue);
        loggerUtility.infoLog("The user validates the presence of " + currentAddressValue + " value of the values List");
        Assert.assertEquals(valuesList.get(9).getText(), stateInputValue + " " + cityInputValue);
        loggerUtility.infoLog("The user validates the presence of " + stateInputValue + " " + cityInputValue + " value of the values List");
    }

}
