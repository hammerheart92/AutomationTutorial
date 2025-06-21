package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    private final By sampleHeadingLocator = By.id("sampleHeading");

    public void dealFirstIFrame() {
        frameMethods.switchToSpecificIframe("frame1");
        LoggerUtility.infoLog("The user switches to the first iframe");

        WebElement sampleHeading = driver.findElement(sampleHeadingLocator);
        elementMethods.waitVisibleElement(sampleHeading);
        LoggerUtility.infoLog("The user waits for the element inside the first iframe");

        System.out.println(sampleHeading.getText());
        LoggerUtility.infoLog("The user reads text inside the first iframe");

        frameMethods.switchToParentIframe();
        LoggerUtility.infoLog("The user switches back to the parent frame");
    }

    public void dealSecondIFrame() {
        frameMethods.switchToSpecificIframe("frame2");
        LoggerUtility.infoLog("The user switches to the second iframe");

        WebElement sampleHeading = driver.findElement(sampleHeadingLocator);
        elementMethods.waitVisibleElement(sampleHeading);
        LoggerUtility.infoLog("The user waits for the element inside the second iframe");

        System.out.println(sampleHeading.getText());
        LoggerUtility.infoLog("The user reads text inside the second iframe");

        frameMethods.switchToParentIframe();
        LoggerUtility.infoLog("The user switches back to the parent frame");
    }
}
