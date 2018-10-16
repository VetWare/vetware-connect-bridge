package com.fifthgen.prahranvet.vetwarebridge.utility;

import com.fifthgen.prahranvet.vetwarebridge.TestContext;
import com.fifthgen.prahranvet.vetwarebridge.data.model.Order;
import com.fifthgen.prahranvet.vetwarebridge.data.model.exception.InvalidFileException;
import com.fifthgen.prahranvet.vetwarebridge.data.model.exception.NonParsableFileException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.logging.Logger;

public class OrderManagerTest {

    public static final String TEST_ORDER_FILE = "DrugOrder.csv";

    private OrderManager orderParser;

    @Before
    public void setUp() {
        TestContext testContext = new TestContext();
        this.orderParser = new OrderManager(testContext.propertyManager);
    }

    @Test
    public void createOrder() {
        try {
            URL url = ClassLoader.getSystemResource(TEST_ORDER_FILE);
            Order order = orderParser.createOrder(url.getPath());
            Assert.assertNotNull(order);
        } catch (InvalidFileException | NonParsableFileException e) {
            Logger.getGlobal().severe("Couldn't parse the CSV file.");
        }
    }
}