package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import shareData.ShareData;

import java.util.List;

public class DatePicker extends ShareData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethods = new ElementMethods(getDriver());

        WebElement widgetsMenu = getDriver().findElement(By.xpath("//h5[text()='Widgets']"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        elementMethods.clickJSElement(widgetsMenu);

        WebElement widgestsSubMenu = getDriver().findElement(By.xpath("//span[text()='Date Picker']"));
        elementMethods.clickJSElement(widgestsSubMenu);

        WebElement datePickerMonthYearElement = getDriver().findElement(By.id("datePickerMonthYearInput"));
        elementMethods.clickJSElement(datePickerMonthYearElement);

        WebElement monthElement = getDriver().findElement(By.className("react-datepicker__month-select"));
        Select monthSelect = new Select(monthElement);
        String monthValue = "August";
        monthSelect.selectByVisibleText(monthValue);

        WebElement yearElement = getDriver().findElement(By.className("react-datepicker__year-select"));
        Select yearSelect = new Select(yearElement);
        String yearValue = "1996";
        yearSelect.selectByVisibleText(yearValue);

        String dayValue = "31";
        List<WebElement> daysList = getDriver().findElements(By.xpath("//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]"));
        for (int index = 0; index < daysList.size(); index++) {
            if (daysList.get(index).getText().equals(dayValue)) {
                daysList.get(index).click();
                break;
            }

        }

        WebElement dateAndTimePickerElement = getDriver().findElement(By.id("dateAndTimePickerInput"));
        elementMethods.clickJSElement(dateAndTimePickerElement);

        WebElement monthPickerElement = getDriver().findElement(By.xpath("//div[@class='react-datepicker__month-read-view']"));
        elementMethods.clickJSElement(monthPickerElement);


        String monthsValue = "August";
        List<WebElement> monthslist = getDriver().findElements(By.xpath("//div[@class='react-datepicker__month-dropdown']//div"));
        for (int index = 0; index < monthslist.size(); index++) {
            if (monthslist.get(index).getText().equals(monthsValue)) {
                monthslist.get(index).click();
                break;
            }

        }

        WebElement yearPickerElement = getDriver().findElement(By.xpath("//div[@class='react-datepicker__year-read-view']"));
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