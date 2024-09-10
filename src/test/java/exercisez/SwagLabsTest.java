package exercisez;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwagLabsTest {

    public WebDriver driver;

    @Test
    public void testMethod() {

        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement usernameElement = driver.findElement(By.id("user-name"));
        String usernameValue = "Chi Chi";
        elementMethods.fillElement(usernameElement, usernameValue);

        WebElement passwordElement = driver.findElement(By.id("password"));
        String passwordValue = "Gothic";
        elementMethods.fillElement(passwordElement, passwordValue);

    }
}
