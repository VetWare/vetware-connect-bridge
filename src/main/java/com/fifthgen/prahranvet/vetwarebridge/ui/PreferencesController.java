package com.fifthgen.prahranvet.vetwarebridge.ui;

import com.fifthgen.prahranvet.vetwarebridge.Application;
import com.fifthgen.prahranvet.vetwarebridge.utility.PropertyKey;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class PreferencesController implements Initializable {

    public Stage stage;
    @FXML
    private TextField clientText;
    @FXML
    private TextField practiceNameText;
    @FXML
    private TextField accountCodeText;
    @FXML
    private TextField userIdText;
    @FXML
    private TextField clientTokenText;
    @FXML
    private TextField userTokenText;
    @FXML
    private TextField apiUrlText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // General preferences.
        clientText.setText(Application.propertyManager.getProperty(PropertyKey.CLIENT.getKey()));
        practiceNameText.setText(Application.propertyManager.getProperty(PropertyKey.PRACTICE_NAME.getKey()));

        // Account preferences
        accountCodeText.setText(Application.propertyManager.getProperty(PropertyKey.ACCOUNT_CODE.getKey()));
        userIdText.setText(Application.propertyManager.getProperty(PropertyKey.USER_ID.getKey()));
        clientTokenText.setText(Application.propertyManager.getProperty(PropertyKey.CLIENT_TOKEN.getKey()));
        userTokenText.setText(Application.propertyManager.getProperty(PropertyKey.USER_TOKEN.getKey()));

        // API preferences.
        apiUrlText.setText(Application.propertyManager.getProperty(PropertyKey.API_URL.getKey()));
    }

    @FXML
    void onCancelAction(ActionEvent event) {
        stage.close();
    }

    @FXML
    void onApplyAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm save preferences.");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to save changes?");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().add(ButtonType.YES);
        alert.getButtonTypes().add(ButtonType.NO);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get().equals(ButtonType.YES)) {
            // General preferences.
            Application.propertyManager.setProperty(PropertyKey.CLIENT.getKey(), clientText.getText());
            Application.propertyManager.setProperty(PropertyKey.PRACTICE_NAME.getKey(), practiceNameText.getText());

            // Account preferences.
            Application.propertyManager.setProperty(PropertyKey.ACCOUNT_CODE.getKey(), accountCodeText.getText());
            Application.propertyManager.setProperty(PropertyKey.USER_ID.getKey(), userIdText.getText());
            Application.propertyManager.setProperty(PropertyKey.CLIENT_TOKEN.getKey(), clientTokenText.getText());
            Application.propertyManager.setProperty(PropertyKey.USER_TOKEN.getKey(), userTokenText.getText());

            // API preferences.
            Application.propertyManager.setProperty(PropertyKey.API_URL.getKey(), apiUrlText.getText());

            Logger.getGlobal().info("Preferences saved to property file.");

            stage.close();
        }
    }
}
