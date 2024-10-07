package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.NestedFramePage;
import shareData.ShareData;

public class NestedFramesTest extends ShareData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickNestedFramesSubMenu();

        NestedFramePage nestedFramePage = new NestedFramePage(getDriver());
        nestedFramePage.dealNestedFrame();

    }
}