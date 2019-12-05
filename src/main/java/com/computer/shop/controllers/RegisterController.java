package com.computer.shop.controllers;

import com.computer.shop.MainApp;
import com.computer.shop.helpers.ViewHelper;
import com.computer.shop.http.HttpRequests;
import com.computer.shop.models.User;
import com.google.gson.Gson;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    private static final String REGISTER_ENDPOINT = "register";
    @FXML
    public TextField loginInput;
    @FXML
    public TextField emailInput;
    @FXML
    public TextField passwordInput;
    @FXML
    public TextField passwordInput2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void backToMenu(final Event event) {
        ViewHelper.loadView(this, "/login/login.fxml", "/login/loginStyles.css");
        ViewHelper.killCurrentView(event);
    }

    public void register() {
        if (validateFields()) {
            if(passwordInput.getText().equals(passwordInput2.getText())) {
                HttpRequests httpRequests = new HttpRequests(MainApp.ADDRESS, MainApp.PORT);
                User user = new User(loginInput.getText(), passwordInput.getText(), emailInput.getText());
                if (Boolean.parseBoolean(httpRequests.post(REGISTER_ENDPOINT, new Gson().toJson(user)))) {
                    showAlert("New user registered!");
                } else {
                    showAlert("User already exists!");
                }
            } else {
                showAlert("Password do not match!");
            }
        }
    }

    private boolean validateFields() {
        final String emailText = emailInput.getText();
        if(!loginInput.getText().isEmpty() && !emailText.isEmpty() && !passwordInput.getText().isEmpty() && !passwordInput2.getText().isEmpty()) {
            if (emailText.contains("@" ) && emailText.contains(".")) {
                return true;
            } else {
                showAlert("Not correct Email!");
            }
        } else {
            showAlert("Please fill all input fields!");
        }

        return false;
    }

    private void showAlert(final String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
