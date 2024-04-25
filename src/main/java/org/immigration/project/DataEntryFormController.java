package org.immigration.project;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static org.immigration.project.Globals.immigrantArrayList;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;

public class DataEntryFormController {
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

    // Method to handle the action of the "Submit" button
    @FXML
    private void handleSubmitButtonAction() {
        if (nameField != null && emailField != null && datePicker != null && countryField != null) {
            String name = nameField.getText();
            String email = emailField.getText();
            String country = countryField.getText();
            LocalDate date = datePicker.getValue();
            String address = addressField.getText();

            Immigrant immigrant = new Immigrant(name, email, country, Status.NEW, address, date);
            immigrantArrayList.add(immigrant);

            for (Immigrant immi : immigrantArrayList) {
                System.out.println(immi.toString());
            }

            nameField.setText("");
            emailField.setText("");
            countryField.setText("");
            datePicker.setValue(null);
            addressField.setText("");
        }
    }


    @FXML
    protected void onBackButton() {
        StageController.activate("login");
    }

    @FXML
    public void handleAddDependentAction() {
        if (dependentNameField != null && dependentRelationshipField != null && dependentDobPicker != null) {
            String name = dependentNameField.getText();
            String relationship = dependentRelationshipField.getText();
            LocalDate dob = dependentDobPicker.getValue();

            Dependent dependent = new Dependent.Builder()
                    .withName(name)
                    .withRelationship(relationship)
                    .withDateOfBirth(dob)
                    .build();

            // Add the dependent
            immigrantArrayList.get(immigrantArrayList.size() - 1).addDependent(dependent);

        }

        for (Immigrant immigrant : immigrantArrayList) {
            System.out.println(immigrant.toString());
        }
    }
}
