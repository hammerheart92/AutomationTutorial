package tests;

import configFiles.DataConfig;
import io.qameta.allure.*;
import modelObject.WebTableModel;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import shareData.Hooks;

public class WebTableTest extends Hooks {
    @Epic("UI Test Automation")
    @Feature("WebTable form Handling")

    @Test(description = "Perform Create, Edit, and Delete operations on Web Table")
    @Story("Manage Web Table entries through UI")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test performs a full cycle of actions on a web table: creating a new row, editing the inserted values, " +
            "and deleting the row while validating changes at each step.")
    public void testMethod() {

        WebTableModel testData = new WebTableModel(DataConfig.WEBTABLE_DATA);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.createProcess(testData, 3);

        webTablePage.editProcess(testData, 3);
        webTablePage.deleteProcess(3);
    }
}
