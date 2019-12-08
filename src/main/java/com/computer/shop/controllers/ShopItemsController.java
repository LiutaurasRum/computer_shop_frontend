package com.computer.shop.controllers;

import com.computer.shop.MainApp;
import com.computer.shop.helpers.ViewHelper;
import com.computer.shop.http.HttpRequests;
import com.computer.shop.models.Info;
import com.computer.shop.models.User;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ShopItemsController implements Initializable {
    @FXML
    private TableView<Info> shopItems;
    @FXML
    public TableColumn<Info, String> shopItemsName;
    @FXML
    public TableColumn<Info, String> shopItemsModel;
    @FXML
    public TableColumn<Info, Integer> shopItemsCount;
    @FXML
    public TableColumn<Info, String> shopItemsType;
    private final HttpRequests http;

    public ShopItemsController() {
        http = new HttpRequests(MainApp.ADDRESS, MainApp.PORT);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shopItemsName.setCellValueFactory(new PropertyValueFactory<>("name"));
        shopItemsModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        shopItemsCount.setCellValueFactory(new PropertyValueFactory<>("count"));
        shopItemsType.setCellValueFactory(new PropertyValueFactory<>("type"));
        shopItems.setItems(getListFromServer());
    }

    @FXML
    public void loadMenu(final ActionEvent event) {
        ViewHelper.loadView(this, "/menu/menu.fxml", "/menu/menu.css");
        ViewHelper.killCurrentView(event);
    }

    private ObservableList<Info> getListFromServer() {
        final String response = http.get("api/info");
        Info[] infos = new Gson().fromJson(response, Info[].class);
        return FXCollections.observableArrayList(infos);
    }
}
