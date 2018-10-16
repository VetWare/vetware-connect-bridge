package com.fifthgen.prahranvet.vetwarebridge.data;

import com.fifthgen.prahranvet.vetwarebridge.TestContext;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.GetOrderCallback;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.GetOrdersCallback;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.PostOrderCallback;
import com.fifthgen.prahranvet.vetwarebridge.data.model.Order;
import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderPlaced;
import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderSummary;
import com.fifthgen.prahranvet.vetwarebridge.data.model.exception.InvalidFileException;
import com.fifthgen.prahranvet.vetwarebridge.data.model.exception.NonParsableFileException;
import com.fifthgen.prahranvet.vetwarebridge.utility.OrderManager;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.logging.Logger;

import static com.fifthgen.prahranvet.vetwarebridge.utility.OrderManagerTest.TEST_ORDER_FILE;

public class ConnectAPITest {

    private static final int ORDER_ID = 1039;

    private ConnectAPI connectAPI;
    private Order order;

    @Before
    public void setUp() {
        TestContext testContext = new TestContext();
        URL url = ClassLoader.getSystemResource(TEST_ORDER_FILE);
        OrderManager om = new OrderManager(testContext.propertyManager);

        try {
            this.order = om.createOrder(url.getPath());
            this.connectAPI = new ConnectAPI(testContext.propertyManager);
        } catch (InvalidFileException | NonParsableFileException e) {
            Logger.getGlobal().severe("Couldn't parse the CSV file.");
        }
    }

    @Test
    public void getOrders() {
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
    public void getOrder() {
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

    @Test
    public void postOrder() {
        this.connectAPI.postOrder(order, new PostOrderCallback() {
            @Override
            public void onCompleted(OrderPlaced orderPlaced) {
                System.out.println(orderPlaced);
            }

            @Override
            public void onFailed(Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        });
    }
}