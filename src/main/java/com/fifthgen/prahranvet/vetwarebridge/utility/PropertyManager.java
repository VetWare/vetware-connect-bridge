package com.fifthgen.prahranvet.vetwarebridge.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyManager {

    private final static String PROPERTY_FILE = "application.properties";
    private final Properties appProps;

    private String propertyFile;

    /**
     * Default constructor which loads the default property file or creates it if does not exist.
     *
     * @throws IOException In case there is an I/O failure.
     */
    public PropertyManager() throws IOException {
        this(PROPERTY_FILE);
    }

    public PropertyManager(String propertyFile) throws IOException {
        File file = new File(propertyFile);

        // If file does not exist, create the file.
        if (file.createNewFile())
            Logger.getGlobal().info("Property file created.");

        appProps = new Properties();

        this.propertyFile = propertyFile;
    }

    /**
     * Get a property value from the property file.
     *
     * @param key Property key.
     * @return Property value as String.
     */
    public String getProperty(String key) {
        readFromFile();
        return this.appProps.getProperty(key);
    }

    /**
     * Set a property value into the properties file.
     *
     * @param key   Property key.
     * @param value Property value.
     */
    public void setProperty(String key, String value) {
        this.appProps.setProperty(key, value);
        writeToFile();
    }

    private synchronized void readFromFile() {
        File file = new File(propertyFile);

        try (FileInputStream fis = new FileInputStream(file)) {
            appProps.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void writeToFile() {
        File file = new File(propertyFile);

        try (FileWriter fo = new FileWriter(file)) {
            appProps.store(fo, "Auto generated file. Do not change.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
