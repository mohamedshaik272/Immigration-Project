package org.immigration.project;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private TextField countryField;

    // Method to handle the action of the "Submit" button
    @FXML
    private void handleSubmitButtonAction() {
        // Handle submit button action here
        String name = nameField.getText();
        String email = emailField.getText();
        String country = countryField.getText();
        LocalDate date = datePicker.getValue();

        // Create an instance of Immigrant.Builder
        Immigrant immigrant = new Immigrant(name, email, country, Status.NEW, "123 Main St", date);

        // Optionally, perform additional actions with the immigrant object
        System.out.println("Immigrant Details:");
        System.out.println("Name: " + immigrant.getName());
        System.out.println("Email: " + immigrant.getEmail());
        System.out.println("Country: " + immigrant.getCountry());
        System.out.println("Date: " + immigrant.getDate());
    }

    



}
