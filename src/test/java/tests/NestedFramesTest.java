package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.NestedFramePage;
import shareData.Hooks;

@Epic("UI Test Automation")
@Feature("NestedFrames handling")
public class NestedFramesTest extends Hooks {

    @Test(description = "Validate proper navigation and content verification within parent and child nested iframes on the Frames page")
    @Story("Verify NestedFrames handling")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test navigates to the Nested Frames section, switches to a parent and child iframe," +
            " and validates the presence of expected content within both frames.")
    public void testMethod() {

        Allure.step("Navigate to Alerts, Frame & Windows section");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        Allure.step("Click on Nested Frames sub-menu");
        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickNestedFramesSubMenu();

        NestedFramePage nestedFramePage = new NestedFramePage(getDriver());
        nestedFramePage.dealNestedFrame();
    }
}