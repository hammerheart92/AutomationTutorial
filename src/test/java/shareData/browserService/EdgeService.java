package shareData.browserService;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

@Getter
public class EdgeService implements BrowserService {
    private WebDriver driver;

    @Override
    public void openBrowser() {
        EdgeOptions options = prepareOptions();
        driver = new EdgeDriver(options);

        // Retry wrapper for stability in CI
        int attempts = 0;
        while (attempts < 3) {
            try {
                driver.get("https://demoqa.com/");
                break;
            } catch (Exception e) {
                attempts++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public EdgeOptions prepareOptions() {
        boolean cicd = Boolean.parseBoolean(System.getProperty("cicd"));
        EdgeOptions options = new EdgeOptions();

        if (cicd) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        return options;
    }
}
