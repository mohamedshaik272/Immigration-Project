package org.immigration.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static org.immigration.project.Globals.*;

public class OneUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        new StageController(primaryStage)
                .add("oneui", "oneUI.fxml")
                .add("login", "login.fxml")
                .add(UserType.DATAENTRY.fx_name, UserType.DATAENTRY.fx_file)
                .add(UserType.REVIEWER.fx_name, UserType.REVIEWER.fx_file)
                .add(UserType.APPROVAL.fx_name, UserType.APPROVAL.fx_file);
        StageController.activate("oneui");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
