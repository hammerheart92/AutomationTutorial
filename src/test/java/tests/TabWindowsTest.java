package tests;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.TabWindowPage;
import shareData.ShareData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TabWindowsTest extends ShareData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.clickBrowserWindowsSubMenu();

        TabWindowPage tabWindowPage = new TabWindowPage(driver);
        tabWindowPage.dealTabProcess();
        tabWindowPage.dealWindowProcess();

    }
}