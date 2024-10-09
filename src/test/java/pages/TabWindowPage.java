package pages;

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

    public void dealTabProcess() {
        elementMethods.clickJSElement(newTabElement);
        loggerUtility.infoLog("the user clicks on New Tab button ");
        tabMethods.switchSpecificTab(1);
        loggerUtility.infoLog("the user switches to specific tab ");
        tabMethods.closeCurrentTab();
        loggerUtility.infoLog("the user closes the current tab ");
        tabMethods.switchSpecificTab(0);
        loggerUtility.infoLog("the user Switches to next tab ");
    }

    public void dealWindowProcess() {
        elementMethods.clickJSElement(windowButtonElement);
        loggerUtility.infoLog("the user clicks on New Window button ");
        tabMethods.switchSpecificTab(1);
        loggerUtility.infoLog("the user switches to specific tab ");
        tabMethods.closeCurrentTab();
        loggerUtility.infoLog("the user closes the tab ");
        driver.quit();
    }

    public void dealWindowMessageProcess(){
        elementMethods.clickJSElement(newWindowMessageElement);
        loggerUtility.infoLog("the user clicks on New Window Message button ");
        tabMethods.switchSpecificTab(1);
        loggerUtility.infoLog("the user switches to specific tab ");
        tabMethods.closeCurrentTab();
        loggerUtility.infoLog("the user closes the tab ");
        driver.quit();
    }
}