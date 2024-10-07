package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import shareData.ShareData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends ShareData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.clickPracticeFormSubMenu();

        String firstNameValue = "Apaczai";
        String lastNameValue = "Laszlo";
        String emailValue = "hammerheart92@gmail.com";
        String genderValue = "Male";
        String mobileNumberValue = "0729875987";
        String monthValue = "January";
        String yearValue = "2030";
        String dayValue = "18";
        List<String> subjectValues = Arrays.asList("Chemistry", "Social Studies", "Economics");
        List<String> hobbiesValues = Arrays.asList("Sports", "Music");
        String pathFile = "src/test/resources/Laci.txt";
        String currentAddressValue = "Cluj-Napoca, Aleea Ciucas, Nr.9";
        String stateInputValue = "Haryana";
        String cityInputValue = "Karnal";

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, emailValue, genderValue, mobileNumberValue, monthValue, yearValue, dayValue,
                subjectValues, hobbiesValues, pathFile, currentAddressValue, stateInputValue, cityInputValue);

        practiceFormPage.validateFormValues(firstNameValue, lastNameValue, emailValue, genderValue, mobileNumberValue, dayValue, monthValue,
                yearValue, subjectValues, hobbiesValues, pathFile, currentAddressValue, stateInputValue, cityInputValue);


    }
}