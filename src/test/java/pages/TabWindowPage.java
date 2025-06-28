package pages;

import io.qameta.allure.Step;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabWindowPage extends BasePage {

    public TabWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabElement;
    @FindBy(id = "windowButton")
    private WebElement windowButtonElement;
    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMessageElement;

    @Step("Handle tab interaction: open, switch, close")
    public void dealTabProcess() {
        elementMethods.clickJSElement(newTabElement);
        LoggerUtility.infoLog("the user clicks on New Tab button ");
        tabMethods.switchSpecificTab(1);
        LoggerUtility.infoLog("the user switches to specific tab ");
        tabMethods.closeCurrentTab();
        LoggerUtility.infoLog("the user closes the current tab ");
        tabMethods.switchSpecificTab(0);
        LoggerUtility.infoLog("the user Switches to next tab ");
    }

    @Step("Handle window interaction: open, switch, close")
    public void dealWindowProcess() {
        elementMethods.clickJSElement(windowButtonElement);
        LoggerUtility.infoLog("the user clicks on New Window button ");
        tabMethods.switchSpecificTab(1);
        LoggerUtility.infoLog("the user switches to specific tab ");
        tabMethods.closeCurrentTab();
        LoggerUtility.infoLog("the user closes the tab ");
        driver.quit();
    }

    public void dealWindowMessageProcess(){
        elementMethods.clickJSElement(newWindowMessageElement);
        LoggerUtility.infoLog("the user clicks on New Window Message button ");
        tabMethods.switchSpecificTab(1);
        LoggerUtility.infoLog("the user switches to specific tab ");
        tabMethods.closeCurrentTab();
        LoggerUtility.infoLog("the user closes the tab ");
        driver.quit();
    }
}