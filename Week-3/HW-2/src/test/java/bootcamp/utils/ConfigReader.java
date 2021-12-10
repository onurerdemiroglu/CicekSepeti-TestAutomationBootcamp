package bootcamp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    static {
        try {
            String fileName = "app.config";
            FileInputStream config = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(config);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException exx) {
            exx.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return prop.getProperty(keyName);
    }
}