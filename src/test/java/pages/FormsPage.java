package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends BasePage {

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceFormsSubMenu;

    public void clickPracticeFormSubMenu(){
        elementMethods.clickJSElement(practiceFormsSubMenu);
        LoggerUtility.infoLog("the user clicks on Practice Form subMenu ");
    }
}
