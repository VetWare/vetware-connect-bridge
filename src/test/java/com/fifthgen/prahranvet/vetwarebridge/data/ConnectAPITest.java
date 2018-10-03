package com.fifthgen.prahranvet.vetwarebridge.data;

import com.fifthgen.prahranvet.vetwarebridge.TestContext;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.GetOrdersCallback;
import org.apache.http.HttpResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class ConnectAPITest {

    private TestContext testContext;
    private ConnectAPI connectAPI;

    @Before
    public void setUp() {
        this.testContext = new TestContext();
        this.connectAPI = new ConnectAPI(testContext.propertyManager);
    }

    @Test
    public void getTest() {
        this.connectAPI.get(ConnectAPI.ORDERS, new GetOrdersCallback() {

            @Override
            public void onCompleted(HttpResponse response) {
                Logger.getGlobal().info("GET Completed!");
            }

            @Override
            public void onFailed(Exception e) {
                Logger.getGlobal().info("GET Failed!");
            }

            @Override
            public void onCancelled() {
                Logger.getGlobal().info("GET Completed!");
            }
        });
    }

    @Test
    public void postTest() throws UnsupportedEncodingException {
        this.connectAPI.post(ConnectAPI.ORDERS, null, new GetOrdersCallback() {

            @Override
            public void onCompleted(HttpResponse response) {
                Logger.getGlobal().info("POST Completed!");
            }

            @Override
            public void onFailed(Exception e) {
                Logger.getGlobal().info("POST Failed!");
            }

            @Override
            public void onCancelled() {
                Logger.getGlobal().info("POST Completed!");
            }
        });
    }
}