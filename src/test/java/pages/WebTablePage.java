package pages;

import modelObject.WebTableModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']")
    private List<WebElement> tableContentList;
    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement editSubmitElement;
    @FindBy(xpath = "//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']")
    private List<WebElement> newTableContentList;
    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "firstName")
    private WebElement editFirstNameElement;
    @FindBy(id = "lastName")
    private WebElement editLastNameElement;
    @FindBy(id = "userEmail")
    private WebElement editEmailElement;
    @FindBy(id = "salary")
    private WebElement editSalaryElement;
    @FindBy(id = "department")
    private WebElement editDepartmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;

    public void createProcess(WebTableModel testData, int tableSize) {

        Assert.assertEquals(tableContentList.size(), tableSize, "Default size for table is not " + tableSize);
        loggerUtility.infoLog("The user validates the size of table content to be " + tableSize);
        elementMethods.clickElement(addElement);
        loggerUtility.infoLog("The user clicks on Add Element button");
        elementMethods.fillElement(firstNameElement, testData.getFirstNameValue());
        loggerUtility.infoLog("The user fills First Name field with " + testData.getFirstNameValue() + " value");
        elementMethods.fillElement(lastNameElement, testData.getLastNameValue());
        loggerUtility.infoLog("The user fills Last Name field with " + testData.getLastNameValue() + " value ");
        elementMethods.fillElement(emailElement, testData.getEmailValue());
        loggerUtility.infoLog("The user fills Email field with " + testData.getEmailValue() + " value ");
        elementMethods.fillElement(ageElement, testData.getAgeValue());
        loggerUtility.infoLog("The user fills Age field with " + testData.getAgeValue() + " value ");
        elementMethods.fillElement(salaryElement, testData.getSalaryValue());
        loggerUtility.infoLog("The user fills Salary field with " + testData.getSalaryValue() + " value ");
        elementMethods.fillElement(departmentElement, testData.getDepartmentValue());
        loggerUtility.infoLog("The user fills Department field with " + testData.getDepartmentValue() + " value ");
        elementMethods.clickElement(submitElement);
        loggerUtility.infoLog("The user clicks on Submit button");
        Assert.assertEquals(newTableContentList.size(), tableSize + 1, "Default size for table is not " + tableSize + 1);
        loggerUtility.infoLog("The user validates the size of table content to be " +tableSize + 1);

        //validam datele
        String rowContent = newTableContentList.get(tableSize).getText();
        Assert.assertTrue(rowContent.contains(testData.getFirstNameValue()), "The last row doesn't contain first name value.");
        loggerUtility.infoLog("The user validates the presence of " + testData.getFirstNameValue() + " value of the table content");
        Assert.assertTrue(rowContent.contains(testData.getLastNameValue()), "The last row doesn't contain last name value.");
        loggerUtility.infoLog("The user validates the presence of " + testData.getLastNameValue() + " value of the table content");
        Assert.assertTrue(rowContent.contains(testData.getEmailValue()), "The last row doesn't contain email value.");
        loggerUtility.infoLog("The user validates the presence of " + testData.getEmailValue() + " value of the table content");
        Assert.assertTrue(rowContent.contains(testData.getSalaryValue()), "The last row doesn't contain salary value.");
        loggerUtility.infoLog("The user validates the presence of " + testData.getSalaryValue() + " value of the table content");
        Assert.assertTrue(rowContent.contains(testData.getDepartmentValue()), "The last row doesn't contain department value.");
        loggerUtility.infoLog("The user validates the presence of " + testData.getDepartmentValue() + " value of the table content");
    }

    public void editProcess(WebTableModel testData, int tableSize){

        elementMethods.clickJSElement(editElement);
        loggerUtility.infoLog("The user clicks on Edit button  ");
        elementMethods.clearEditElement(editFirstNameElement, testData.getEditFirstNameValue());
        loggerUtility.infoLog("The user clears and fills the First Name field with " + testData.getEditFirstNameValue() + " value");
        elementMethods.clearEditElement(editLastNameElement, testData.getEditLastNameValue());
        loggerUtility.infoLog("The user clears and fills the Last Name field with " + testData.getEditLastNameValue() + " value");
        elementMethods.clearEditElement(editEmailElement, testData.getEditEmailValue());
        loggerUtility.infoLog("The user clears and fills the user Email field with " + testData.getEditEmailValue() + " value");
        elementMethods.clearEditElement(editSalaryElement, testData.getEditSalaryValue());
        loggerUtility.infoLog("The user clears and fills the Salary field with " + testData.getEditSalaryValue() + " value");
        elementMethods.clearEditElement(editDepartmentElement, testData.getEditDepartmentValue());
        loggerUtility.infoLog("The user clears and fills the Department field with " + testData.getEditDepartmentValue() + " value");
        elementMethods.clickElement(editSubmitElement);
        loggerUtility.infoLog("The user clicks on Submit button ");

        String rowContent = newTableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(testData.getEditFirstNameValue()), "The last row doesn't contain first name value.");
        loggerUtility.infoLog("The user validates the presence of " + testData.getEditFirstNameValue() + " value of the table content");
        Assert.assertTrue(rowContent.contains(testData.getEditLastNameValue()), "The last row doesn't contain last name value.");
        loggerUtility.infoLog("The user validates the presence of " + testData.getEditLastNameValue() + " value of the table content");
        Assert.assertTrue(rowContent.contains(testData.getEditEmailValue()), "The last row doesn't contain email value.");
        loggerUtility.infoLog("The user validates the presence of " + testData.getEditEmailValue() + " value of the table content");
        Assert.assertTrue(rowContent.contains(testData.getEditSalaryValue()), "The last row doesn't contain salary value.");
        loggerUtility.infoLog("The user validates the presence of " + testData.getEditSalaryValue() + " value of the table content");
        Assert.assertTrue(rowContent.contains(testData.getEditDepartmentValue()), "The last row doesn't contain department value.");
        loggerUtility.infoLog("The user validates the presence of " + testData.getEditDepartmentValue() + " value of the table content");
    }

    public void deleteProcess(int tableSize){

        elementMethods.clickJSElement(deleteElement);
        loggerUtility.infoLog("The user clicks on Delete element");
        Assert.assertEquals(newTableContentList.size(), tableSize, "Default size for table is not " + tableSize);
        loggerUtility.infoLog("The user validates the size of table content to be " +tableSize);

    }
}
