/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package com.pooespol.proyecto_2p_poo;

import Modelo.Base;
import Modelo.IncompleteStageException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Paso1Controller implements Initializable{
    private static Scene scene;
    @FXML
    private AnchorPane root;
    @FXML
    private VBox root2;
    @FXML
    private Button btnYogurt;
    @FXML
    private Button btnHelado;
    @FXML
    private Button btnVegano;
    @FXML
    private Label lbAcumulador;
    @FXML
    private Label lbPrecioYogurt;
    @FXML
    private Label lbPrecioHelado;
    @FXML
    private Label lbPrecioVegano;
    @FXML
    private HBox hbxDinamico;
        
    @FXML
    private Button btnContinuar;
    
    private ArrayList<String> datosBases; 
    
    private Base baseSeleccionada=null;
    
    @FXML
    private Label errorLabel;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            datosBases= Base.lineaBases(App.pathI+"bases.txt");
            //Alinear hboxDinamico
            hbxDinamico.setAlignment(Pos.CENTER);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    

    @FXML
    private void seleccionarBoton(ActionEvent event) {
        errorLabel.setText("");
        Button boton = (Button) event.getSource();
        String nombreBoton = boton.getId();
        
        String nuevoString = nombreBoton.substring(3);
        nuevoString = Character.toLowerCase(nuevoString.charAt(0)) + nuevoString.substring(1);
        
        for (String s: datosBases){
            String[] parte= s.trim().split(",");
            if (nuevoString.equals(parte[0])){
                baseSeleccionada= new Base(parte[0],Double.parseDouble(parte[1]));
                lbAcumulador.setText("Valor a pagar: " + baseSeleccionada.getPrecio());
                return;
            }
        }
        
    }
    
    
    @FXML
    private void cambiarAPaso2(ActionEvent event) throws IOException,IncompleteStageException{
        if (baseSeleccionada == null) {
            try {
                throw new IncompleteStageException("Debes elegir una base para continuar");
            } catch (IncompleteStageException e) {
                errorLabel.setText(e.getMessage());
            }
        } else {
            
            App.basehelado = baseSeleccionada;
            App.total += baseSeleccionada.getPrecio();
            
            try {
               App.setRoot("Paso2");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
} 
  
  

