package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public AlertMethods alertMethods;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        alertMethods = new AlertMethods(this.driver);
        PageFactory.initElements(this.driver,this);
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
