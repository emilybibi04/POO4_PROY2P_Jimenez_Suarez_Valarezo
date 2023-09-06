/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package com.pooespol.proyecto_2p_poo;

import static Modelo.Readable.redondear;
import Modelo.Toppings;
import java.io.IOException;
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

/**
 * Esta clase es el controlador para la ventana de selección de toppings en el proceso de pedido.
 * Implementa la interfaz Initializable y gestiona la elección de toppings para el helado.
 */

public class Paso3Controller implements Initializable{

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
    
    private double total2;

    /**
     * Inicializa el controlador cuando se carga la vista correspondiente.
     *
     * @param url La ubicación relativa de la vista FXML.
     * @param rb  Un objeto ResourceBundle que se puede utilizar para internacionalizar la interfaz de usuario (no se usa en este caso).
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbAcumulador.setText("Valor a pagar: "+App.total);
        //geometry
        paneToppings.setAlignment(Pos.CENTER_LEFT);
        
        //agregar opciones de forma dinamica
        agregarOpciones();
        agregarEventoCB();
        
    }    
   
    
    /**
     * Obtiene una lista de objetos Toppings a partir de los datos cargados desde el archivo.
     *
     * @return Una lista de objetos Toppings.
     */
    
    public ArrayList<Toppings> obtenerToppings(){
        ArrayList<String> datos=null;
        try {
            datos = Toppings.lineaToppings(App.pathI+"toppings.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ArrayList<Toppings> arregloToppings = new ArrayList<>(); 
        
        for(String line:datos){
            String[] info = line.trim().split(",");
            Toppings t  = new Toppings(info[0], Double.parseDouble(info[1]));
            arregloToppings.add(t);
            
        }
        return arregloToppings;
    }
    
    /**
     * Crea nodos CheckBox para las opciones de toppings y los agrega al panel de toppings.
     */
    
    public void agregarOpciones(){
        ArrayList<Toppings> arregloToppings = obtenerToppings();
        
        for(Toppings t:arregloToppings){
            CheckBox cB = new CheckBox(" " + t.toString());
            cB.setPadding(new Insets(5,50,5,20));
            cB.setOnAction((ActionEvent aE) -> {});
            cB.setStyle("-fx-text-fill: white");
            paneToppings.getChildren().add(cB);
        }
    }

    /**
     * Agrega eventos a los CheckBox para manejar las selecciones de toppings.
     */
    
    public void agregarEventoCB(){
        
        ObservableList<Node> arregloNodos = paneToppings.getChildren();
        for(Node nD:arregloNodos){
            if(nD instanceof CheckBox){
                CheckBox cB = (CheckBox)nD;
                cB.setOnAction((ActionEvent aE) -> {
                    ArrayList<Toppings> aniadir = manejarOpciones();
                    App.toppingshelado = aniadir;
                });
            }
            
        }
    }
    
    /**
     * Maneja las selecciones de los CheckBox para obtener los toppings seleccionados.
     *
     * @return Una lista de toppings seleccionados.
     */
    
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
        return arregloToppings;
    }
    
    /**
     * Suma el valor de los toppings al total a pagar y actualiza la etiqueta correspondiente.
     *
     * @param aniadir El valor a agregar al total.
     */
    
    public void sumarATotal(double aniadir){
        lbAcumulador.setText("Valor a pagar: "+redondear(App.total+aniadir));
    }   
    
    /**
     * Cambia a la siguiente etapa del proceso de pedido (TuPedido) después de seleccionar los toppings.
     *
     * @throws IOException Si ocurre un error al cargar la vista de la siguiente etapa del proceso.
     */
    
    @FXML
    private void cambiarAPasoPago() throws IOException {
        
        String a= lbAcumulador.getText();
        int indiceInicio = a.indexOf(":") + 2; // Suma 2 para saltar el espacio
        String numeroString = a.substring(indiceInicio);
        double valor = Double.parseDouble(numeroString);
        App.total = valor;
        
        App.setRoot("TuPedido");
        
    }
    
}
