package pages;

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

    public void createProcess(String firstNameValue, String lastNameValue, String emailValue, String ageValue, String salaryValue, String departmentValue, int tableSize) {

        Assert.assertEquals(tableContentList.size(), tableSize, "Default size for table is not " + tableSize);
        loggerUtility.infoLog("The user validates the size of table content to be " + tableSize);
        elementMethods.clickElement(addElement);
        loggerUtility.infoLog("The user clicks on Add Element button");
        elementMethods.fillElement(firstNameElement, firstNameValue);
        loggerUtility.infoLog("The user fills First Name field with " + firstNameValue + " value");
        elementMethods.fillElement(lastNameElement, lastNameValue);
        loggerUtility.infoLog("The user fills Last Name field with " + lastNameValue + " value ");
        elementMethods.fillElement(emailElement, emailValue);
        loggerUtility.infoLog("The user fills Email field with " + emailValue + " value ");
        elementMethods.fillElement(ageElement, ageValue);
        loggerUtility.infoLog("The user fills Age field with " + ageValue + " value ");
        elementMethods.fillElement(salaryElement, salaryValue);
        loggerUtility.infoLog("The user fills Salary field with " + salaryValue + " value ");
        elementMethods.fillElement(departmentElement, departmentValue);
        loggerUtility.infoLog("The user fills Department field with " + departmentValue + " value ");
        elementMethods.clickElement(submitElement);
        loggerUtility.infoLog("The user clicks on Submit button");
        Assert.assertEquals(newTableContentList.size(), tableSize + 1, "Default size for table is not " + tableSize + 1);
        loggerUtility.infoLog("The user validates the size of table content to be " +tableSize + 1);

        //validam datele
        String rowContent = newTableContentList.get(tableSize).getText();
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row doesn't contain first name value.");
        loggerUtility.infoLog("The user validates the presence of " + firstNameValue + " value of the table content");
        Assert.assertTrue(rowContent.contains(lastNameValue), "The last row doesn't contain last name value.");
        loggerUtility.infoLog("The user validates the presence of " + lastNameValue + " value of the table content");
        Assert.assertTrue(rowContent.contains(emailValue), "The last row doesn't contain email value.");
        loggerUtility.infoLog("The user validates the presence of " + emailValue + " value of the table content");
        Assert.assertTrue(rowContent.contains(salaryValue), "The last row doesn't contain salary value.");
        loggerUtility.infoLog("The user validates the presence of " + salaryValue + " value of the table content");
        Assert.assertTrue(rowContent.contains(departmentValue), "The last row doesn't contain department value.");
        loggerUtility.infoLog("The user validates the presence of " + departmentValue + " value of the table content");
    }

    public void editProcess(String editFirstNameValue, String editLastNameValue, String editEmailValue, String editSalaryValue, String editDepartmentValue, int tableSize){

        elementMethods.clickJSElement(editElement);
        loggerUtility.infoLog("The user clicks on Edit button  ");
        elementMethods.clearEditElement(editFirstNameElement, editFirstNameValue);
        loggerUtility.infoLog("The user clears and fills the First Name field with " + editFirstNameValue + " value");
        elementMethods.clearEditElement(editLastNameElement, editLastNameValue);
        loggerUtility.infoLog("The user clears and fills the Last Name field with " + editLastNameValue + " value");
        elementMethods.clearEditElement(editEmailElement, editEmailValue);
        loggerUtility.infoLog("The user clears and fills the user Email field with " + editEmailValue + " value");
        elementMethods.clearEditElement(editSalaryElement, editSalaryValue);
        loggerUtility.infoLog("The user clears and fills the Salary field with " + editSalaryValue + " value");
        elementMethods.clearEditElement(editDepartmentElement, editDepartmentValue);
        loggerUtility.infoLog("The user clears and fills the Department field with " + editDepartmentValue + " value");
        elementMethods.clickElement(editSubmitElement);
        loggerUtility.infoLog("The user clicks on Submit button ");

        String rowContent = newTableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(editFirstNameValue), "The last row doesn't contain first name value.");
        loggerUtility.infoLog("The user validates the presence of " + editFirstNameValue + " value of the table content");
        Assert.assertTrue(rowContent.contains(editLastNameValue), "The last row doesn't contain last name value.");
        loggerUtility.infoLog("The user validates the presence of " + editLastNameValue + " value of the table content");
        Assert.assertTrue(rowContent.contains(editEmailValue), "The last row doesn't contain email value.");
        loggerUtility.infoLog("The user validates the presence of " + editEmailValue + " value of the table content");
        Assert.assertTrue(rowContent.contains(editSalaryValue), "The last row doesn't contain salary value.");
        loggerUtility.infoLog("The user validates the presence of " + editSalaryValue + " value of the table content");
        Assert.assertTrue(rowContent.contains(editDepartmentValue), "The last row doesn't contain department value.");
        loggerUtility.infoLog("The user validates the presence of " + editDepartmentValue + " value of the table content");
    }

    public void deleteProcess(int tableSize){

        elementMethods.clickJSElement(deleteElement);
        loggerUtility.infoLog("The user clicks on Delete element");
        Assert.assertEquals(newTableContentList.size(), tableSize, "Default size for table is not " + tableSize);
        loggerUtility.infoLog("The user validates the size of table content to be " +tableSize);

    }
}
