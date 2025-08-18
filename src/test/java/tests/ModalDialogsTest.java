package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.ModalDialogsPage;
import shareData.Hooks;

@Epic("UI Test Automation")                 //Big project name
@Feature("Modal Dialog")                    //What area of the app.
public class ModalDialogsTest extends Hooks {

    @Test(description = "Open small and large modals and verify their text")
    @Story("User interacts with small and large modal dialogs")
    @Severity(SeverityLevel.NORMAL)         // How critical this is
    @Description("Navigate to Modal Dialogs page, open both small and large modal, " + "and check that the displayed messages match expectations.")
    public void testMethod(){

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickModalDialogSubMenu();

        ModalDialogsPage modalDialogsPage = new ModalDialogsPage(getDriver());
        modalDialogsPage.clickSmallModal();
        modalDialogsPage.clickLargeModal();
        modalDialogsPage.clickCloseSmallModal();
        modalDialogsPage.clickCloseLargeModal();

        ModalDialogsPage modal = new ModalDialogsPage(getDriver());

        Allure.step("Verify small modal text");
        String smallText = modal.openSmallModalAndGetText();
        Assert.assertEquals(smallText,
                "This is a small modal. It has very less content",
                "Small modal should show its short message");

        Allure.step("Verify large modal text");
        String largeText = modal.openLargeModalAndGetText();
        Assert.assertTrue(largeText.startsWith("Lorem Ipsum"),
                "Large modal should start with Lorem Ipsum");
    }
}
