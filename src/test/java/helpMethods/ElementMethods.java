package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.*;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitTextToBePresentInElement(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
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

    public void removeAdIframes() {
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe[id^=\"google_ads_iframe\"], iframe[src*=\"safeframe\"], iframe[title=\"3rd party ad content\"]').forEach(el => el.remove());"
        );
    }


    //  Retry click if StaleElementReferenceException is thrown
    public void safeClick(WebElement element) {
        try {
            removeAdIframes(); // AD block first!
            element.click();
        } catch (ElementClickInterceptedException e) {
            removeAdIframes(); // Retry after cleanup
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(element))
                    .click();
        } catch (StaleElementReferenceException e) {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(element))
                    .click();
        }
    }

    public void clearElement(WebElement element) {
        waitVisibleElement(element);
        element.clear();
    }
}
