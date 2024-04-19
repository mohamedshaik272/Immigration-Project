package org.immigration.project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class oneUIController {
    @FXML
    protected void dataEntry() {
        Globals.user = Globals.UserType.DATAENTRY;
        StageController.activate("login");
    }

    @FXML
    protected void reviewer() {
        Globals.user = Globals.UserType.REVIEWER;
        StageController.activate("login");
    }

    @FXML
    protected void approval() {
        Globals.user = Globals.UserType.APPROVAL;
        StageController.activate("login");
    }
}