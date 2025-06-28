package tests;

import configFiles.DataConfig;
import io.qameta.allure.*;
import modelObject.PracticeFormModel;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import shareData.Hooks;

@Epic("UI Test Automation")
@Feature("Student Registration Form")
public class PracticeFormTest extends Hooks {

    @Test(description = "Fill and validate the complete student registration form")
    @Story("User completes and submits the Practice Form")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test fills in all required fields in the practice form, uploads a picture, selects date, state, city, hobbies, subjects and then" +
            " validates that all data appears correctly in the confirmation modal.")
    public void testMethod() {

        PracticeFormModel testData = new PracticeFormModel(DataConfig.PRACTICEFORM_DATA);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.clickPracticeFormSubMenu();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(testData);
        practiceFormPage.validateFormValues(testData);
    }
}