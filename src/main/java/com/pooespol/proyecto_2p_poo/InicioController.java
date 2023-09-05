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
    
    static ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void switchVentanaUsuario() throws IOException {
        
        usuariosRegistrados = Usuario.objetoUsuarios(App.pathI + "usuarios.txt");
        String user = textUsuario.getText();
        String pass = PasswordF.getText();
        boolean validar = Usuario.comprobarUsuario(user, pass, usuariosRegistrados);
        if(validar){
            App.cliente=Usuario.crearUsuario(user, pass, usuariosRegistrados);
            App.setRoot("VentanaUsuario");
        }
        else {
            lblValidar.setText("Usuario o Contraseña Incorrecta");
            textUsuario.clear();
            PasswordF.clear();
        }
    }
    
    
}
