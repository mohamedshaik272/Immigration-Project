package org.immigration.project;

import javafx.stage.Stage;

import java.io.IOException;

import static org.immigration.project.Globals.*;

public class OneUI extends javafx.application.Application {
    StageController stageController;

    @Override
    public void start(Stage stage) throws IOException {
        stageController = new StageController(stage)
            .add("oneui", "oneUI.fxml")
            .add("login", "login.fxml")
            .add(UserType.DATAENTRY.fx_name, UserType.DATAENTRY.fx_file)
            .add(UserType.REVIEWER.fx_name, UserType.REVIEWER.fx_file)
            .add(UserType.APPROVAL.fx_name, UserType.APPROVAL.fx_file);

        StageController.activate("oneui");
    }

    public static void main(String[] args) {
        launch();
    }
}