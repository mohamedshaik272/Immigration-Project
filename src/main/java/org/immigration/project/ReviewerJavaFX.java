package org.immigration.project;


import javafx.application.Application;

import javafx.stage.Stage;

import java.io.IOException;

public class ReviewerJavaFX extends Application {
    StageController stageController;

    @Override
    public void start(Stage stage) throws IOException {
        stageController = new StageController(stage)
                .add("review", "review.fxml");

        StageController.activate("review");
    }

    public static void main(String[] args) {
        launch();
    }
}
