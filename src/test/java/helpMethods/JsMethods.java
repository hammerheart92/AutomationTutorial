package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
@AllArgsConstructor

public class JsMethods {

    private WebDriver driver;

    public void hideAllBlockingAds() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Hide all iframes (ads or others)
        js.executeScript("document.querySelectorAll('iframe').forEach(e => e.style.display='none');");

        // Hide containers like demoqa ad wrappers
        js.executeScript("document.querySelectorAll('div[id*=\"__container__\"]').forEach(e => e.style.display='none');");

        // Hide Google ad iframes specifically
        js.executeScript("document.querySelectorAll('[id*=\"google_ads_iframe_\"]').forEach(e => e.style.display='none');");
    }
}
