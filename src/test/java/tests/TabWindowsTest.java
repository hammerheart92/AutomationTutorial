package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.TabWindowPage;
import shareData.Hooks;

public class TabWindowsTest extends Hooks {

    @Test
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