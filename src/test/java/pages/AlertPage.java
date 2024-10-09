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
        loggerUtility.infoLog("the user clicks on alertOk ");
        alertMethods.acceptAlert();
        loggerUtility.infoLog("the user accepts the Alert ");
        elementMethods.clickElement(timerAlertButtonElement);
        loggerUtility.infoLog("the user clicks on timerAlert ");
        alertMethods.acceptAlert();
        loggerUtility.infoLog("the user accepts the Alert ");
        elementMethods.clickElement(confirmAlert);
        loggerUtility.infoLog("the user clicks on alertConfirm ");
        alertMethods.dismissAlert();
        loggerUtility.infoLog("the user dismissed the Alert ");
        elementMethods.clickElement(promtButtonAlert);
        loggerUtility.infoLog("the user clicks on  promptAlert ");
        alertMethods.fillAlert(text);
        loggerUtility.infoLog("the user fills the alert display with "+ text +"values and accepts it");

    }

}
