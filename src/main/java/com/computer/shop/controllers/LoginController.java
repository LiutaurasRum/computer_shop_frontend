package com.computer.shop.controllers;

import com.computer.shop.MainApp;
import com.computer.shop.helpers.ViewHelper;
import com.computer.shop.http.HttpRequests;
import com.computer.shop.models.User;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private static final String LOGIN_ENDPOINT = "login";
    public static final Boolean DEBUG_MODE = false;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void login(final ActionEvent event) {
        if(DEBUG_MODE) {
            ViewHelper.loadView(this,"/menu/menu.fxml", "/menu/menu.css");
            ViewHelper.killCurrentView(event);
            return;
        }

        final String login = loginTextField.getText();
        final String password = passwordTextField.getText();
        if (!login.isEmpty() && !password.isEmpty()) {
            if (requestLogin(login, password)) {
                ViewHelper.loadView(this,"/menu/menu.fxml", "/menu/menu.css");
                ViewHelper.killCurrentView(event);
            } else {
                showAlert("Credentials are incorrect!");
            }
        } else {
            showAlert("One of credentials fields are empty.");
        }
    }

    private boolean requestLogin(final String login, final String password) {
        HttpRequests httpRequests = new HttpRequests(MainApp.ADDRESS, MainApp.PORT);
        String credentialsJson = new Gson().toJson(new User(login, password, null));
        return Boolean.parseBoolean(httpRequests.post(LOGIN_ENDPOINT, credentialsJson));
    }

    public void openRegisterView(final Event event) {
        ViewHelper.loadView(this,"/register/register.fxml", "/register/register.css");
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
