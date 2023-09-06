/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package com.pooespol.proyecto_2p_poo;

import Modelo.IncompleteStageException;
import Modelo.Sabores;
import java.io.IOException;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Esta clase es el controlador para la ventana de selección de sabores en el proceso de pedido.
 * Implementa la interfaz Initializable y gestiona la elección de sabores para el helado.
 */
public class Paso2Controller implements Initializable{

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
    
    private double total= 0.0;
    
    private Sabores sabor1 =null;
    
    private Sabores sabor2 =null;
    
    private ArrayList<String> datosSabores;
    
    @FXML
    private Label errorLabel2;

    /**
     * Inicializa el controlador cuando se carga la vista correspondiente.
     *
     * @param url La ubicación relativa de la vista FXML.
     * @param rb  Un objeto ResourceBundle que se puede utilizar para internacionalizar la interfaz de usuario (no se usa en este caso).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            datosSabores = Sabores.lineaSabores(App.pathI+"sabores.txt");
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         //agregar sabores al combo
            
        agregarSaboresCombo(cmb2, cmb1);
        lbAcumulador.setText("Valor a pagar: " + App.total);
            
        cmb1.setOnAction(this::obtenerPrecio);
        cmb2.setOnAction(this::obtenerPrecio);
    }    
    
    /**
     * Obtiene una lista de objetos Sabores a partir de los datos cargados desde el archivo.
     *
     * @return Una lista de objetos Sabores.
     */
    public ArrayList<Sabores> obtenerSabores(){
        //Obtener información de los archivos
        
        System.out.println(datosSabores);
        ArrayList<Sabores> arregloSabores = new ArrayList<>();
        
        for(String linea:datosSabores){
            String[] info = linea.trim().split(",");
            Sabores s = new Sabores(info[0], Double.parseDouble(info[1]));
            arregloSabores.add(s);
        }
        return arregloSabores;
    }
    
    /**
     * Agrega los valores de sabores al ComboBox de selección.
     *
     * @param cbxS  El ComboBox de sabores.
     * @param cbxS2 El segundo ComboBox de sabores.
     */
    public void agregarSaboresCombo(ComboBox<Sabores> cbxS,ComboBox<Sabores> cbxS2){        
        ArrayList<Sabores> arreglos = obtenerSabores();
        Collections.sort(arreglos);
        cbxS.getItems().addAll(arreglos);
        cbxS2.getItems().addAll(arreglos);
    }
    
    /**
     * Calcula y muestra el precio total en función de los sabores seleccionados.
     *
     * @param event El evento de selección de ComboBox.
     */
    @FXML
    public void obtenerPrecio(ActionEvent event){
        
        errorLabel2.setText("");
        
        Sabores saborA = cmb1.getValue();
        Sabores saborB = cmb2.getValue();
        
        double ntotal=0.00;

        if (saborA != null) {
            ntotal += saborA.getPrecio();
        }

        if (saborB != null) {
            ntotal += saborB.getPrecio();
        }

        lbAcumulador.setText("Valor a pagar: " + (App.total+ntotal));
        total= App.total+ntotal;
    }
    
    /**
     * Cambia a la siguiente etapa del proceso de pedido (Paso 3) después de seleccionar los sabores.
     *
     * @param event El evento de acción que desencadenó este método.
     * @throws IOException Si ocurre un error al cargar la vista de la siguiente etapa del proceso.
     */
    @FXML
    private void cambiarAPaso3(ActionEvent event) throws IOException,IncompleteStageException{
        if (total == 0.00) {
            try {
                throw new IncompleteStageException("Debe elegir al menos una opción para continuar");
            } catch (IncompleteStageException e) {
                errorLabel2.setText(e.getMessage());
            }
        } else {
//            
            sabor1 = cmb1.getValue();
            sabor2 = cmb2.getValue();
            App.saboreshelado.add(sabor1);
            App.saboreshelado.add(sabor2);
            App.total=total;
            
            System.out.println(App.saboreshelado);
            System.out.println(App.total);


            try {
                App.setRoot("Paso3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
