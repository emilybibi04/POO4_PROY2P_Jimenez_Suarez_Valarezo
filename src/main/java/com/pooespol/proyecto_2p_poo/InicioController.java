/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package com.pooespol.proyecto_2p_poo;

import static Modelo.Readable.leerArchivo;
import Modelo.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Esta clase es el controlador para la ventana de inicio de sesión de la aplicación.
 * Implementa la interfaz Initializable y gestiona las interacciones de los usuarios
 * al iniciar sesión.
 */
public class InicioController implements Initializable {
    
    @FXML
    TextField textUsuario;
    
    @FXML
    PasswordField PasswordF;
    
    @FXML
    Label lblValidar;
    
    static ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    
    /**
     * Inicializa el controlador cuando se carga la vista correspondiente.
     *
     * @param url       La ubicación relativa de la vista FXML.
     * @param rb        Un objeto ResourceBundle que se puede utilizar para
     *                  internacionalizar la interfaz de usuario (no se usa en este caso).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    /**
     * Maneja la acción de cambiar a la ventana de usuario después de verificar
     * las credenciales del usuario.
     *
     * @throws IOException Si ocurre un error al cargar la vista de la ventana de usuario.
     */
    @FXML
    private void switchVentanaUsuario() throws IOException {
        
        usuariosRegistrados = Usuario.objetoUsuarios(App.pathI + "usuarios.txt");
        String user = textUsuario.getText();
        String pass = PasswordF.getText();
        boolean validar = Usuario.comprobarUsuario(user, pass, usuariosRegistrados);
        if(validar){
            App.cliente=Usuario.crearUsuario(user, pass, usuariosRegistrados);
            App.setRoot("VentanaUsuario");
            
            //actuualizar lista de pedidos generados
            ArrayList<String> op = leerArchivo(App.pathH + "pagos.txt");
            op.remove(0);
            for (String a: op){
                String[] part = a.trim().split(",");
                App.pgenerados.add(part[2] + ", " + part[1]);
            }
            mostrarVentanaEmergente();

        }
        else {
            lblValidar.setText("Usuario o Contraseña Incorrecta");
            textUsuario.clear();
            PasswordF.clear();
        }
    }
    
    /**
     * Muestra una ventana emergente que contiene una lista de pedidos generados.
     */
    private void mostrarVentanaEmergente() {
        // Crea la ventana emergente
        Stage stage = new Stage();
        stage.setTitle("Pedidos Generados");

        // Crea un ListView en la ventana emergente
        ListView<String> listView = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(App.pgenerados);
        listView.setItems(items);

        // Crea un VBox para contener el ListView
        VBox vbox = new VBox(listView);

        // Crea la escena y agrega el VBox
        Scene scene = new Scene(vbox, 300, 400);
        stage.setScene(scene);

        // Muestra la ventana emergente
        stage.show();

        // Crear y ejecutar un hilo para la actualización de la ventana emergente
        Thread actualizacionVentanaThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5 * 1000); // Espera 5 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Platform.runLater(() -> {
                    // Actualizar los datos del ListView en la ventana emergente
                    items.setAll(App.pgenerados);
                });
            }
        });

        actualizacionVentanaThread.setDaemon(true);
        actualizacionVentanaThread.start();
    }
    
    
}
