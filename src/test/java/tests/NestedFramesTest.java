package tests;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import shareData.ShareData;

import java.time.Duration;

public class NestedFramesTest extends ShareData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethods = new ElementMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        WebElement alertFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJSElement(alertFrameWindowsMenu);

        WebElement nestedframesSubMenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        elementMethods.clickJSElement(nestedframesSubMenu);

        //"frame1" este fereastra parinte tot ce cautam va fi in aceasta fereastra (iframe)
        frameMethods.switchToSpecificIframe("frame1");

        //in aceasta fereastra (iframe parinte) mai avem o fereastra mai mica (iframe copil) tipul ei ramane tot (iframe)
        //nu are un id deci il putem gasi dupa numele de tag (By.tagName))
        WebElement childFrameElement = driver.findElement(By.tagName("iframe"));
        frameMethods.switchToSpecificIframeByElement(childFrameElement);
        //am mutat privirea in fereastra mica (iframe copil)

        WebElement childSampleTextElement = driver.findElement(By.tagName("p"));
        //in această fereastra mica, cautam primul paragraf de text (elementul <p>).
        System.out.println(childSampleTextElement.getText());
        //extragem si afisam textul din acel paragraf in consola


    }
}