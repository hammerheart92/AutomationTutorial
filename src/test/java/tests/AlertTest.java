package tests;

import configFiles.DataConfig;
import modelObject.AlertModel;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.HomePage;
import shareData.Hooks;

public class AlertTest extends Hooks {

    @Test
    public void metodaTest() {

        AlertModel testData = new AlertModel(DataConfig.ALERT_DATA);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickAlert();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.dealAlertProcess(testData);

    }
}

