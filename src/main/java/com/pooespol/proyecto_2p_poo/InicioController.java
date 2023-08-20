/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto_2p_poo;

import Modelo.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InicioController implements Initializable {
    
    @FXML
    TextField textUsuario;
    
    @FXML
    PasswordField PasswordF;
    
    @FXML
    Label lblValidar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList <Usuario> usuarios = Usuario.objetoUsuarios("usuarios.txt");
        
        
    }    
    
    @FXML
    private void switchVentanaUsuario() throws IOException {
        App.setRoot("VentanaUsuario");
    }
    
    
}
