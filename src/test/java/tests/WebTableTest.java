package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import shareData.ShareData;

public class WebTableTest extends ShareData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        String firstNameValue = "Apaczai";
        String lastNameValue = "Laszlo";
        String emailValue = "hammerheart92@mail.com";
        String ageValue = "32";
        String salaryValue = "3200";
        String departmentValue = "Technical Support";

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.createProcess(firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue, 3);

        String editFirstNameValue = "Laszlo";
        String editLastNameValue = "Istvan";
        String editEmailValue = "father.thunder92@gmail.com";
        String editSalaryValue = "4500";
        String editDepartmentValue = "Automation";

        webTablePage.editProcess(editFirstNameValue, editLastNameValue, editEmailValue, editSalaryValue, editDepartmentValue, 3);

        webTablePage.deleteProcess(3);

        getDriver().quit();

    }

}
