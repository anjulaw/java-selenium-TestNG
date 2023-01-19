package infra.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class MainConfig {

    private static Properties prop = readPropertiesFile();

    public static String baseUrl;
    public static int webDriverExplicitWaitInSeconds;

    public static BrowserType browserType;

    public static String hubUrl;
    public static void initMainConfig(){

        if (prop == null) {
            System.out.println("main properties file can't be read so parameters values can't be extracted...");
            return;
        }

        baseUrl = readValue("baseUrl");
        browserType = BrowserType.fromString(readValue("browserType"));
        webDriverExplicitWaitInSeconds = Integer.parseInt(readValue("webDriverExplicitWaitInSeconds"));
        hubUrl = readValue("hubUrl");
    }

    private static Properties readPropertiesFile(){
        try {
            Properties prop = new Properties();
            FileInputStream input;

            input = new FileInputStream("src/main/resources/config.properties");
            prop.load(input);
            input.close();

            return prop;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String readValue(String variableName) {
        Map<String, String> environmentVariablesMap = System.getenv();
        String environmentVariableValue = environmentVariablesMap.get(variableName);
        return  environmentVariableValue != null ? environmentVariableValue : prop.getProperty(variableName);
    }
}
