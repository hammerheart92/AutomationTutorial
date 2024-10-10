package tests;

import modelObject.PracticeFormModel;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import shareData.Hooks;

public class PracticeFormTest extends Hooks {

    @Test
    public void metodaTest() {

        PracticeFormModel testData = new PracticeFormModel("src/test/resources/inputData/PracticeFormResource.json");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.clickPracticeFormSubMenu();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(testData);
        practiceFormPage.validateFormValues(testData);
    }
}