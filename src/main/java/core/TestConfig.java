package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {

    private static String resources = "src/main/resources/";
    private static String appBaseURL = "appBaseURL";
    private static String browser = "browser";
    private static String env = "env";
    private static String testDataPath = resources + "testdata";
    private static File resourcesDirectory = new File(resources + "config");
    private static Properties properties;

    public static void load(String environment) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(resourcesDirectory + "/config." + environment + ".properties"));
    }

    public static String getAppBaseURL(){
        return getProperty(appBaseURL);
    }

    public static String getBrowser(){
        return getProperty(browser);
    }

    public static String getEnv(){
        return getProperty(env);
    }

    public static String getTestDataPath(){
        return testDataPath;
    }

    public static String getProperty(String key) {
        if(properties.containsKey(key)) {
            return properties.getProperty(key);
        }
        return null;
    }

    public static void addProperty(String property, String value) {
        if(!properties.equals(null)) {
            properties.setProperty(property, value);
        }
    }
}
