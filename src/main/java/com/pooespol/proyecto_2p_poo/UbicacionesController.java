/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto_2p_poo;

import Modelo.Ubicacion;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UbicacionesController implements Initializable {
    
    @FXML
    private Pane paneUbicaciones;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<Ubicacion> locales = Ubicacion.objetoUbicaciones("locales.txt");
        
        for(Ubicacion u : locales){
            ImageView i = new ImageView();
            try(FileInputStream input = new FileInputStream(App.path + "Logo_Posicion.png")){
            Image image = new Image(input, 68, 50, false, false);
            i.setImage(image);
            
            i.setLayoutX(u.getCoorX()*2);
            i.setLayoutY(u.getCoorY()*-1.5);

            paneUbicaciones.getChildren().addAll(i);
            
            i.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle (MouseEvent m){
                    //Creación de ImageView para el fondo de la ventana
                    Image back = new Image(getClass().getResource("/Pictures/Background_VentanaUbicacion.png").toExternalForm());
                    ImageView ground = new ImageView(back);
                    ground.setFitHeight(400);
                    ground.setFitWidth(600);
                    
                    //Controles y sus diseños
                    Label lugar = new Label(u.getNombre());
                    lugar.setStyle("-fx-font-family: 'Avenir Next'; -fx-font-size: 26px; -fx-text-fill: white");
                    Label hora = new Label("H O R A R I O");
                    hora.setStyle("-fx-font-family: 'Metropolis'; -fx-font-size: 20px; -fx-text-fill: white");
                    Label hour = new Label(u.getHorario());
                    hour.setStyle("-fx-font-family: 'Avenir Next'; -fx-font-size: 26px; -fx-text-fill: white");
                    Label mensaje = new Label();
                    mensaje.setStyle("-fx-font-family: 'Avenir Next'; -fx-font-size: 18px; -fx-text-fill: white");
                    Button cerrar = new Button("Cerrar");
                    cerrar.setStyle("-fx-font-family: 'Avenir Next'; -fx-font-size: 14px; -fx-text-fill: #276087; -fx-background-color: white");
                    
                    cerrar.setOnAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle (ActionEvent e){
                            Stage s = (Stage)cerrar.getScene().getWindow();
                            s.close();
                        }
                    });
                    
                    //Pane en donde va el background
                    Pane foto = new Pane();
                    foto.setPrefHeight(0);
                    foto.setPrefWidth(0);
                    foto.getChildren().addAll(ground);
                    
                    //VBox vacio
                    VBox title = new VBox();
                    title.setPrefWidth(600);
                    title.setPrefHeight(140);
                    
                    //VBox donde van los controles
                    VBox content = new VBox();
                    content.setPrefWidth(600);
                    content.setPrefHeight(261);
                    content.setAlignment(Pos.TOP_CENTER);
                    
                    
                    VBox uno = new VBox();
                    uno.setPrefWidth(600);
                    uno.setPrefHeight(54);
                    uno.setAlignment(Pos.BOTTOM_CENTER);
                    uno.getChildren().addAll(lugar);
                    
                    VBox dos = new VBox();
                    dos.setPrefWidth(600);
                    dos.setPrefHeight(84);
                    dos.setAlignment(Pos.CENTER);
                    dos.getChildren().addAll(hora, hour);
                    
                    VBox tres = new VBox();
                    tres.setPrefWidth(600);
                    tres.setPrefHeight(83);
                    tres.setAlignment(Pos.CENTER);
                    tres.setSpacing(15);
                    tres.getChildren().addAll(mensaje, cerrar);
                    
                    
                    content.getChildren().addAll(uno, dos, tres);
                    
                    VBox root = new VBox();
                    root.getChildren().addAll(foto, title, content);
                    
                    Scene g = new Scene(root, 600, 400);
                    Stage stage = new Stage();
                    stage.setScene(g);
                    stage.setTitle("Detalles de Ubicación");
                    stage.show();
                    
                    Thread thread = new Thread(() -> {
                        for (int i = 5; i > 0; i--) {
                            int finalI = i;
                            Platform.runLater(() -> {
                            mensaje.setText("Cerrando en " + finalI + " segundos...");
                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    Platform.runLater(() -> stage.close());
                    });

                    thread.start();
                    
                }
            });
            
            } catch (IOException e){
                System.out.println("No se encuentra la imagen");
            }
            
        }
    }     
    
}
