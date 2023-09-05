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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaUsuarioController implements Initializable {
    
    @FXML
    Label lblBienvenido;
    
    @FXML
    Label lblNombre;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String genero = App.cliente.getGenero();
        if (genero.equals("f")){
            lblBienvenido.setText("B I E N V E N I D A");
        }
        else
            lblBienvenido.setText("B I E N V E N I D O");
        lblNombre.setText(App.cliente.getName());
        
        //actuualizar lista de pedidos generados
        ArrayList<String> op = leerArchivo(App.pathH + "pagos.txt");
        op.remove(0);
        for (String a: op){
            String[] part = a.trim().split(",");
            App.pgenerados.add(part[2] + ", " + part[1]);
        }
        mostrarVentanaEmergente();
        
    }    
    
    @FXML
    private void switchUbicaciones() throws IOException {
        App.setRoot("Ubicaciones");
    }
    
    @FXML
    private void switchHelado() throws IOException {
        App.setRoot("Paso1");
    }
    
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
