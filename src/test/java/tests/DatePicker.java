package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DatePicker {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        //Deschidem un browser
        driver = new EdgeDriver();
        //Accesam un url
        driver.get("https://demoqa.com/");
        //Facem browserul maximize
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement widgetsMenu = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        elementMethods.clickJSElement(widgetsMenu);

        WebElement widgestsSubMenu = driver.findElement(By.xpath("//span[text()='Date Picker']"));
        elementMethods.clickJSElement(widgestsSubMenu);

        WebElement datePickerMonthYearElement = driver.findElement(By.id("datePickerMonthYearInput"));
        elementMethods.clickJSElement(datePickerMonthYearElement);

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect = new Select(monthElement);
        String monthValue = "August";
        monthSelect.selectByVisibleText(monthValue);

        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect = new Select(yearElement);
        String yearValue = "1996";
        yearSelect.selectByVisibleText(yearValue);

        String dayValue = "31";
        List<WebElement> daysList = driver.findElements(By.xpath("//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]"));
        for (int index = 0; index < daysList.size(); index++) {
            if (daysList.get(index).getText().equals(dayValue)) {
                daysList.get(index).click();
                break;
            }

        }

        WebElement dateAndTimePickerElement = driver.findElement(By.id("dateAndTimePickerInput"));
        elementMethods.clickJSElement(dateAndTimePickerElement);

        WebElement monthPickerElement = driver.findElement(By.xpath("//div[@class='react-datepicker__month-read-view']"));
        elementMethods.clickJSElement(monthPickerElement);


        String monthsValue = "August";
        List<WebElement> monthslist = driver.findElements(By.xpath("//div[@class='react-datepicker__month-dropdown']//div"));
        for (int index = 0; index < monthslist.size(); index++) {
            if (monthslist.get(index).getText().equals(monthsValue)) {
                monthslist.get(index).click();
                break;
            }

        }

        WebElement yearPickerElement = driver.findElement(By.xpath("//div[@class='react-datepicker__year-read-view']"));
        elementMethods.clickJSElement(yearPickerElement);
        

//        List<WebElement> years = driver.findElements(By.xpath("//div[@class='react-datepicker__year-dropdown']//div"));
//        boolean found = false;
//        for (WebElement year : years) {
//            if (year.getText().equals("1991")) {
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", year);
//                year.click();
//                found = true;
//                break;
//            }
//
//        }
//
//        if (!found) {
//            WebElement yearDropdown = driver.findElement(By.xpath("//div[@class='react-datepicker__year-dropdown']"));
//            yearDropdown.sendKeys(Keys.PAGE_DOWN);
//
//        }

    }
}