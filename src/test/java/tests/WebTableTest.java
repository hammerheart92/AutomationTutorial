package tests;

import configFiles.DataConfig;
import modelObject.WebTableModel;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import shareData.Hooks;

public class WebTableTest extends Hooks {

    @Test
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
