package com.computer.shop.controllers;

import com.computer.shop.helpers.ViewHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void loadShopItems(final ActionEvent event) {
        ViewHelper.loadView(this, "/shopItems/shopItems.fxml", "/shopItems/shopItems.css");
        ViewHelper.killCurrentView(event);
    }
}
