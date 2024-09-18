package exercisez;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUs {

    public WebDriver driver;

    @Test
    public void testMethod() {

        //Deschidem un browser
        driver = new EdgeDriver();
        //Accesam un url
        driver.get("https://webdriveruniversity.com/");
        //Facem browserul maximize
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement contactUsPageElement = driver.findElement(By.xpath("//h1[text()='CONTACT US']"));
        elementMethods.clickJSElement(contactUsPageElement); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='first_name']")));
        elementMethods.fillElement(firstNameElement,"Laszlo");



    }
}