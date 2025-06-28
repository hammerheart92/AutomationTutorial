package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.TabWindowPage;
import shareData.Hooks;

@Epic("UI Test Automation")
@Feature("Window and Tab Handling")
public class TabWindowsTest extends Hooks {

    @Test(description = "Open and close browser tabs and windows")
    @Story("Handle multiple browser tabs and windows")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test opens new tabs and windows, switches between them, and verifies proper cleanup of the tab/window.")
    public void testMethod() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickBrowserWindowsSubMenu();

        TabWindowPage tabWindowPage = new TabWindowPage(getDriver());
        tabWindowPage.dealTabProcess();
        tabWindowPage.dealWindowProcess();
//        tabWindowPage.dealWindowMessageProcess();
    }
}