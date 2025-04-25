package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected AlertMethods alertMethods;
    protected ElementMethods elementMethods;
    protected FrameMethods frameMethods;
    protected TabMethods tabMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        alertMethods = new AlertMethods(this.driver);
        elementMethods = new ElementMethods(this.driver);
        frameMethods = new FrameMethods(this.driver);
        tabMethods = new TabMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }
}
