package tests;

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

            WebElement alertFrameWindowsMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", alertFrameWindowsMeniu);

            WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
            js.executeScript("arguments[0].click();", alertsElement);

            WebElement okAlert = driver.findElement(By.id("alertButton"));
            okAlert.click();

            Alert firstAlert = driver.switchTo().alert();
            System.out.println(firstAlert.getText());
            firstAlert.accept();

            WebElement timerAlertButtonElement = driver.findElement(By.id("timerAlertButton"));
            timerAlertButtonElement.click();

            //wait explicit
            WebDriverWait waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(10));
            waitExplicit.until(ExpectedConditions.alertIsPresent());

            Alert secondAlert = driver.switchTo().alert();
            System.out.println(secondAlert.getText());
            secondAlert.accept();

            WebElement confirmAlert = driver.findElement(By.id("confirmButton"));
            confirmAlert.click();

            Alert thirdAlert = driver.switchTo().alert();
            System.out.println(thirdAlert.getText());
            //thirdAlert.accept();
            thirdAlert.dismiss();

            WebElement promtButtonAlert = driver.findElement(By.id("promtButton"));
            promtButtonAlert.click();
            Alert fourthAlert = driver.switchTo().alert();
            System.out.println(fourthAlert.getText());
            fourthAlert.sendKeys("Ro Alert");
            fourthAlert.accept();






        }

    }

