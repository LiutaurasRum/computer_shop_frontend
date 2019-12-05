package com.computer.shop.helpers;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewHelper {
    public static void loadView(Initializable view, final String fxmlPath, final String cssPath) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(view.getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(view.getClass().getResource(cssPath).toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void killCurrentView(final Event event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }
}
