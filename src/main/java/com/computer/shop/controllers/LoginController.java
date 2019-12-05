package com.computer.shop.controllers;

import com.computer.shop.MainApp;
import com.computer.shop.http.HttpRequests;
import com.computer.shop.models.User;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private static final String LOGIN_ENDPOINT = "login";
    @FXML
    private Label label;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void login(ActionEvent event) {
        final String login = loginTextField.getText();
        final String password = passwordTextField.getText();

        if (!login.isEmpty() && !password.isEmpty()) {
            if (requestLogin(login, password)) {
                loadMenuView();
                ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
            } else {
                showAlert("Credential are incorrect!");
            }
        } else {
            showAlert("One of credentials fields are empty.");
        }
    }

    private void loadMenuView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/menu.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/menu/menuStyles.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean requestLogin(final String login, final String password) {
        HttpRequests httpRequests = new HttpRequests(MainApp.ADDRESS, MainApp.PORT);
        String credentialsJson = new Gson().toJson(new User(login, password));
        return Boolean.parseBoolean(httpRequests.post(LOGIN_ENDPOINT, credentialsJson));
    }

    private void showAlert(final String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
