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

    public void dealTabProcess() {
        elementMethods.clickJSElement(newTabElement);
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);
    }

    public void dealWindowProcess() {
        elementMethods.clickJSElement(windowButtonElement);
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        driver.quit();
    }
}