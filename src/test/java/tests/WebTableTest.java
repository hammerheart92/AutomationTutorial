package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

import java.sql.Driver;
import java.util.List;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        //Deschidem un browser
        driver = new EdgeDriver();
        //Accesam un url
        driver.get("https://demoqa.com/");
        //Facem browserul maximize
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.clickElements();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.clickWebTable();

        String firstNameValue = "Apaczai";
        String lastNameValue = "Laszlo";
        String emailValue = "hammerheart92@mail.com";
        String ageValue = "32";
        String salaryValue = "3200";
        String departmentValue = "Technical Support";

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.createProcess(firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue, 3);

        String editFirstNameValue = "Laszlo";
        String editLastNameValue = "Istvan";
        String editEmailValue = "father.thunder92@gmail.com";
        String editSalaryValue = "4500";
        String editDepartmentValue = "Automation";

        webTablePage.editProcess(editFirstNameValue, editLastNameValue, editEmailValue, editSalaryValue, editDepartmentValue, 3);

        webTablePage.deleteProcess(3);

        driver.quit();

    }

}
