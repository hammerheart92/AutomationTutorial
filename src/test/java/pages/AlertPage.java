package pages;


import loggerUtility.LoggerUtility;
import modelObject.AlertModel;
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

    public void dealAlertProcess(AlertModel testData){
        elementMethods.clickElement(okAlert);
        LoggerUtility.infoLog("the user clicks on alertOk ");
        alertMethods.acceptAlert();
        LoggerUtility.infoLog("the user accepts the Alert ");
        elementMethods.clickElement(timerAlertButtonElement);
        LoggerUtility.infoLog("the user clicks on timerAlert ");
        alertMethods.acceptAlert();
        LoggerUtility.infoLog("the user accepts the Alert ");
        elementMethods.clickElement(confirmAlert);
        LoggerUtility.infoLog("the user clicks on alertConfirm ");
        alertMethods.dismissAlert();
        LoggerUtility.infoLog("the user dismissed the Alert ");
        elementMethods.clickElement(promtButtonAlert);
        LoggerUtility.infoLog("the user clicks on  promptAlert ");
        alertMethods.fillAlert(testData.getAlertText());
        LoggerUtility.infoLog("the user fills the alert display with "+ testData.getAlertText() +"values and accepts it");

    }

}
