package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class TabMethods {
    public WebDriver driver;

    public void switchSpecificTab(int index){
        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(index));
    }

    public void closeCurrentTab(){
        driver.close();
    }

}
