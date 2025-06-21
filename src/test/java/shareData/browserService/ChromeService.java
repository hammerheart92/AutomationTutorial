package shareData.browserService;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@Getter
public class ChromeService implements BrowserService{
    private WebDriver driver;

    @Override
    public void openBrowser() {
        ChromeOptions options = prepareOptions();
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public ChromeOptions prepareOptions() {
        boolean cicd = Boolean.parseBoolean(System.getProperty("cicd"));
        ChromeOptions options = new ChromeOptions();
        if (cicd) {
            options.addArguments("--headless=new"); // Run in headless mode for CI

            String tempProfileDir = "/tmp/chrome-profile-" + System.currentTimeMillis();
            options.addArguments("--user-data-dir=" + tempProfileDir);
        }
        options.addArguments("--no-sandbox"); // Required for GitHub Actions
        options.addArguments("--disable-dev-shm-usage"); // Prevents memory issues
        options.addArguments("--window-size=1920,1080"); // Set a default window size
        return options;
    }
}
