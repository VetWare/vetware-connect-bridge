package com.fifthgen.prahranvet.vetwarebridge.utility;

import com.fifthgen.prahranvet.vetwarebridge.TestContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConnectionManagerTest {

    private TestContext testContext;
    private ConnectionManager connectionManager;

    @Before
    public void setUp() {
        this.testContext = new TestContext();
        this.connectionManager = new ConnectionManager(testContext.propertyManager);
    }

    @Test
    public void checkConnection() {
        Assert.assertTrue(connectionManager.checkConnection());
    }
}