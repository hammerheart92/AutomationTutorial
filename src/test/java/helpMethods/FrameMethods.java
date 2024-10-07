package helpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {

    public WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificIframe(String value){
        driver.switchTo().frame(value);
    }

    public void switchToParentIframe(){
        driver.switchTo().parentFrame();
    }
    public void switchToSpecificIframe(WebElement element){
        driver.switchTo().frame(element);

    }
}
