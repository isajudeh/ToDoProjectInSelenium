package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties loadProperties(String path) throws IOException {

        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        return properties;
    }
}
