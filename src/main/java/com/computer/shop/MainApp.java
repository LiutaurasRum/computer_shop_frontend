package com.computer.shop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {
    public static final String ADDRESS = "localhost";
    public static final String PORT = "8080";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/login/loginStyles.css").toExternalForm());
        stage.setTitle("Computer Shop");
        stage.setScene(scene);
        stage.show();
    }
}
