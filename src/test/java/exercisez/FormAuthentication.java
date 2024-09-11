package exercisez;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormAuthentication {

    public WebDriver driver;

    @Test
    public void testMethod() {

        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement formAuthenticationElement = driver.findElement(By.linkText("Form Authentication"));
        elementMethods.clickElement(formAuthenticationElement);

        WebElement usernameInputElement = driver.findElement(By.id("username"));
        String usernameInputValue = "Laszlo Istvan";
        elementMethods.fillElement(usernameInputElement, usernameInputValue);

        WebElement passwordInputElement = driver.findElement(By.id("password"));
        String passwordInputValue = "This,is,a,password";
        elementMethods.fillElement(passwordInputElement, passwordInputValue);

        WebElement submitElement = driver.findElement(By.xpath("//button"));
        elementMethods.clickElement(submitElement);

    }
}