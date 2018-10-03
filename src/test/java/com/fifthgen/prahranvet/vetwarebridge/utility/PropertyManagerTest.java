package com.fifthgen.prahranvet.vetwarebridge.utility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class PropertyManagerTest {

    private final static String KEY = "user-id";
    private final static String ORIGINAL_VALUE = "test-user-00001";
    private final static String NEW_VALUE = "test-user-00002";

    private PropertyManager pm;

    @Before
    public void setUp() {
        try {
            pm = new PropertyManager();
            pm.setProperty(KEY, ORIGINAL_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initPropertyManagerTest() {
        Assert.assertNotNull(pm);
    }

    @Test
    public void getPropertyTest() {
        Assert.assertEquals(pm.getProperty(KEY), ORIGINAL_VALUE);
    }

    @Test
    public void setPropertyTest() {
        pm.setProperty(KEY, NEW_VALUE);
        Assert.assertEquals(pm.getProperty(KEY), NEW_VALUE);
    }
}