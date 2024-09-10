package exercisez;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptAlerts {

    public WebDriver driver;

    @Test
    public void testMethod() {

        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);
        AlertMethods alertMethods = new AlertMethods(driver);

        WebElement javaScriptAlertsElement = driver.findElement(By.linkText("JavaScript Alerts"));
        elementMethods.clickJSElement(javaScriptAlertsElement);

        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        elementMethods.clickJSElement(jsAlert);
        System.out.println("First Alert locator: " + jsAlert);

        alertMethods.acceptAlert();

        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        elementMethods.clickJSElement(jsConfirm);
        System.out.println("Second Alert locator: " + jsConfirm);

        alertMethods.acceptAlert();

        WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
        elementMethods.clickJSElement(jsPrompt);
        alertMethods.fillAlert("This is a tsunami alert");
        System.out.println("Third Alert locator: " + jsPrompt);

    }
}