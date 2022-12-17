package com.solvd.gui.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Configuration {
    private static final Map<String, String> props = readProperties("config.properties");

    private static Map<String, String> readProperties(String fileName) {
        Map<String, String> props = new HashMap<>();
        try {
            InputStream inputStream = Files.newInputStream(Paths.get("src/main/resources/config.properties"));
            Properties properties = new Properties();
            properties.load(inputStream);
            for (Object key : properties.keySet()) {
                props.put((String) key, properties.getProperty((String) key));
            }
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }

    public static String getProperty(String key) {
        return props.get(key);
    }
}
