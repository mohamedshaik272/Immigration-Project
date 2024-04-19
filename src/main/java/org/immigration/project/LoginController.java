package org.immigration.project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML TextField username;
    @FXML TextField password;
    @FXML private Label incorrectCredentials;

    @FXML
    protected void onLoginButton() {
        if (username.getText().equals(Globals.getUser()) && password.getText().equals(Globals.getPass())) {
            username.clear();
            password.clear();
            incorrectCredentials.setText("");
            StageController.activate(Globals.user.fx_name);
        } else {
            incorrectCredentials.setText("Incorrect Credentials");
        }
    }

    @FXML
    protected void onBackButton() {
        username.clear();
        password.clear();
        incorrectCredentials.setText("");
        Globals.user = Globals.UserType.INVALID;
        StageController.activate("oneui");
    }
}