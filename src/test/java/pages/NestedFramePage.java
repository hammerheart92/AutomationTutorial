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
        frameMethods.switchToSpecificIframe(childIFrame);
        System.out.println(childSampleText.getText());
    }
}
