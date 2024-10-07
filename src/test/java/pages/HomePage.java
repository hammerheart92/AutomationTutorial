package pages;

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
    }

    public void clickElements(){
        elementMethods.clickJSElement(elementsMenu);
    }

    public void clickFormsMenu(){
        elementMethods.clickJSElement(formsMenu);
    }
}
