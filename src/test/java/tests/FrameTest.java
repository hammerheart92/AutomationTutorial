package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.FramesPage;
import pages.HomePage;
import shareData.Hooks;

@Epic("DemoQA Tests")
@Feature("Frames handling")
public class FrameTest extends Hooks {

    @Test(description = "Validate switching between multiple frames")
    @Story("Verify Frames Handling")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test validates switching between two iframes and reads content.")
    public void testMethod() {
        Allure.step("Navigate to Alerts, Frame & Windows section");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        Allure.step("Click on frames sub-menu");
        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickFramesSubMenu();

        Allure.step("Switch to first iframe and validate content");
        FramesPage framesPage = new FramesPage(getDriver());
        framesPage.dealFirstIFrame();

        Allure.step("Switch to second iframe and validate content");
        framesPage.dealSecondIFrame();
    }
}
