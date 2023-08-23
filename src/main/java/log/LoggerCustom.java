package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.util.logging.Logger.getLogger;

public class LoggerCustom {
    Logger logger = getLogger("MyLog");
    public LoggerCustom() {

            FileHandler fh;
            try {
                fh = new FileHandler("/Users/huseyineraslan/IdeaProjects/BankApplication/src/main/java/org/example/log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
                logger.info("My first log");
            }
            catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void log(String msg){
        logger.info(msg);
    }

}
