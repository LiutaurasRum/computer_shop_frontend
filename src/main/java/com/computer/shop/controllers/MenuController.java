package com.computer.shop.controllers;

import com.computer.shop.helpers.ViewHelper;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @FXML
    public void loadContactsMenu(final ActionEvent event) {
        ViewHelper.loadView(this, "/contactsMenu/contactsmenu.fxml", "/contactsMenu/contactsmenu.css");
        ViewHelper.killCurrentView(event);
    }
    @FXML
    public void backToMenu(final Event event) {
        ViewHelper.loadView(this, "/login/login.fxml", "/login/login.css");
        ViewHelper.killCurrentView(event);
    }
    @FXML
    public void loadOrderMenu(final Event event) {
        ViewHelper.loadView(this, "/orderMenu/ordermenu.fxml", "/orderMenu/ordermenu.css");
        ViewHelper.killCurrentView(event);
    }
    @FXML
    public void loadItemInsertion(final Event event) {
        ViewHelper.loadView(this, "/iteminsertion/iteminsertion.fxml", "/iteminsertion/iteminsertion.css");
        ViewHelper.killCurrentView(event);
    }

}
