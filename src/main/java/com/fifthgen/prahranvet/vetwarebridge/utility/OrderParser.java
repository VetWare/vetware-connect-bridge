package com.fifthgen.prahranvet.vetwarebridge.utility;

import com.fifthgen.prahranvet.vetwarebridge.data.model.Order;
import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderLine;
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

public class OrderParser {

    private static final int EXP_COL_CNT = 4;

    public static void createOrder(String fileName) throws InvalidFileException, NonParsableFileException {
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

        Order order = new Order();
        order.setPurchaseOrderNumber("GEN");

    }
}
