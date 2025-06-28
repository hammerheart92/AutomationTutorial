package pages;

import io.qameta.allure.Step;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramePage extends BasePage {
    public NestedFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    private WebElement childIFrame;
    @FindBy(tagName = "p")
    private WebElement childSampleText;

    @Step("Handle nested frames and validate content in parent and child iframes")
    public void dealNestedFrame() {
        // Switch to parent iframe by name
        frameMethods.switchToSpecificIframe("frame1");
        LoggerUtility.infoLog("The user switches to the parent iframe");

        // Wait for the child iframe to be visible inside the parent iframe
        elementMethods.waitVisibleElement(childIFrame);
        LoggerUtility.infoLog("Waiting for the child iframe to be visible");

        // Switch to the child iframe using the WebElement
        frameMethods.switchToSpecificIframe(childIFrame);
        LoggerUtility.infoLog("The user switches to the child iframe");

        // Wait for the paragraph element inside the child iframe
        elementMethods.waitVisibleElement(childSampleText);
        LoggerUtility.infoLog("Waiting for the sample text to be visible");

        System.out.println(childSampleText.getText());
        LoggerUtility.infoLog("The user interacts with the element within the child iframe");

        // Go back to the main document
        frameMethods.switchToDefaultIframe();
        LoggerUtility.infoLog("The user switches back to default content");
    }
}
