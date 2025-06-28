package tests;

import configFiles.DataConfig;
import io.qameta.allure.*;
import modelObject.TextBoxModel;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;
import shareData.Hooks;

public class TextBoxTest extends Hooks {
    @Epic("UI Test Automation")
    @Feature("TextBox Form Handling")

    @Test(description = "User fills and submits TextBox form")
    @Story("User provides personal information in a form")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test fills in the text box fields (name, email, address) and submits the form, then validates that the inputs are shown correctly.")
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
