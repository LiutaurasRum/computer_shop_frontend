package com.computer.shop.controllers;

import com.computer.shop.helpers.ViewHelper;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void backToMenu(final Event event) {
        ViewHelper.loadView(this, "/login/login.fxml", "/login/loginStyles.css");
        ViewHelper.killCurrentView(event);
    }

    private void showAlert(final String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
