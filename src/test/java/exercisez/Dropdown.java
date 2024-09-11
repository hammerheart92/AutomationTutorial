package exercisez;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Dropdown {

    public WebDriver driver;

    @Test
    public void testMethod() {

        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement dropDownListElement = driver.findElement(By.linkText("Dropdown"));
        elementMethods.clickElement(dropDownListElement);

        WebElement optionSelect = driver.findElement(By.id("dropdown"));
        elementMethods.selectDropdownElement(optionSelect,"Option 2");
    }
}