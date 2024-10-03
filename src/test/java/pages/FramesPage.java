package pages;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
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
