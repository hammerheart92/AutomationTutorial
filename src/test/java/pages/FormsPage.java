package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public FormsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceFormsSubMenu;

    public void clickPracticeForm(){
        elementMethods.clickJSElement(practiceFormsSubMenu);
    }
}
