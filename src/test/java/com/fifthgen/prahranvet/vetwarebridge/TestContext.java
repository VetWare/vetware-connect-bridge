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
    }
}
