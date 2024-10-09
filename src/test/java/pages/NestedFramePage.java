package pages;

import org.openqa.selenium.By;
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

    public void dealNestedFrame(){
        frameMethods.switchToSpecificIframe("frame1");
        loggerUtility.infoLog("the user switches to a specific parent Iframe ");
        frameMethods.switchToSpecificIframe(childIFrame);
        loggerUtility.infoLog("the user switches to a specific child Iframe ");
        System.out.println(childSampleText.getText());
        loggerUtility.infoLog("the user interacts with an element within Iframe ");
    }
}
