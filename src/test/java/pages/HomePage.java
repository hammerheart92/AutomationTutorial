package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertFrameWindowsMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    public void clickAlertFrameWindow(){
        elementMethods.clickJSElement(alertFrameWindowsMenu);
        LoggerUtility.infoLog("the user clicks on Alerts, Frame & Windows menu ");
    }

    public void clickElements(){
        elementMethods.clickJSElement(elementsMenu);
        LoggerUtility.infoLog("the user clicks on Elements menu ");
    }

    public void clickFormsMenu(){
        elementMethods.clickJSElement(formsMenu);
        LoggerUtility.infoLog("the user clicks on Forms menu ");
    }
}
