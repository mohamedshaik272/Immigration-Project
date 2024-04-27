package org.immigration.project;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;
import static org.immigration.project.Globals.immigrantArrayList;

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
    private ComboBox<String> dependentRelationshipField;

    @FXML
    private DatePicker dependentDobPicker;

    @FXML
    private ComboBox<String> countryComboBox;

    // Method to handle the action of the "Submit" button
    @FXML
    private void handleSubmitButtonAction() {
        if (nameField.getText() != null && emailField.getText() != null && datePicker.getValue() != null && countryComboBox.getValue() != null) {
            String name = nameField.getText();
            String email = emailField.getText();
            String country = countryComboBox.getValue();
            dependentDobPicker = datePicker;
            LocalDate date = datePicker.getValue();
            String address = addressField.getText();

            Immigrant immigrant = new Immigrant(name, email, country, Status.NEW, address, date);
            immigrantArrayList.add(immigrant);

            for (Immigrant immi : immigrantArrayList) {
                System.out.println(immi.toString());
            }

            // Clear the fields after submitting
            nameField.setText("");
            emailField.setText("");
            countryComboBox.setValue(null); // Clear ComboBox selection
            datePicker.setValue(null);
            addressField.setText("");
        } else {
            System.out.println("Please fill in all fields.");
        }
    }

    @FXML
    protected void onBackButton() {
        StageController.activate("login");
    }

    @FXML
    public void handleAddDependentAction() {
        if (dependentNameField.getText() != null && dependentRelationshipField.getValue() != null ) {
            String name = dependentNameField.getText();
            String relationship = dependentRelationshipField.getValue();
            LocalDate dob = dependentDobPicker.getValue();

            Dependent dependent = new Dependent.Builder()
                    .withName(name)
                    .withRelationship(relationship)
                    .withDateOfBirth(dob)
                    .build();

            immigrantArrayList.get(immigrantArrayList.size() - 1).addDependent(dependent);

            for (Immigrant immigrant : immigrantArrayList) {
                System.out.println(immigrant.toString());
            }
        }
    }
}
