package shareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {

    public WebDriver driver;

    @BeforeMethod
    public void setUpEnvironment(){

        //Deschidem un browser
        driver = new ChromeDriver();
        //Accesam un url
        driver.get("https://demoqa.com/");
        //Facem browserul maximize
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void clearEnvironment(){
        driver.quit();

    }
}
