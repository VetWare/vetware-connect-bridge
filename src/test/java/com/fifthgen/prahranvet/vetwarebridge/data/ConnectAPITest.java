package com.fifthgen.prahranvet.vetwarebridge.data;

import com.fifthgen.prahranvet.vetwarebridge.TestContext;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.GetOrderCallback;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.GetOrdersCallback;
import com.fifthgen.prahranvet.vetwarebridge.data.model.Order;
import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderSummary;
import org.junit.Before;
import org.junit.Test;

public class ConnectAPITest {

    private static final int ORDER_ID = 1039;

    private ConnectAPI connectAPI;

    @Before
    public void setUp() {
        TestContext testContext = new TestContext();
        this.connectAPI = new ConnectAPI(testContext.propertyManager);
    }

    @Test
    public void getOrdersTest() {
        this.connectAPI.getOrders(new GetOrdersCallback() {
            @Override
            public void onCompleted(OrderSummary[] orderSummaries) {
                for (OrderSummary summary : orderSummaries)
                    System.out.println(summary);
            }

            @Override
            public void onFailed(Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        });
    }

    @Test
    public void getOrderTest() {
        this.connectAPI.getOrder(ORDER_ID, new GetOrderCallback() {
            @Override
            public void onCompleted(Order order) {
                System.out.println(order);
            }

            @Override
            public void onFailed(Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        });
    }
}