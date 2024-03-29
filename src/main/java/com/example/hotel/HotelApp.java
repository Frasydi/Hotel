package com.example.hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(new FXMLLoader(HotelApp.class.getResource("login.fxml")).load(), 600, 400);
        stage.setTitle("Hello!");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}