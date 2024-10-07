package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement okAlert;
    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement confirmAlert;
    @FindBy(id = "promtButton")
    private WebElement promtButtonAlert;

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
