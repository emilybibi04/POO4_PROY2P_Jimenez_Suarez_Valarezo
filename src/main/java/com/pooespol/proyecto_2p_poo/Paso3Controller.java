/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.opcion2_proyecto2p;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.Toppings;

/**
 * FXML Controller class
 *
 * @author gabsy
 */
public class Paso3Controller implements Initializable, Readable{

    @FXML
    private GridPane gridAcu_Cont;
    @FXML
    private Label lbAcumulador;
    @FXML
    private Button btnContinuar;
    @FXML
    private AnchorPane root3;
    @FXML
    private HBox paneTxt3;
    @FXML
    private Text txt3;
    @FXML
    private VBox paneToppings;
    @FXML
    private HBox paneEstaticos;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //geometry
        paneToppings.setAlignment(Pos.CENTER_LEFT);
        
        //agregar opciones de forma dinamica
        agregarOpciones();
        agregarEventoCB();
        
    }    
   
    
    //obtener Toppings
    public ArrayList<Toppings> obtenerToppings(){
        ArrayList<String> datos = leerArchivo(App.archToppings);
        ArrayList<Toppings> arregloToppings = new ArrayList<>(); 
        
        for(String line:datos){
            String[] info = line.trim().split(",");
            Toppings t  = new Toppings(info[0], Double.parseDouble(info[1]));
            arregloToppings.add(t);
            
        }
        return arregloToppings;
    }
    
    //crear nodos para las funciones
    public void agregarOpciones(){
        ArrayList<Toppings> arregloToppings = obtenerToppings();
        
        for(Toppings t:arregloToppings){
            CheckBox cB= new CheckBox(t.toString());
            cB.setPadding(new Insets(5,40,5,40));
            cB.setOnAction((ActionEvent aE) -> {});
            paneToppings.getChildren().add(cB);
        }
    }

    //Agregar Evento
    public void agregarEventoCB(){
        
        ObservableList<Node> arregloNodos = paneToppings.getChildren();
        for(Node nD:arregloNodos){
            if(nD instanceof CheckBox){
                CheckBox cB = (CheckBox)nD;
                cB.setOnAction((ActionEvent aE) -> {
                    ArrayList<Toppings> aniadir = manejarOpciones();
                    App.toppings = aniadir;
                });
            }
            
        }
    }
    
    //Manejar Opciones
    public ArrayList<Toppings> manejarOpciones(){
        ObservableList<Node> arregloNodos = paneToppings.getChildren();
        ArrayList<Toppings> arregloToppings = new ArrayList<>();
        double tot = 0.0;
        for(Node nD:arregloNodos){
            if(nD instanceof CheckBox){
                CheckBox cB = (CheckBox) nD;
                if(cB.isSelected()){
                    String[] info = cB.getText().split("-");
                    Toppings topping = new Toppings(info[0], Double.parseDouble(info[1]));
                    arregloToppings.add(topping);
                    tot += Double.parseDouble((cB.getText().split("-"))[1]);
                }
            }   
        } 
        sumarATotal(tot);
        System.out.println(arregloToppings);
        return arregloToppings;
    }
    
    //sumar a total
    public void sumarATotal(double aniadir){
        lbAcumulador.setText("Valor a pagar: "+(App.total=aniadir));
    }   
    
    @FXML
    private void cambiarAPasoPago(ActionEvent event) {
        
    }
    
}
