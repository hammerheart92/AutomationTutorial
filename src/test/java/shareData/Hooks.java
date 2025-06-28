package shareData;

import io.qameta.allure.testng.AllureTestNg;
import loggerUtility.LoggerUtility;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(AllureTestNg.class)
public class Hooks extends ShareData {

    private String testClassName;

    @BeforeClass
    public void prepareEnvironment() {
        testClassName = this.getClass().getSimpleName();
        setUpDriver();
        LoggerUtility.startTest(testClassName);
    }

    @AfterClass
    public void clearEnvironment() {
        quitDriver();
        LoggerUtility.finishtTest(testClassName);
    }
}
