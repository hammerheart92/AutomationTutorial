package tests;

import configFiles.DataConfig;
import modelObject.TextBoxModel;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;
import shareData.Hooks;

public class TextBoxTest extends Hooks {

    @Test
    public void testMethod(){

        TextBoxModel testData = new TextBoxModel(DataConfig.TEXTBOX_DATA);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickTextBox();

        TextBoxPage textBoxPage = new TextBoxPage(getDriver());
        textBoxPage.fillTextBoxFieldsWithProvidedData(testData);
    }
}
