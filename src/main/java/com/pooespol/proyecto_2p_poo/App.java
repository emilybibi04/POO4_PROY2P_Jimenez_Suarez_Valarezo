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

/**
 * La clase App es la clase principal de la aplicación de la heladería.
 * Contiene variables estáticas para el objeto helado, el objeto pedido, y otras configuraciones de la aplicación.
 * También proporciona métodos para cargar las vistas FXML y cambiar la escena principal de la aplicación.
 */
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
    
    /**
     * Inicializa la aplicación y carga la escena principal desde el archivo FXML "Inicio.fxml".
     *
     * @param s El objeto Stage en el que se muestra la aplicación.
     * @throws IOException Si hay un error al cargar el archivo FXML.
     */
    public void start(Stage s) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Inicio.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root, 1240, 700);
        s.setScene(scene);
        s.show();
    }
    
    /**
     * Carga y devuelve un objeto Parent desde un archivo FXML especificado.
     *
     * @param fxml El nombre del archivo FXML (sin la extensión .fxml).
     * @return Un objeto Parent que representa la vista cargada desde el archivo FXML.
     * @throws IOException Si hay un error al cargar el archivo FXML.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    /**
     * Cambia la vista principal de la aplicación a la vista especificada por su nombre de archivo FXML.
     *
     * @param fxml El nombre del archivo FXML (sin la extensión .fxml) de la nueva vista.
     * @throws IOException Si hay un error al cargar el archivo FXML de la nueva vista.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    /**
     * El punto de entrada principal de la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        launch();
    }

}