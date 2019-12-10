package com.computer.shop.controllers;

import com.computer.shop.helpers.ViewHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    @FXML
    public void openMainMenu(final ActionEvent event) {
        ViewHelper.loadView(this,"/menu/menu.fxml", "/menu/menu.css");
        ViewHelper.killCurrentView(event);
    }
}
