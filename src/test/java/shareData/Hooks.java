package shareData;

import loggerUtility.LoggerUtility;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
