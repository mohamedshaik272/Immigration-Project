package org.immigration.project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Objects;

public class StageController {
    private static HashMap<String, Pane> stageMap;
    public static Scene main;
    private static Stage stage;

    public StageController(Stage newStage) {
        stageMap = new HashMap<>();
        main = new Scene(new Pane());
        stage = newStage;
    }

    public StageController add(String name, String paneName) throws IOException {
        Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(paneName)));
        stageMap.put(name, pane);
        return this;
    }

    public StageController remove(String name) throws InvalidParameterException {
        if (!stageMap.containsKey(name))
            throw new InvalidParameterException(name + " is not a valid scene");
        stageMap.remove(name);
        return this;
    }

    public static void activate(String name) throws InvalidParameterException {
        if (!stageMap.containsKey(name))
            throw new InvalidParameterException(name + " is not a valid scene");
        main.setRoot(stageMap.get(name));
        stage.setScene(main.getRoot().getScene());
        stage.show();
    }
}
