package libraries;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getConfigValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//config//config.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public static void putConfigValue(String key, String value) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//config//config.properties");
        prop.load(fis);
        fis.close();
        prop.setProperty(key, value);
        FileWriter fout = new FileWriter(System.getProperty("user.dir") + "//config//config.properties");
        prop.store(fout, null);
        fout.close();
    }
}
