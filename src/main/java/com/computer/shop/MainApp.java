package com.computer.shop;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;


public class MainApp extends Application {
    private static String LOGIN_ID = "login";
    public static final String ADDRESS = "localhost";
    public static final String PORT = "8080";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
        final Button loginButton = findButtonById(root, LOGIN_ID);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/login/login.css").toExternalForm());
        stage.setTitle("Computer Shop");
        stage.setScene(scene);
        stage.show();
        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                loginButton.fire();
            }
        });
    }

    private Button findButtonById(final Parent root, final String id) {
        Button button = null;
        ObservableList<Node> nodes = ((Parent) root.getChildrenUnmodifiable().get(0)).getChildrenUnmodifiable();
        for (final Node node : nodes) {
            if (!(node instanceof Button)) {
                continue;
            }
            String nodeId = node.getId();

            if (nodeId != null && nodeId.equals(id)) {
                button = (Button) node;
            }
        }

        return button;
    }
}
