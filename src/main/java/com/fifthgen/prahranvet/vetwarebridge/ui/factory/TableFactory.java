package com.fifthgen.prahranvet.vetwarebridge.ui.factory;

import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderSummary;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableFactory {

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Return a new <code>{@link TableView}</code> cell with formatted date, for the given table column.
     *
     * @param column <code>{@link TableColumn}</code> to be formatted.
     * @return The new <code>{@link TableCell}</code> with formatted date.
     */
    public static TableCell<OrderSummary, Date> dateCell(TableColumn<OrderSummary, Date> column) {
        return new TableCell<OrderSummary, Date>() {

            @Override
            protected void updateItem(Date item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(DATE_FORMAT.format(item));
                }
            }
        };
    }
}
