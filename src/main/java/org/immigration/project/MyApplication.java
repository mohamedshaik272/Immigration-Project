package org.immigration.project;

import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends javafx.application.Application {
    StageController stageController;

    @Override
    public void start(Stage stage) throws IOException {
        stageController = new StageController(stage)
            .add("login", "login.fxml")
            .add("second", "second.fxml");

        StageController.activate("login");
    }

    public static void main(String[] args) {
        launch();
    }
}