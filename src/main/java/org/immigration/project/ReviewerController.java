package org.immigration.project;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

import static org.immigration.project.Globals.immigrantArrayList;

public class ReviewerController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField addressField;

    @FXML
    private TextField dependentNameField;

    @FXML
    private TextField dependentRelationshipField;

    @FXML
    private DatePicker dependentDobPicker;

    @FXML
    private TextField countryField;

    private Immigrant currentImmigrant;

    @FXML
    protected void logout() {
        StageController.activate("login");
    }

    private void handleNextButton() {

            nameField.setText(currentImmigrant.getName());
            emailField.setText(currentImmigrant.getEmail());
            countryField.setText(currentImmigrant.getCountry());
            datePicker.setValue(currentImmigrant.getDate());
            addressField.setText(currentImmigrant.getAddress());

    }
    private void handlePreviousButton() {

            nameField.setText(currentImmigrant.getName());
            emailField.setText(currentImmigrant.getEmail());
            countryField.setText(currentImmigrant.getCountry());
            datePicker.setValue(currentImmigrant.getDate());
            addressField.setText(currentImmigrant.getAddress());

    }

    private void handleSubmitButtonAction() {
        if (nameField != null && emailField != null && datePicker != null && countryField != null) {
            //NA
        }
    }

    @FXML
    protected void sendToApprover() {
        System.out.println("Sending to approver...");
    }
}
