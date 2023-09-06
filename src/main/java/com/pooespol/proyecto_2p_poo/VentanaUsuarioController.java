/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package com.pooespol.proyecto_2p_poo;

import static Modelo.Readable.leerArchivo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Esta clase es el controlador para la vista principal del usuario.
 * Proporciona funcionalidad para mostrar la bienvenida al usuario, su nombre y opciones para navegar a otras vistas.
 */
public class VentanaUsuarioController implements Initializable {
    
    @FXML
    Label lblBienvenido;
    
    @FXML
    Label lblNombre;
    
    @FXML 
    Button btnSalir;
      
    /**
     * Inicializa el controlador cuando se carga la vista correspondiente.
     *
     * @param url La ubicación relativa de la vista FXML.
     * @param rb  Un objeto ResourceBundle que se puede utilizar para internacionalizar la interfaz de usuario (no se usa en este caso).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String genero = App.cliente.getGenero();
        if (genero.equals("f")){
            lblBienvenido.setText("B I E N V E N I D A");
        }
        else
            lblBienvenido.setText("B I E N V E N I D O");
        lblNombre.setText(App.cliente.getName());
        
    }    
    
    /**
     * Cambia a la vista de ubicaciones cuando se hace clic en el botón correspondiente.
     *
     * @throws IOException Si ocurre un error al cargar la vista de ubicaciones.
     */
    @FXML
    private void switchUbicaciones() throws IOException {
        App.setRoot("Ubicaciones");
    }
    
    /**
     * Cambia a la vista de configuración de helado cuando se hace clic en el botón correspondiente.
     *
     * @throws IOException Si ocurre un error al cargar la vista de configuración de helado.
     */
    @FXML
    private void switchHelado() throws IOException {
        App.setRoot("Paso1");
    }
    
    /**
     * Cierra la aplicación cuando se hace clic en el botón "Salir".
     *
     * @param event El evento de acción generado por hacer clic en el botón.
     */
    @FXML
    void salir(ActionEvent event) {
       
        Stage s=(Stage)btnSalir.getScene().getWindow();
        s.close();
       
    }
    
}