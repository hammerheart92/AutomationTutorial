package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFrameWindowPage extends BasePage {

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsSubMenu;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowsSubMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesSubMenu;

    public void clickAlert(){
        elementMethods.clickJSElement(alertsSubMenu);
    }
    public void clickBrowserWindowsSubMenu(){
        elementMethods.clickJSElement(browserWindowsSubMenu);
    }
    public void clickFramesSubMenu(){
        elementMethods.clickJSElement(framesSubMenu);
    }

}
