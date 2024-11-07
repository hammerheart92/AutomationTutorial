package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTableSubMenu;

    public void clickWebTable(){
        elementMethods.clickJSElement(webTableSubMenu);
        LoggerUtility.infoLog("the user click on Web Table subMenu ");
    }
}
