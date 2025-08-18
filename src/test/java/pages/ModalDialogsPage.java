package pages;

import io.qameta.allure.Step;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalDialogsPage extends BasePage {

    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "showSmallModal")
    private WebElement smallModalWindowPopUp;
    @FindBy(id = "showLargeModal")
    private WebElement largeModalWindowPopUp;
    @FindBy(css = "div.modal-dialog.modal-sm .modal-body")
    private WebElement smallModalBody;
    @FindBy(css = "div.modal-dialog.modal-lg .modal-body")
    private WebElement largeModalBody;
    @FindBy(id = "closeSmallModal")
    private WebElement closeSmallModal;
    @FindBy(id = "closeLargeModal")
    private WebElement closeLargeModal;

    public void clickSmallModal(){
        elementMethods.clickJSElement(smallModalWindowPopUp);
        LoggerUtility.infoLog("the user clicks on Small modal Button");
    }

    public void clickLargeModal(){
        elementMethods.clickJSElement(largeModalWindowPopUp);
        LoggerUtility.infoLog("the user clicks on Large modal Button");
    }

    public void clickCloseSmallModal(){
        elementMethods.clickJSElement(closeSmallModal);
        LoggerUtility.infoLog("the user closes the Small modal");
    }

    public void clickCloseLargeModal(){
        elementMethods.clickJSElement(closeLargeModal);
        LoggerUtility.infoLog("the user closes the Large modal");
    }

    @Step("Open small modal, read its text, then close it")
    public String openSmallModalAndGetText() {
        clickSmallModal();                          // open
        elementMethods.waitVisibleElement(smallModalBody);
        String text = smallModalBody.getText().trim();
        LoggerUtility.infoLog("Small modal text: " + text);
        clickCloseSmallModal();                     // close
        return text;
    }

    @Step("open large modal, read text, then close it")
    public String openLargeModalAndGetText() {
        clickLargeModal();                          // open
        elementMethods.waitVisibleElement(largeModalBody);
        String text = largeModalBody.getText().trim();
        LoggerUtility.infoLog("Large modal text: " + text);
        clickCloseLargeModal();                     // close
        return text;
    }
}
