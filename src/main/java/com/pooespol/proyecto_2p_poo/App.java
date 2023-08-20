package com.pooespol.proyecto_2p_poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class App extends Application {

    private static Scene scene;
    public static String path = "src/main/resources/Pictures/";
    
    public void start(Stage s) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Inicio.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root, 1240, 700);
        s.setScene(scene);
        s.show();
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static void main(String[] args) {
        launch();
    }

}