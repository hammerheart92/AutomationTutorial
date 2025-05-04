package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.NestedFramePage;
import shareData.Hooks;

public class NestedFramesTest extends Hooks {

    @Test
    public void testMethod() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickNestedFramesSubMenu();

        NestedFramePage nestedFramePage = new NestedFramePage(getDriver());
        nestedFramePage.dealNestedFrame();

    }
}