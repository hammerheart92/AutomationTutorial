package exercisez;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ForgotPassword {

    public WebDriver driver;

    @Test
    public void testMethod() {

        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement forgotPasswordElement = driver.findElement(By.linkText("Forgot Password"));
        elementMethods.clickJSElement(forgotPasswordElement);

        WebElement emailInputElement = driver.findElement(By.id("email"));
        elementMethods.clickElement(emailInputElement);

        WebElement emailFillElement = driver.findElement(By.id("email"));
        String emailFillValue = "laszlo@test.it";
        elementMethods.fillElement(emailFillElement, emailFillValue);

        WebElement submitRetrivePasswordElement = driver.findElement(By.id("form_submit"));
        elementMethods.clickElement(submitRetrivePasswordElement);

    }
}
