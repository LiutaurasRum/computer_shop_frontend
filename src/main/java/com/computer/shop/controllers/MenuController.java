package com.computer.shop.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }


    private void showAlert(final String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
