package org.immigration.project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondController {
    private boolean docOpened = false;
    @FXML private Label label1;

    @FXML
    protected void logout() {
        docOpened = false;
        label1.setText("");

        StageController.activate("login");
    }

    @FXML
    protected void openDoc() throws FileNotFoundException {
        try {
            File myFile = new File("src/main/java/org/immigration/project/samp_app.pdf");
            Desktop.getDesktop().open(myFile);
            docOpened = true;
        } catch (IOException ex) {
            throw new FileNotFoundException("File not found");
        }
    }

    @FXML
    protected void acceptForm() {
        if (!docOpened) {
            openDocFirst();
            return;
        }
        label1.setTextFill(Color.GREEN);
        label1.setText("Form Accepted, email sent to applicant!");
    }

    @FXML
    protected void rejectForm() {
        if (!docOpened) {
            openDocFirst();
            return;
        }
        label1.setTextFill(Color.RED);
        label1.setText("Form Rejected, email sent to reviewer.");
    }

    private void openDocFirst() {
        label1.setTextFill(Color.BLACK);
        label1.setText("Please open the document first.");
    }
}