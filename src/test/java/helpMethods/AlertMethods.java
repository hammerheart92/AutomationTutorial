package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class AlertMethods {
    public WebDriver driver;

    public void waitForAlert(){
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitExplicit.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert(){
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void fillAlert(String text){
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
}
