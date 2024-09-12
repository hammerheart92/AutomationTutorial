package tests;

import helpMethods.ElementMethods;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.File;
import java.sql.Driver;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        //Deschidem un browser
        driver = new ChromeDriver();
        //Accesam un url
        driver.get("https://demoqa.com/");
        //Facem browserul maximize
        driver.manage().window().maximize();

        ElementMethods elementMethods = new ElementMethods(driver);


        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementMethods.clickJSElement(formsMenu);

        WebElement practiceFormsSubMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethods.clickJSElement(practiceFormsSubMenu);

        WebElement fistNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Apaczai";
        elementMethods.fillElement(fistNameElement,firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Laszlo";
        elementMethods.fillElement(lastNameElement,lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "hammerheart92@gmail.com";
        elementMethods.fillElement(emailElement,emailValue);

        List<WebElement> genderOptionsList = driver.findElements(By.xpath("//input[@name='gender']/../label"));
        String genderValue = "Male";


        switch (genderValue) {
            case "Male":
                elementMethods.clickJSElement(genderOptionsList.get(0));
                break;
            case "Female":
                elementMethods.clickJSElement(genderOptionsList.get(1));
                break;
            case "Other":
                elementMethods.clickJSElement(genderOptionsList.get(2));
                break;
        }

        WebElement numberElement = driver.findElement(By.id("userNumber"));
        String numberValue = "0729875987";
        elementMethods.fillElement(numberElement,numberValue);

        //date of birth interaction
        WebElement dateOfBirthElement = driver.findElement(By.id("dateOfBirthInput"));
        elementMethods.clickElement(dateOfBirthElement);

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        String monthValue = "January";
        elementMethods.selectDropdownElement(monthElement,monthValue);

        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));
        String yearValue = "2030";
        elementMethods.selectDropdownElement(yearElement,yearValue);

        String dayValue = "18";
        List<WebElement> daysList = driver.findElements(By.xpath("//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]"));
        for (int index = 0; index < daysList.size(); index++) {
            if (daysList.get(index).getText().equals(dayValue)) {
                elementMethods.clickElement(daysList.get(index));
                break;
            }

        }


        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectValues = Arrays.asList("Chemistry", "Social Studies", "Economics");
        for (int index = 0; index < subjectValues.size(); index++) {
            elementMethods.fillPressElement(subjectsElement,subjectValues.get(index),Keys.ENTER);
        }

        //La lista de elemente este gresit sa punem valoarea trebuie sa fie lista deoarece trebuie sa parcurga lista de elemente
        List<String> hobbiesValues = Arrays.asList("Sports", "Music");
        List<WebElement> hobbiesOptionsList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']"));
        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbiesValues.contains(currentText)) {
                elementMethods.clickJSElement(hobbiesOptionsList.get(index));
            }
        }

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/Laci.txt");
        elementMethods.fillElement(pictureElement,file.getAbsolutePath());

        WebElement currentAdressElement = driver.findElement(By.id("currentAddress"));
        String currentAdressValue = "Cluj-Napoca, Aleea Ciucas, Nr.9";
        elementMethods.fillElement(currentAdressElement,currentAdressValue);

        WebElement stateElement = driver.findElement(By.xpath("//div[text()='Select State']"));
        elementMethods.clickJSElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateInputValue = "Haryana";
        elementMethods.fillPressElement(stateInputElement,stateInputValue,Keys.ENTER);


        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityInputValue = "Karnal";
        elementMethods.fillPressElement(cityInputElement,cityInputValue,Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementMethods.clickJSElement(submitElement);


        //validam datele introduse

        WebElement thankYouElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");


        List<WebElement> labelList = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//td[1]"));
        List<WebElement> valuesList = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//td[2]"));

        Assert.assertEquals(labelList.get(0).getText(), "Student Name");
        Assert.assertEquals(labelList.get(1).getText(), "Student Email");
        Assert.assertEquals(labelList.get(2).getText(), "Gender");
        Assert.assertEquals(labelList.get(3).getText(), "Mobile");
        Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
        Assert.assertEquals(labelList.get(5).getText(), "Subjects");
        Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
        Assert.assertEquals(labelList.get(7).getText(), "Picture");
        Assert.assertEquals(labelList.get(8).getText(), "Address");
        Assert.assertEquals(labelList.get(9).getText(), "State and City");

        Assert.assertEquals(valuesList.get(0).getText(), firstNameValue + " " + lastNameValue);
        Assert.assertEquals(valuesList.get(1).getText(), emailValue);
        Assert.assertEquals(valuesList.get(2).getText(), genderValue);
        Assert.assertEquals(valuesList.get(3).getText(), numberValue);
        Assert.assertEquals(valuesList.get(4).getText(), "18 January,2030");
        Assert.assertEquals(valuesList.get(5).getText(), "Chemistry, Social Studies, Economics");
        Assert.assertEquals(valuesList.get(6).getText(), "Sports, Music");
        Assert.assertEquals(valuesList.get(7).getText(), pictureElement);
        Assert.assertEquals(valuesList.get(8).getText(), currentAdressValue);
        Assert.assertEquals(valuesList.get(9).getText(), stateInputValue + " " + cityInputValue);


    }
}