package com.computer.shop.controllers;

import com.computer.shop.helpers.ViewHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;

public class ShopItemsController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }


    @FXML
    public void loadMenu(final ActionEvent event) {
        ViewHelper.loadView(this, "/menu/menu.fxml", "/menu/menu.css");
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
