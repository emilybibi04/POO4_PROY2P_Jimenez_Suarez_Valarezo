/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.opcion2_proyecto2p;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Bases;


/**
 * FXML Controller class
 *
 * @author gabsjimz
 */
public class Paso1Controller implements Initializable, Readable{
    private static Scene scene;
    @FXML
    private AnchorPane root;
    @FXML
    private VBox root2;
    private Button btnYogurt;
    private Button btnHelado;
    private Button btnVegano;
    private Label lbAcumulador;
    private Label lbPrecioYogurt;
    private Label lbPrecioHelado;
    private Label lbPrecioVegano;
    private HBox hbxDinamico;
    
    //Variables necesarias para la creación del pedido
    
    private Bases base;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //Alinear hboxDinamico
        hbxDinamico.setAlignment(Pos.CENTER);
        
        //Obtener información de los archivos
        ArrayList<String> datosBases = leerArchivo(App.archBases);
        
        ArrayList<String> datosToppings = leerArchivo(App.archToppings);
        
        //Agregar información en los nodos
        Thread t = new Thread(new Runnable(){
            
            @Override
            public void run(){              
              for(String linea: datosBases){
                  String[] l = linea.trim().split(",");
                  String x = l[0];
                  switch(x){
                      case "yogurt":
                          Bases yogurt = new Bases(l[0], Double.parseDouble(l[1]));
                          btnYogurt.setText(yogurt.getBase().substring(0,1).toUpperCase()+yogurt.getBase().substring(1));
                          lbPrecioYogurt.setText(String.valueOf(yogurt.getPrecio()));
                          break;
                      case "helado":
                          Bases helado = new Bases(l[0], Double.parseDouble(l[1]));
                          btnHelado.setText(helado.getBase().substring(0,1).toUpperCase()+helado.getBase().substring(1));
                          lbPrecioHelado.setText(String.valueOf(helado.getPrecio()));
                          break;
                      case "vegano":
                          Bases vegano = new Bases(l[0], Double.parseDouble(l[1]));
                          btnVegano.setText(vegano.getBase().substring(0,1).toUpperCase()+vegano.getBase().substring(1));
                          lbPrecioVegano.setText(String.valueOf(vegano.getPrecio()));
                          break;
                  } 
              }  
            }
        });
        
        t.start();
    }    
    
    
    /**Como equipo notamos que al iniciar los pasos, el usuario por impulso podría aplastar el button equivocado
     * por lo que es optimo, proponerle la opción de cambiar el ítem.
     **/
    public void cambiarSabor(){
        Button btnDinamico = new Button();
        btnDinamico.setText("Cambiar Sabor");        
        hbxDinamico.getChildren().add(btnDinamico);
        
        btnDinamico.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override 
            public void handle(MouseEvent mE){
                deshabilitar(false);
                sumarTotal(App.total*(-1));
                lbAcumulador.setText("Valor a pagar: ");
                hbxDinamico.getChildren().clear();
            }
        });
    }


    private void agregarValor(MouseEvent event) {
        
        Node nd = event.getPickResult().getIntersectedNode();
        Button btn = new Button();
        Text txt = new Text();
        
        /**Se encontró el problema de que al seleccionar el button (cualquiera) se obtenía un Nodo Button o un Nodo "LabeledText".
          En este if verificamos al cual de ellos se accede.**/
        
        if(btn.getClass() == nd.getClass()){
          btn = (Button) event.getPickResult().getIntersectedNode();
          switch(btn.getText().toLowerCase()){
            case "yogurt":
                lbAcumulador.setText(lbAcumulador.getText()+lbPrecioYogurt.getText());
                deshabilitar(true);
                sumarTotal(Double.parseDouble(lbPrecioYogurt.getText()));
                base = new Bases(btn.getText(),Double.parseDouble(lbPrecioYogurt.getText()));
                break;
            case "helado":
                lbAcumulador.setText(lbAcumulador.getText()+lbPrecioHelado.getText());
                deshabilitar(true);
                sumarTotal(Double.parseDouble(lbPrecioHelado.getText()));
                base = new Bases(btn.getText(),Double.parseDouble(lbPrecioHelado.getText()));
                break;
            case "vegano":
                lbAcumulador.setText(lbAcumulador.getText()+lbPrecioVegano.getText());
                deshabilitar(true);
                sumarTotal(Double.parseDouble(lbPrecioVegano.getText()));
                base = new Bases(btn.getText(),Double.parseDouble(lbPrecioVegano.getText()));
                break;
          } 
        } 
        
        else {
            txt = (Text)event.getPickResult().getIntersectedNode();
            System.out.println(txt.getText());
        }
        
        cambiarSabor();
    }
    
    
    
    //Funciones extras para simplificar el código
   
    //deshabilitar buttons
    public void deshabilitar(boolean b){
        btnYogurt.setDisable(b);
        btnVegano.setDisable(b);
        btnHelado.setDisable(b);
    }
    
    //agregar valor al total
    public double sumarTotal(double d){
        App.total += d;
        return App.total;
    }

    @FXML
    private void cambiarAPaso2(ActionEvent event) throws IOException{
        App.scene = new Scene(root2,747, 452);
    }
} 
  
  

