package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@AllArgsConstructor
public class ElementMethods {

    public WebDriver driver;

    public void clickElement(WebElement element) {
        waitVisibleElement(element);
        element.click();

    }

    public void clickJSElement(WebElement element) {
        waitVisibleElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void fillElement(WebElement element, String text) {
        waitVisibleElement(element);
        element.sendKeys(text);

    }

    public void fillPressElement(WebElement element, String text, Keys value) {
        waitVisibleElement(element);
        element.sendKeys(text);
        element.sendKeys(value);
    }

    public void waitVisibleElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void selectDropdownElement(WebElement element, String text) {
        waitVisibleElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void clearEditElement(WebElement element, String text) {
        waitVisibleElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollAndClickJSElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        try {
            Thread.sleep(300); // gives the page time to settle
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        clickJSElement(element);
    }

    public void hideAllIframes() {
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe').forEach(el => el.style.display = 'none');");
    }

    public void clearElement(WebElement element) {
        waitVisibleElement(element);
        element.clear();
    }
}
