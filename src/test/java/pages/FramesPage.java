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
        loggerUtility.infoLog("the user switches to specific Iframe");
        System.out.println(sampleTextElement.getText());
        loggerUtility.infoLog("the user interacts with an element within Iframe");
        frameMethods.switchToParentIframe();
        loggerUtility.infoLog("the user switches to parent frame ");
    }

    public void dealSecondIFrame(){
        frameMethods.switchToSpecificIframe("frame2");
        loggerUtility.infoLog("the user switches to specific Iframe ");
        System.out.println(secondSampleTextElement.getText());
        loggerUtility.infoLog("the user interacts with an element within Iframe ");

    }
}
