package com.pooespol.proyecto_2p_poo;

import Modelo.Base;
import Modelo.Helado;
import Modelo.Pedido;
import Modelo.Sabores;
import Modelo.Toppings;
import Modelo.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class App extends Application {

    //variables statics para hacer objeto helado
    public static Base basehelado;
    public static ArrayList<Sabores> saboreshelado=new ArrayList<>();
    public static ArrayList<Toppings> toppingshelado= null;
    //variables estaticas para hacer objeto pedido
    public static double total;
    public static Usuario cliente;
    public static int id;
    public static Helado helado;
    //para escribir en pago
    public static Pedido pedido;
    public static int idpago;
    public static double totalPagar;
    public static String fecha;
    public static char tipo;
    //para actualizar la lista de pedidos en tiempo real
    public static ArrayList<String> pgenerados= new ArrayList<>();
    
    //rutas
    private static Scene scene;
    public static String path = "src/main/resources/Pictures/";
    public static String pathI = "src/main/resources/Files/";
    public static String pathH = "src/main/resources/Heladeria/";
    public static String pathS = "src/main/resources/Serializados/";
    
    public void start(Stage s) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Inicio.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root, 1240, 700);
        s.setScene(scene);
        s.show();
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static void main(String[] args) {
        launch();
    }

}