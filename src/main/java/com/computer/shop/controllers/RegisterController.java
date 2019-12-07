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

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

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
        ViewHelper.loadView(this, "/login/login.fxml", "/login/login.css");
        ViewHelper.killCurrentView(event);
    }

    public void register() {
        User user = new User(loginInput.getText(), passwordInput.getText(), emailInput.getText());
        final Set<ConstraintViolation<User>> validationResult = getValidityResult(user);
        if (validationResult.isEmpty()) {
            if(passwordInput.getText().equals(passwordInput2.getText())) {
                HttpRequests httpRequests = new HttpRequests(MainApp.ADDRESS, MainApp.PORT);

                if (Boolean.parseBoolean(httpRequests.post(REGISTER_ENDPOINT, new Gson().toJson(user)))) {
                    showAlert("New user registered!");
                } else {
                    showAlert("User already exists!");
                }
            }
        } else {
            showAlert(validationResult.iterator().next().getMessage());
        }
    }

    private Set<ConstraintViolation<User>> getValidityResult(final User user) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
         return validator.validate(user);
    }

    private void showAlert(final String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
