package com.Javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Server");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Index.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/style.css");
        Image icon = new Image("/images/hotline.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}