package com.computer.shop.controllers;

import com.computer.shop.MainApp;
import com.computer.shop.http.HttpRequests;
import com.computer.shop.models.User;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    private void printToConsole() {
        HttpRequests httpRequests = new HttpRequests(MainApp.ADDRESS, MainApp.PORT);
        String obj = new Gson().toJson(new User("liutauras", "slaptazodis"));
        boolean response = Boolean.valueOf(httpRequests.post("login", obj));

        System.out.println("is login successful:" + response);
    }

    @FXML
    public void printToConsoleClick() {
        printToConsole();
    }
}
