package configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static String getEnvironment() {
        return System.getProperty("env");
    }

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            InputStream input = Configuration.class.getClassLoader().getResourceAsStream(String.format("dev.properties", getEnvironment()));
            if (input == null) {
                System.out.println("Cannot find file");
            }
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getUrl() {
        return getProperties().getProperty("url");
    }
}