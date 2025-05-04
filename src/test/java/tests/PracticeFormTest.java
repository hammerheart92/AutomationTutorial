package tests;

import configFiles.DataConfig;
import modelObject.PracticeFormModel;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import shareData.Hooks;

public class PracticeFormTest extends Hooks {

    @Test
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