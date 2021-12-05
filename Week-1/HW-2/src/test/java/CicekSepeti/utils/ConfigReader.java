package CicekSepeti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
https://stackoverflow.com/questions/16273174/how-to-read-a-configuration-file-in-java
https://medium.com/@sonaldwivedi/how-to-read-config-properties-file-in-java-6a501dc96b25
*/

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