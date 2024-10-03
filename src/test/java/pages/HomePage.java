package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertFrameWindowsMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formsMenu;

    public void clickAlertFrameWindow(){
        elementMethods.clickJSElement(alertFrameWindowsMenu);
    }

    public void clickElements(){
        elementMethods.clickJSElement(elementsMenu);
    }

    public void clickForms(){
        elementMethods.clickJSElement(formsMenu);
    }
}
