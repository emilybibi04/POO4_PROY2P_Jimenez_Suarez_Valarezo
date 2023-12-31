/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto_2p_poo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * Esta clase es el controlador para la ventana que muestra que el pedido ha sido generado con éxito.
 * Implementa la interfaz Initializable y muestra información sobre el pedido y una cuenta regresiva antes de cerrar la ventana.
 */

public class PedidoGeneradoController implements Initializable {

    @FXML
    Label lbPedido1;
    
    @FXML
    Label lbPedido2;
    
    @FXML
    Label lbClose;
    
    /**
     * Inicializa el controlador cuando se carga la vista correspondiente.
     *
     * @param url La ubicación relativa de la vista FXML.
     * @param rb  Un objeto ResourceBundle que se puede utilizar para internacionalizar la interfaz de usuario (no se usa en este caso).
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbPedido2.setText(String.valueOf(App.id));
        
        Thread thread = new Thread(() -> {
            for (int i = 5; i > 0; i--) {
                int finalI = i;
                Platform.runLater(() -> {
                lbClose.setText("Esta ventana se cerrará en " + finalI + " segundos...");
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            Platform.runLater(() -> {
                try {
                    cambiarAMenu();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        });

        thread.start();
    }
    
    /**
     * Cambia a la vista del menú principal después de cerrar la ventana de pedido generado.
     *
     * @throws IOException Si ocurre un error al cargar la vista del menú principal.
     */
    
    @FXML
    private void cambiarAMenu() throws IOException {
        App.total=0.00;
        App.basehelado=null;
        App.saboreshelado.clear();
        if (App.toppingshelado!=null){
            App.toppingshelado.clear();
        }
        
        App.id=0;
        App.idpago=0;
        App.totalPagar=0.00;
        App.tipo = '\u0000';
        
        App.setRoot("VentanaUsuario");

        
    }
    
    
}
