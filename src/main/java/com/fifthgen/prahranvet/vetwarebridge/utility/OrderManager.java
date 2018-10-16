package com.fifthgen.prahranvet.vetwarebridge.utility;

import com.fifthgen.prahranvet.vetwarebridge.data.model.Address;
import com.fifthgen.prahranvet.vetwarebridge.data.model.Order;
import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderLine;
import com.fifthgen.prahranvet.vetwarebridge.data.model.Sender;
import com.fifthgen.prahranvet.vetwarebridge.data.model.exception.InvalidFileException;
import com.fifthgen.prahranvet.vetwarebridge.data.model.exception.NonParsableFileException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private static final int EXP_COL_CNT = 4;
    private static final int PO_NUM_DIGITS = 8;
    private static final String PO_PREFIX = "PO";

    private PropertyManager propertyManager;

    private String accountCode;
    private String name;
    private String email;
    private String addressLine1;
    private String suburb;
    private String state;
    private int postcode;
    private String country;

    private int poCnt;

    public OrderManager(PropertyManager propertyManager) {
        this.propertyManager = propertyManager;

        this.accountCode = propertyManager.getProperty(PropertyKey.ACCOUNT_CODE.getKey());
        this.name = propertyManager.getProperty(PropertyKey.NAME.getKey());
        this.email = propertyManager.getProperty(PropertyKey.EMAIL.getKey());

        this.addressLine1 = propertyManager.getProperty(PropertyKey.STREET_ADDRESS.getKey());
        this.suburb = propertyManager.getProperty(PropertyKey.SUBURB.getKey());
        this.state = propertyManager.getProperty(PropertyKey.STATE.getKey());
        this.postcode = Integer.parseInt(propertyManager.getProperty(PropertyKey.POSTCODE.getKey()));
        this.country = propertyManager.getProperty(PropertyKey.COUNTRY.getKey());

        this.poCnt = Integer.parseInt(propertyManager.getProperty(PropertyKey.PO_CNT.getKey()));
    }

    /**
     * Create an order object from the given CSV file. Only the line information is generated from the CSV file.
     * Other information is retrieved from the application.properties file.
     *
     * @param fileName Name of the CSV order file to be processed,
     * @return Generated order object if successful.
     * @throws InvalidFileException     If CSV file is not a valid order file.
     * @throws NonParsableFileException If the file cannot be parsed by the CSV parser.
     */
    public Order createOrder(String fileName) throws InvalidFileException, NonParsableFileException {
        List<OrderLine> orderLines = new ArrayList<>();

        try (CSVParser parser = new CSVParser(Files.newBufferedReader(Paths.get(fileName)), CSVFormat.DEFAULT)) {
            for (CSVRecord record : parser) {
                // Check whether the column count is valid. If the number of columns is not equal to the expected
                // column count, it is likely that the file is invalid.
                if (record.size() == EXP_COL_CNT) {
                    String productCode = record.get(0);
                    int qty = Integer.parseInt(record.get(1));
                    String outer = record.get(3);

                    // Fill the required details.
                    OrderLine orderLine = new OrderLine();
                    orderLine.setProductCode(productCode);
                    orderLine.setQuantity(qty);
                    orderLine.setNotes(outer);

                    // Add to the order line collection.
                    orderLines.add(orderLine);
                } else {
                    throw new InvalidFileException();
                }
            }
        } catch (IOException e) {
            throw new NonParsableFileException(e);
        }

        Sender sender = new Sender();
        sender.setAccountCode(this.accountCode);
        sender.setName(this.name);
        sender.setEmail(this.email);

        Address shipTo = new Address();
        shipTo.setAddressLine1(this.addressLine1);
        shipTo.setSuburb(this.suburb);
        shipTo.setState(this.state);
        shipTo.setPostcode(this.postcode);
        shipTo.setCountry(this.country);

        Order order = new Order();

        order.setPurchaseOrderNumber(generatePONumber(true));
        order.setSender(sender);
        order.setShipTo(shipTo);
        order.setOrderLines(orderLines.toArray(new OrderLine[0]));

        return order;
    }

    /**
     * Generates the purchase order number with auto incrementing support.
     *
     * @param autoIncrement Whether to autoincrement the next purchase order.
     * @return The PO number string.
     */
    private String generatePONumber(boolean autoIncrement) {
        String num = Integer.toString(++poCnt);

        while (num.length() < PO_NUM_DIGITS) {
            num = '0' + num;
        }

        if (autoIncrement) propertyManager.setProperty(PropertyKey.PO_CNT.getKey(), Integer.toString(poCnt));

        return PO_PREFIX + num;
    }
}
