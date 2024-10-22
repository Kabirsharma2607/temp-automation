package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String getString(String key) {
        Properties prop = new Properties();

        String value = "";

        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);

            value = prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return value.isEmpty() ? "" : value;
    }
}
