package com.automationexercise.propertyreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static volatile PropertyReader propInstance;


    private PropertyReader() {

    }

    public static synchronized PropertyReader getInstance() {
        if (propInstance == null) {
            propInstance = new PropertyReader();
        }
        return propInstance;
    }


    public String getProperty(String propertyName) {
        Properties prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/propertiesfile/config.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }

        } catch (IOException e) {
            System.out.println("Property not found.");
        }
        return null;

    }

}
