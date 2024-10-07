package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.TabWindowPage;
import shareData.ShareData;

public class TabWindowsTest extends ShareData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickBrowserWindowsSubMenu();

        TabWindowPage tabWindowPage = new TabWindowPage(getDriver());
        tabWindowPage.dealTabProcess();
        tabWindowPage.dealWindowProcess();

    }
}