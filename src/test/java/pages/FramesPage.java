package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
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
        LoggerUtility.infoLog("The user switches to the first iframe");

        elementMethods.waitVisibleElement(sampleTextElement);
        LoggerUtility.infoLog("The user waits for the element inside the first iframe");

        System.out.println(sampleTextElement.getText());
        LoggerUtility.infoLog("The user reads text inside the first iframe");

        frameMethods.switchToParentIframe();
        LoggerUtility.infoLog("The user switches back to the parent frame");
    }

    public void dealSecondIFrame(){
        frameMethods.switchToSpecificIframe("frame2");
        LoggerUtility.infoLog("The user switches to the second iframe");

        elementMethods.waitVisibleElement(sampleTextElement); // Reuse same locator, if valid
        LoggerUtility.infoLog("The user waits for the element inside the second iframe");

        System.out.println(sampleTextElement.getText());
        LoggerUtility.infoLog("The user reads text inside the second iframe");

        frameMethods.switchToParentIframe();
        LoggerUtility.infoLog("The user switches back to the parent frame");
    }
}
