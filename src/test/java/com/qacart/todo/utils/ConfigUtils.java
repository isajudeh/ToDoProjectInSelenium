package com.qacart.todo.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
private Properties properties;
private static ConfigUtils configUtils;
    private ConfigUtils() throws IOException {
        String env = System.getProperty("env", "production");
        switch (env){
            case "production":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            case "local":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/local.properties");
                break;
            default:
                throw new RuntimeException("NO ENV");
        }

    }

    public static ConfigUtils getInstance() throws IOException {
        if(configUtils == null){
            configUtils = new ConfigUtils();
        }return configUtils;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        throw new RuntimeException("NO PROPERTY ");
    }

    public String getEmail(){
        String prop = properties.getProperty("email");
        if (prop != null) return prop;
        throw new RuntimeException("NO EMAIL ");
    }
    public String getPassword(){
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        throw new RuntimeException("NO PASSWORD ");
    }
}
