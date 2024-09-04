package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFramesTest {

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

        WebElement alertFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertFrameWindowsMenu);

        WebElement nestedframesSubMenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        js.executeScript("arguments[0].click();", nestedframesSubMenu);

        //"frame1" este fereastra parinte tot ce cautam va fi in aceasta fereastra (iframe)
        driver.switchTo().frame("frame1");

        //in aceasta fereastra (iframe parinte) mai avem o fereastra mai mica (iframe copil) tipul ei ramane tot (iframe)
        //nu are un id deci il putem gasi dupa numele de tag (By.tagName))
        WebElement childFrameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(childFrameElement);
        //am mutat privirea in fereastra mica (iframe copil)


        WebElement childSampleTextElement = driver.findElement(By.tagName("p"));
        //in această fereastra mica, cautam primul paragraf de text (elementul <p>).
        System.out.println(childSampleTextElement.getText());
        //extragem si afisam textul din acel paragraf in consola




    }
}