package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement sampleTextElement;
    @FindBy(id = "sampleHeading")
    private WebElement secondSampleTextElement;

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
