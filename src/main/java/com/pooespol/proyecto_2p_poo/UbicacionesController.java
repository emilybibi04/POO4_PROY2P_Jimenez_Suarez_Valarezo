/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto_2p_poo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class UbicacionesController implements Initializable {
    
    @FXML
    private Pane paneUbicaciones;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        ArrayList<Ubicacion> locales = Ubicacion.objetoUbicaciones("locales.txt");
        
        for(Ubicacion u : locales){
            Button b = new Button("");
            b.setLayoutX(u.getCoorX());
            b.setLayoutY(u.getCoorY());

            paneUbicaciones.getChildren().add(b);
            
        }
    }     
    
}
