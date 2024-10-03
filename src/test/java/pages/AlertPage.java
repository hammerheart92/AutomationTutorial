package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    public WebElement okAlert;
    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButtonElement;
    @FindBy(id = "confirmButton")
    public WebElement confirmAlert;
    @FindBy(id = "promtButton")
    public WebElement promtButtonAlert;

    public void dealAlertProcess(String text){
        elementMethods.clickElement(okAlert);
        alertMethods.acceptAlert();
        elementMethods.clickElement(timerAlertButtonElement);
        alertMethods.acceptAlert();
        elementMethods.clickElement(confirmAlert);
        alertMethods.dismissAlert();
        elementMethods.clickElement(promtButtonAlert);
        alertMethods.fillAlert(text);

    }

}
