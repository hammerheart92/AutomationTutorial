package pages;

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

    public void clickAlert(){
        elementMethods.clickJSElement(alertsSubMenu);
        loggerUtility.infoLog("the user clicks on Alert subMenu ");
    }
    public void clickBrowserWindowsSubMenu(){
        elementMethods.clickJSElement(browserWindowsSubMenu);
        loggerUtility.infoLog("the user clicks on Browser Windows subMenu ");
    }
    public void clickFramesSubMenu(){
        elementMethods.clickJSElement(framesSubMenu);
        loggerUtility.infoLog("the user clicks on Frames subMenu ");
    }
    public void clickNestedFramesSubMenu(){
        elementMethods.clickJSElement(nestedFramesSubMenu);
        loggerUtility.infoLog("the user clicks on Nested Frames subMenu ");
    }

}
