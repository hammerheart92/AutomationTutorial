package exercisez;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class AddRemoveElement {

    public WebDriver driver;

    @Test
    public void testMethod() {

        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement addRemoveElement = driver.findElement(By.linkText("Add/Remove Elements"));
        elementMethods.clickElement(addRemoveElement);

        WebElement addElements = driver.findElement(By.xpath("//button[contains(text(),'Add Element')]"));
        for (int index = 0; index < 10; index++) {
            elementMethods.clickElement(addElements);
        }

        List<WebElement> deleteElements = driver.findElements(By.xpath("//button[contains(text(),'Delete')]"));
        while (deleteElements.size() > 0) {
            deleteElements.get(0).click();
            deleteElements = driver.findElements(By.xpath("//button[contains(text(),'Delete')]"));
        }

    }
}