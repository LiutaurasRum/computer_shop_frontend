package com.computer.shop.controllers;

import com.computer.shop.MainApp;
import com.computer.shop.http.HttpClient;
import com.computer.shop.models.Info;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
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
        HttpClient httpClient = new HttpClient(MainApp.ADDRESS, MainApp.PORT);
        Info[] info = new Gson().fromJson(httpClient.get(MainApp.API_INFO), Info[].class);
        for (Info value : info) {
            System.out.println("name: " + value.getName() + " model: " + value.getModel() + " count: " + Integer.valueOf(value.getCount()));
        }
    }

    @FXML
    public void printToConsoleClick() {
        printToConsole();
    }
}
