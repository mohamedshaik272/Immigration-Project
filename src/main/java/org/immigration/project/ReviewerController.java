package org.immigration.project;

import javafx.fxml.FXML;

public class ReviewerController {
    @FXML
    protected void logout() {
        StageController.activate("login");
    }

    @FXML
    protected void sendToApprover() {
        System.out.println("Sending to approver...");
    }
}
