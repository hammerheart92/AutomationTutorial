package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

        public WebDriver driver;

        @Test
        public void metodaTest() {


            //Deschidem un browser
            driver = new EdgeDriver();
            //Accesam un url
            driver.get("https://demoqa.com/");
            //Facem browserul maximize
            driver.manage().window().maximize();
            //wait implicit
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            ElementMethods elementMethods = new ElementMethods(driver);
            AlertMethods alertMethods = new AlertMethods(driver);

            WebElement alertFrameWindowsMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
            elementMethods.clickJSElement(alertFrameWindowsMeniu);

            WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
            elementMethods.clickJSElement(alertsElement);

            WebElement okAlert = driver.findElement(By.id("alertButton"));
            elementMethods.clickElement(okAlert);

            alertMethods.acceptAlert();

            WebElement timerAlertButtonElement = driver.findElement(By.id("timerAlertButton"));
            elementMethods.clickElement(timerAlertButtonElement);

            alertMethods.acceptAlert();

            WebElement confirmAlert = driver.findElement(By.id("confirmButton"));
            elementMethods.clickElement(confirmAlert);

            alertMethods.dismissAlert();

            WebElement promtButtonAlert = driver.findElement(By.id("promtButton"));
            elementMethods.clickElement(promtButtonAlert);

            alertMethods.fillAlert("Ro Alert");


        }

    }

