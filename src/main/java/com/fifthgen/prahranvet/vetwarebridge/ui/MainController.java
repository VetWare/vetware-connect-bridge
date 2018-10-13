package com.fifthgen.prahranvet.vetwarebridge.ui;

import com.fifthgen.prahranvet.vetwarebridge.Application;
import com.fifthgen.prahranvet.vetwarebridge.data.ConnectAPI;
import com.fifthgen.prahranvet.vetwarebridge.data.callback.GetOrdersCallback;
import com.fifthgen.prahranvet.vetwarebridge.data.model.OrderSummary;
import com.fifthgen.prahranvet.vetwarebridge.ui.factory.TableFactory;
import com.fifthgen.prahranvet.vetwarebridge.utility.ConnectionManager;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MainController implements Initializable {

    private static final int EXECUTOR_DELAY = 10;
    private static final int ORDER_UPDATE_DELAY = 30;

    public Stage stage;
    @FXML
    private TableView<OrderSummary> orderSummaryTable;
    @FXML
    private Label errorLabel;
    @FXML
    private Label netStatLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(2);
        exec.scheduleAtFixedRate(new NetStatUpdater(), 0, EXECUTOR_DELAY, TimeUnit.SECONDS);
        exec.scheduleAtFixedRate(new OrderSummaryUpdater(), 0, ORDER_UPDATE_DELAY, TimeUnit.SECONDS);
    }

    @FXML
    private void onOpenAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Order File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Order Files", "*.csv"),
                new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            //stage.display(selectedFile);
        }
    }

    @FXML
    private void onPrefAction() throws Exception {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/Preferences.fxml"));

        // Load and getOrders the preference controller.
        Parent root = loader.load();
        PreferencesController controller = loader.getController();

        Stage prefStage = new Stage();

        // Set stage.
        controller.stage = prefStage;

        prefStage.setScene(new Scene(root));
        prefStage.initOwner(stage.getOwner());
        prefStage.setResizable(false);
        prefStage.initModality(Modality.APPLICATION_MODAL);
        prefStage.initStyle(StageStyle.UNIFIED);
        prefStage.show();
    }

    private void viewOrder(int orderId) {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/Order.fxml"));

        try {
            // Load and getOrders the preference controller.
            Parent root = loader.load();
            OrderController controller = loader.getController();

            Stage orderStage = new Stage();

            // Set stage.
            controller.stage = orderStage;

            // Set order id.
            controller.orderId = orderId;

            orderStage.setScene(new Scene(root));
            orderStage.initOwner(stage.getOwner());
            orderStage.setResizable(false);
            orderStage.initModality(Modality.APPLICATION_MODAL);
            orderStage.initStyle(StageStyle.UNIFIED);
            orderStage.show();
        } catch (IOException e) {
            Logger.getGlobal().severe("Couldn't load FXML file: " + e.getLocalizedMessage());
        }
    }

    @FXML
    private void onExitAction() {
        System.exit(0);
    }

    @FXML
    private void onRefreshAction() {
        new Thread(new OrderSummaryUpdater()).start();
    }

    private class OrderSummaryUpdater implements Runnable {
        @Override
        public void run() {
            ConnectAPI api = new ConnectAPI(Application.propertyManager);
            api.getOrders(new GetOrdersCallback() {

                /**
                 * Return the table row handler for the <b>order summary</b> table.
                 *
                 * @param tableView <code>{@link TableView}</code>
                 * @return <code>{@link TableRow}</code> object with implemented handles.
                 */
                private TableRow<OrderSummary> orderSummaryRow(TableView<OrderSummary> tableView) {
                    TableRow<OrderSummary> row = new TableRow<>();
                    row.setOnMouseClicked(event -> {
                        if (!row.isEmpty())
                            if (event.getClickCount() == 2) {
                                OrderSummary summary = row.getItem();
                                viewOrder(summary.getOrderId());
                            }
                    });

                    return row;
                }

                @Override
                public void onCompleted(OrderSummary[] orderSummaries) {
                    ObservableList<OrderSummary> data = FXCollections.observableArrayList(orderSummaries);

                    // Generate the necessary columns.
                    TableColumn<OrderSummary, Integer> orderId = new TableColumn<>("Order Id");
                    orderId.getStyleClass().add("table-cell-center");
                    orderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));

                    TableColumn<OrderSummary, Date> date = new TableColumn<>("Order Date");
                    date.getStyleClass().add("table-cell-center");
                    date.setCellValueFactory(new PropertyValueFactory<>("date"));
                    date.setCellFactory(TableFactory::dateCell);

                    TableColumn<OrderSummary, String> purchaseOrderNumber = new TableColumn<>("PO Number");
                    purchaseOrderNumber.getStyleClass().add("table-cell-center");
                    purchaseOrderNumber.setCellValueFactory(new PropertyValueFactory<>("purchaseOrderNumber"));

                    TableColumn<OrderSummary, String> status = new TableColumn<>("Status");
                    status.getStyleClass().add("table-cell-center");
                    status.setCellValueFactory(new PropertyValueFactory<>("status"));

                    TableColumn<OrderSummary, Date> updatedOn = new TableColumn<>("Updated On");
                    updatedOn.getStyleClass().add("table-cell-center");
                    updatedOn.setCellValueFactory(new PropertyValueFactory<>("updatedOn"));
                    updatedOn.setCellFactory(TableFactory::dateCell);

                    // Update table data on UI thread.
                    Platform.runLater(() -> {
                        orderSummaryTable.getColumns().clear();
                        orderSummaryTable.getColumns().add(orderId);
                        orderSummaryTable.getColumns().add(date);
                        orderSummaryTable.getColumns().add(purchaseOrderNumber);
                        orderSummaryTable.getColumns().add(status);
                        orderSummaryTable.getColumns().add(updatedOn);
                        orderSummaryTable.setRowFactory(this::orderSummaryRow);

                        orderSummaryTable.setItems(data);

                        errorLabel.setText("");
                    });
                }

                @Override
                public void onFailed(Exception e) {
                    Platform.runLater(() -> {
                        errorLabel.setText("An error occurred while fetching order summary.");
                        errorLabel.setTooltip(new Tooltip(e.getLocalizedMessage()));
                    });
                }
            });
        }
    }

    private class NetStatUpdater implements Runnable {

        private static final String OFFLINE = "Offline";
        private static final String OFFLINE_STYLE = "offline";
        private static final String ONLINE = "Online";
        private static final String ONLINE_STYLE = "online";

        @Override
        public void run() {
            ConnectionManager connectionManager = new ConnectionManager(Application.propertyManager);
            if (connectionManager.checkConnection()) {
                Platform.runLater(() -> {
                    netStatLabel.setText(ONLINE);
                    netStatLabel.getStyleClass().clear();
                    netStatLabel.getStyleClass().add(ONLINE_STYLE);
                });
            } else {
                Platform.runLater(() -> {
                    netStatLabel.setText(OFFLINE);
                    netStatLabel.getStyleClass().clear();
                    netStatLabel.getStyleClass().add(OFFLINE_STYLE);
                });
            }
        }
    }
}
