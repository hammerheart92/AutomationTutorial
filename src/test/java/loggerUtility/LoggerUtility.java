package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private Logger logger = LogManager.getLogger();

    //metoda care indica inceperea testului
    public void startTest(String testName){
        logger.info("*********** EXECUTION STARTED: " + testName + "***********");
    }
    //metoda care logheaza un info
    public void infoLog(String message){
        logger.info(message);

    }
    //metoda care logheaza un error
    public void errorLog(String message){
        logger.error(message);

    }
    //metoda care indica sfrasitul testului
    public void finishtTest(String testName){
        logger.info("*********** EXECUTION FINISHED: " + testName + "***********");
    }
}
