package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends BasePage {

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceFormsSubMenu;

    public void clickPracticeForm(){
        elementMethods.clickJSElement(practiceFormsSubMenu);
    }
}
