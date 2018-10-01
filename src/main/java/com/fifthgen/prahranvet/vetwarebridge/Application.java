package com.fifthgen.prahranvet.vetwarebridge;

import com.fifthgen.prahranvet.vetwarebridge.ui.MainController;
import com.fifthgen.prahranvet.vetwarebridge.utility.PropertyKey;
import com.fifthgen.prahranvet.vetwarebridge.utility.PropertyManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class Application extends javafx.application.Application {

    private final static String STAGE_TITLE = "VetWare-Connect Bridge";
    private final static int WIDTH = 800;
    private final static int HEIGHT = 600;
    public static volatile PropertyManager propertyManager;

    public static void main(String[] args) {

        try {
            // Read the default property settings.
            propertyManager = new PropertyManager();

            // Initialize default properties,
            initProperties();

            // Launch application.
            Application.launch(args);
        } catch (IOException e) {
            Logger.getGlobal().severe("Couldn't initialize default application properties.");
            System.exit(0);
        }
    }

    /**
     * Initialize the default application properties.
     */
    private static void initProperties() {

        // Initialize account properties.
        if (propertyManager.getProperty(PropertyKey.ACCOUNT_CODE.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.ACCOUNT_CODE.getKey(), "000563");
        }
        if (propertyManager.getProperty(PropertyKey.API_URL.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.API_URL.getKey(), "https://google.com");
        }
        if (propertyManager.getProperty(PropertyKey.CLIENT_TOKEN.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.CLIENT_TOKEN.getKey(), "sample-client-token");
        }
        if (propertyManager.getProperty(PropertyKey.USER_TOKEN.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.USER_TOKEN.getKey(), "sample-user-token");
        }

        // Initialize API properties.
        if (propertyManager.getProperty(PropertyKey.API_URL.getKey()) == null) {
            propertyManager.setProperty(PropertyKey.API_URL.getKey(), "https://google.com");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/Main.fxml"));

        // Load and get the main controller.
        Parent root = loader.load();
        MainController controller = loader.getController();

        // Set stage.
        controller.stage = primaryStage;

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle(STAGE_TITLE);
        primaryStage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("images/logo.png")));
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        // Exit the application on main window close.
        primaryStage.setOnCloseRequest(event -> System.exit(0));

        primaryStage.show();
    }
}
