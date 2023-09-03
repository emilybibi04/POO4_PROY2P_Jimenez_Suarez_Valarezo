/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto_2p_poo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class VentanaUsuarioController implements Initializable {
    
    @FXML
    Label lblBienvenido;
    
    @FXML
    Label lblNombre;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void switchUbicaciones() throws IOException {
        App.setRoot("Ubicaciones");
    }
    
}
