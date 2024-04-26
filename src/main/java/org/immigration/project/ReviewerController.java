package org.immigration.project;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

import static org.immigration.project.Globals.immigrantArrayList;
import static org.immigration.project.Globals.approverArrayList;
import static org.immigration.project.Globals.iterator;

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
    @FXML
    private void handleNextButton() {
        if (immigrantArrayList.isEmpty()){
            return;
        } else if (immigrantArrayList.size() == 1) {
            currentImmigrant = immigrantArrayList.get(0);
        } else if (iterator.hasNext()) {
            currentImmigrant = iterator.next();
        }
        nameField.setText(currentImmigrant.getName());
        emailField.setText(currentImmigrant.getEmail());
        countryField.setText(currentImmigrant.getCountry());
        datePicker.setValue(currentImmigrant.getDate());
        addressField.setText(currentImmigrant.getAddress());
    }
    @FXML
    private void handlePreviousButton() {
        //reverse of the previous
        if (immigrantArrayList.isEmpty()){
            return;
        } else if (immigrantArrayList.size() == 1) {
            currentImmigrant = immigrantArrayList.get(0);
        } else if (iterator.hasPrevious()) {
            currentImmigrant = iterator.previous();
        }
        nameField.setText(currentImmigrant.getName());
        emailField.setText(currentImmigrant.getEmail());
        countryField.setText(currentImmigrant.getCountry());
        datePicker.setValue(currentImmigrant.getDate());
        addressField.setText(currentImmigrant.getAddress());
    }
    @FXML
    private void handleSubmitButtonAction() {
        if (nameField != null && emailField != null && datePicker != null && countryField != null) {
            //move to the next list for approval step
            approverArrayList.add(currentImmigrant);
            immigrantArrayList.remove(currentImmigrant);
            this.currentImmigrant = immigrantArrayList.get(0);
        }
    }

}
