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
        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementMethods.clickJSElement(elementsMenu);

        //span[text()='Web Tables']

        WebElement webTableSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementMethods.clickJSElement(webTableSubMenu);

        //validam dimenisunea initiala a tabelului

        List<WebElement> tableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(), 3, "Default size for table is not 3. ");
        //a doua virgula dupa expected reprezinta mesajul pe care vrei sa il adaugi "" care adauga al doilea parametru


        //Definim un element (Denumirea sa fie de preferat ca pe site)
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementMethods.clickElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Apaczai";
        elementMethods.fillElement(firstNameElement, firstNameValue);
        //Scriem din firtNameElement valoare din firstNameValue

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Laszlo";
        elementMethods.fillElement(lastNameElement, lastNameValue);
        //Scriem din lastNameElement valoarea din lastNameValue

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "hammerheart92@mail.com";
        elementMethods.fillElement(emailElement, emailValue);
        //Scriem din emailElement valoarea din emailValue


        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "32";
        elementMethods.fillElement(ageElement, ageValue);
        //Scriem din ageElement valoarea din ageValue

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "3200";
        elementMethods.fillElement(salaryElement, salaryValue);
        //Scriem din salaryElement valoarea din salaryValue

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "Technical Support";
        elementMethods.fillElement(departmentElement, departmentValue);
        //Scriem din departmentElement valoarea din departmentValue

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementMethods.clickElement(submitElement);

        //validam noua dimensiune al tabelului

        List<WebElement> newTableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(newTableContentList.size(), 4, "Default size for table is not 4. ");

        //validam valoriile pe care le-am introdus
        //String cu element nu se inteleg trebuie sa fie String cu String
        //rowContent trebuie sa contina valoarea din elementele pe care le-am definit
        String rowContent = newTableContentList.get(3).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row doesn't contain first name value.");
        Assert.assertTrue(rowContent.contains(lastNameValue), "The last row doesn't contain last name value.");
        Assert.assertTrue(rowContent.contains(emailValue), "The last row doesn't contain email value.");
        Assert.assertTrue(rowContent.contains(salaryValue), "The last row doesn't contain salary value.");
        Assert.assertTrue(rowContent.contains(departmentValue), "The last row doesn't contain department value.");

        //edit functionality

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementMethods.clickJSElement(editElement);
        //Il folosim ca si un javaScript executor

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Laszlo";
        elementMethods.clearEditElement(editFirstNameElement, editFirstNameValue);

        //second element

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Istvan";
        elementMethods.clearEditElement(editLastNameElement, editLastNameValue);

        //3RD element

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "father.thunder92@gmail.com";
        elementMethods.clearEditElement(editEmailElement, editEmailValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "4500";
        elementMethods.clearEditElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "Automation";
        elementMethods.clearEditElement(editDepartmentElement, editDepartmentValue);

        WebElement editSubmitElement = driver.findElement(By.id("submit"));
        elementMethods.clickElement(editSubmitElement);

        //validam valoriile modificate din tabel

        rowContent = newTableContentList.get(3).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(editFirstNameValue), "The last row doesn't contain first name value.");
        Assert.assertTrue(rowContent.contains(editLastNameValue), "The last row doesn't contain last name value.");
        Assert.assertTrue(rowContent.contains(editEmailValue), "The last row doesn't contain email value.");
        Assert.assertTrue(rowContent.contains(editSalaryValue), "The last row doesn't contain salary value.");
        Assert.assertTrue(rowContent.contains(editDepartmentValue), "The last row doesn't contain department value.");

        //Function delete

        //h5[text()='Elements']
        //daca nu avem un id se foloseste varianta By.xpath

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementMethods.clickJSElement(deleteElement);

        newTableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(newTableContentList.size(), 3, "Default size for table is not 3. ");

        driver.quit();

    }

}
