package tests;

import configFiles.DataConfig;
import io.qameta.allure.*;
import modelObject.AlertModel;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.HomePage;
import shareData.Hooks;

@Epic("UI Test Automation")
@Feature("Alert Handling")
public class AlertTest extends Hooks {

    @Test(description = "Handle different types of browser alerts")
    @Story("The User interacts with browser alerts")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test navigates through the Alerts section of the app and handles multiple alert types: simple alert, timed alert, confirm alert, and prompt alert. It verifies alert interactions and user input handling.")
    public void testMethod() {

        AlertModel testData = new AlertModel(DataConfig.ALERT_DATA);

        Allure.step("Navigate to Alerts section");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickAlert();

        Allure.step("Handle all types of browser alerts");
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.dealAlertProcess(testData);
    }
}

