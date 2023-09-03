/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.opcion2_proyecto2p;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.Sabores;

/**
 * FXML Controller class
 *
 * @author gabsjimz
 */
public class Paso2Controller implements Initializable, Readable{

    @FXML
    private VBox root;
    @FXML
    private Text tctPaso2;
    @FXML
    private GridPane paneSabores;
    @FXML
    private Label lbSabor1;
    @FXML
    private Label lbSabor2;
    @FXML
    private ComboBox<Sabores> cmb1;
    @FXML
    private ComboBox<Sabores> cmb2;
    @FXML
    private GridPane gridAcu_Cont;
    @FXML
    private Label lbAcumulador;
    @FXML
    private Button btnContinuar2;
    @FXML
    private HBox hbxDinamico;
    
    private ArrayList<Sabores> saboresSelecc = null;
    /**
     * Initializes the controller class.
     */
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //agregar sabores al combo
        agregarSaboresCombo(cmb2, cmb1);
        //valor por defecto
        cmb1.getSelectionModel().selectFirst();
        cmb2.getSelectionModel().selectFirst();
        //Agregar valor de sabor al total
        
    }    
    
    
    //Obtener Sabores
    public ArrayList<Sabores> obtenerSabores(){
        //Obtener información de los archivos
        ArrayList<String> datosSabores = leerArchivo(App.archSabores);
        ArrayList<Sabores> arregloSabores = new ArrayList<>();
        
        for(String linea:datosSabores){
            String[] info = linea.trim().split(",");
            Sabores s = new Sabores(info[0], Double.parseDouble(info[1]));
            arregloSabores.add(s);
        }
        return arregloSabores;
    }
    
    //Agregar valores al combo
    public void agregarSaboresCombo(ComboBox<Sabores> cbxS,ComboBox<Sabores> cbxS2){        
        ArrayList<Sabores> arreglos = obtenerSabores();
        Collections.sort(arreglos);
        cbxS.getItems().addAll(arreglos);
        cbxS2.getItems().addAll(arreglos);
    }
    
    //Obtener precios
    public double obtenerPrecio(ComboBox<Sabores> cmb1){
        Sabores saborA = cmb1.getValue();
        if(saborA != null){
            
        }
        return App.total;
    }
    

    @FXML
    private void cambiarAPaso3(ActionEvent event) {
        
    }

    @FXML
    private void sumarTotalS(ActionEvent event) {
    }
}
