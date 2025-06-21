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
            // Use Chromium explicitly for GitHub Actions
            options.setBinary("/usr/bin/chromium-browser");

            // More stable headless config
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-software-rasterizer");
            options.addArguments("--remote-debugging-port=9222");

            // Optional: Create isolated user profile if needed
            String tempProfileDir = "/tmp/chrome-profile-" + System.currentTimeMillis();
            options.addArguments("--user-data-dir=" + tempProfileDir);
        }

        // Shared settings (for both local and CI)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        return options;
    }
}
