package org.example.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogUtil {
    private static Logger logger;
    private static FileHandler fileHandler;

    static {
        try {
            logger = Logger.getLogger("TestResultsLogger");
            fileHandler = new FileHandler("test-output/test_results.log", true); // Append to file
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarning(String message) {
        logger.warning(message);
    }

    public static void logError(String message) {
        logger.severe(message);
    }

    public static void close() {
        if (fileHandler != null) {
            fileHandler.close();
        }
    }
}
