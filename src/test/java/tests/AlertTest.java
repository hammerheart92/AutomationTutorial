package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.HomePage;
import shareData.ShareData;

public class AlertTest extends ShareData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickAlert();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.dealAlertProcess("Tsunami Alert");

    }
}

