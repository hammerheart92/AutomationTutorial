package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage {

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsSubMenu;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsSubMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesSubMenu;
    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFramesSubMenu;
    @FindBy(xpath = "//span[text()='Modal Dialogs']")
    private WebElement modalDialogSubMenu;

    public void clickAlert(){
        elementMethods.clickJSElement(alertsSubMenu);
        LoggerUtility.infoLog("the user clicks on Alert subMenu ");
    }
    public void clickBrowserWindowsSubMenu(){
        elementMethods.clickJSElement(browserWindowsSubMenu);
        LoggerUtility.infoLog("the user clicks on Browser Windows subMenu ");
    }
    public void clickFramesSubMenu(){
        elementMethods.clickJSElement(framesSubMenu);
        LoggerUtility.infoLog("the user clicks on Frames subMenu ");
    }
    public void clickNestedFramesSubMenu(){
        elementMethods.clickJSElement(nestedFramesSubMenu);
        LoggerUtility.infoLog("the user clicks on Nested Frames subMenu ");
    }
    public void clickModalDialogSubMenu(){
        elementMethods.clickJSElement(modalDialogSubMenu);
        LoggerUtility.infoLog("the user click on Modal Dialog subMenu");
    }
}
