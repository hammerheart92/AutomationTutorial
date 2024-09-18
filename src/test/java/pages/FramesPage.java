package pages;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        frameMethods = new FrameMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id = "sampleHeading")
    public WebElement sampleTextElement;
    @FindBy(id = "sampleHeading")
    public WebElement secondSampleTextElement;

    public void dealFirstIFrame(){
        frameMethods.switchToSpecificIframe("frame1");
        System.out.println(sampleTextElement.getText());
        frameMethods.switchToParentIframe();
    }

    public void dealSecondIFrame(){
        frameMethods.switchToSpecificIframe("frame2");
        System.out.println(secondSampleTextElement.getText());

    }
}
