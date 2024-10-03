package tests;


import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.FramesPage;
import pages.HomePage;
import shareData.ShareData;

import java.time.Duration;

public class FrameTest extends ShareData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.clickFramesSubMenu();

        FramesPage framesPage = new FramesPage(driver);
        framesPage.dealFirstIFrame();
        framesPage.dealSecondIFrame();

    }

}
