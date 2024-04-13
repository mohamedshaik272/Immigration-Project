package org.immigration.project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    private final String user = "admin";
    private final String pass = "admin";

    @FXML TextField username;
    @FXML TextField password;
    @FXML private Label incorrectCredentials;

    @FXML
    protected void onHelloButtonClick() {
        if (username.getText().equals(user) && password.getText().equals(pass)) {
            username.clear();
            password.clear();
            incorrectCredentials.setText("");
            StageController.activate("second");
        } else {
            incorrectCredentials.setText("Incorrect Credentials");
        }
    }
}