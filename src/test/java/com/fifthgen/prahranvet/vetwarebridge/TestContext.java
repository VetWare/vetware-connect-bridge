package com.fifthgen.prahranvet.vetwarebridge;

import com.fifthgen.prahranvet.vetwarebridge.utility.PropertyKey;
import com.fifthgen.prahranvet.vetwarebridge.utility.PropertyManager;

import java.io.IOException;
import java.util.logging.Logger;

public class TestContext {

    public PropertyManager propertyManager;

    public TestContext() {
        try {
            propertyManager = new PropertyManager();
        } catch (IOException e) {
            Logger.getGlobal().severe("Cannot create property manager.");
            System.exit(-1);
        }

        initPropertyManager();
    }

    private void initPropertyManager() {

        // General properties.
        if (propertyManager.getProperty(PropertyKey.CLIENT.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.CLIENT.getKey(), "VetWare");
        }
        if (propertyManager.getProperty(PropertyKey.PRACTICE_NAME.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.PRACTICE_NAME.getKey(), "Vet");
        }

        // Initialize sender preferences.
        if (propertyManager.getProperty(PropertyKey.NAME.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.NAME.getKey(), "Manager");
        }
        if (propertyManager.getProperty(PropertyKey.EMAIL.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.EMAIL.getKey(), "info@youremail.com");
        }

        // Initialize ship to preferences.
        if (propertyManager.getProperty(PropertyKey.STREET_ADDRESS.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.STREET_ADDRESS.getKey(), "");
        }
        if (propertyManager.getProperty(PropertyKey.SUBURB.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.SUBURB.getKey(), "");
        }
        if (propertyManager.getProperty(PropertyKey.STATE.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.STATE.getKey(), "");
        }
        if (propertyManager.getProperty(PropertyKey.POSTCODE.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.POSTCODE.getKey(), "");
        }
        if (propertyManager.getProperty(PropertyKey.COUNTRY.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.COUNTRY.getKey(), "");
        }

        // Initialize account properties.
        if (propertyManager.getProperty(PropertyKey.ACCOUNT_CODE.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.ACCOUNT_CODE.getKey(), "000563");
        }
        if (propertyManager.getProperty(PropertyKey.USER_ID.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.USER_ID.getKey(), "sample-user");
        }
        if (propertyManager.getProperty(PropertyKey.CLIENT_TOKEN.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.CLIENT_TOKEN.getKey(), "sample-client-token");
        }
        if (propertyManager.getProperty(PropertyKey.USER_TOKEN.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.USER_TOKEN.getKey(), "sample-user-token");
        }

        // Initialize API properties.
        if (propertyManager.getProperty(PropertyKey.API_URL.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.API_URL.getKey(), "https://google.com");
        }

        // Initialize application settings.
        if (propertyManager.getProperty(PropertyKey.PO_CNT.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.PO_CNT.getKey(), "0");
        }
    }
}
