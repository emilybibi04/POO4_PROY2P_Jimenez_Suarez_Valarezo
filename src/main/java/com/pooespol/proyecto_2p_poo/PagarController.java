/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package com.pooespol.proyecto_2p_poo;

import Modelo.ID;
import Modelo.IncompleteFieldsException;
import static Modelo.Readable.leerArchivo;
import static Modelo.Readable.obtenerFechaActual;
import static Modelo.Readable.redondear;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Esta clase es el controlador para la ventana de pago de la aplicación.
 * Implementa la interfaz Initializable y gestiona las opciones de pago y la generación de órdenes.
 */
public class PagarController implements Initializable {

    @FXML
    RadioButton rbEfectivo;
    
    @FXML
    RadioButton rbTarjeta;
            
    @FXML
    ToggleGroup metodoPago;
    
    @FXML
    Label lbTotal;
    
    @FXML
    Label lbTotalFinal;
    
    @FXML
    Label lbIva;
    
    @FXML
    Label lbAdTarjeta;
    
    @FXML
    Button btnConf;
    
    @FXML
    Button btnCancel;
    
    @FXML 
    Label lbEfectivo;
    
    @FXML
    VBox VBoxContenido;
    
    /**
     * Inicializa el controlador cuando se carga la vista correspondiente.
     *
     * @param url       La ubicación relativa de la vista FXML.
     * @param rb        Un objeto ResourceBundle que se puede utilizar para
     *                  internacionalizar la interfaz de usuario (no se usa en este caso).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lbEfectivo.setText("");
        
        lbTotal.setText("0.00");
        
        lbAdTarjeta.setText("0.00");
        
        lbIva.setText("0.00");
        
        lbTotalFinal.setText("0.00");
        
        btnCancel.setOnMouseClicked(event -> crearNuevaVentana());
    }
    
    /**
     * Realiza el proceso de pago en efectivo y actualiza los campos en la ventana de pago.
     *
     * @param event El evento de acción que desencadenó este método.
     */
    @FXML
    public void pagarEfectivo(ActionEvent event){
        
        lbEfectivo.setText("Acércate a Caja para pagar tu pedido");
        
        double tot=redondear(App.total);
        lbTotal.setText(String.valueOf(tot));
        
        lbAdTarjeta.setText("0.00");
        
        double iva= redondear(App.total*0.12);
        lbIva.setText(String.valueOf(iva));
        
        double ftotal=redondear(tot+iva);
        lbTotalFinal.setText(String.valueOf(ftotal));
        
        App.tipo ='E';
        
        App.fecha=obtenerFechaActual();
    }
    /**
     * Realiza el proceso de pago con tarjeta y actualiza los campos en la ventana de pago.
     *
     * @param event El evento de acción que desencadenó este método.
     */
    @FXML
    public void pagarTarjeta(ActionEvent event){
    
        lbEfectivo.setText("");
        
        double tot=redondear(App.total);
        lbTotal.setText(String.valueOf(tot));
        
        double tarjeta= redondear(App.total*0.10);
        lbAdTarjeta.setText(String.valueOf(tarjeta));
        
        double iva= redondear((tot+tarjeta)*0.12);
        lbIva.setText(String.valueOf(iva));
        
        double ftotal=redondear(tot+iva+tarjeta);
        lbTotalFinal.setText(String.valueOf(ftotal));
        
        App.tipo='C';
        
        
 
    }
    
    /**
     * Genera una orden de pago y realiza las acciones necesarias después de realizar el pago.
     *
     * @throws IOException Si ocurre un error al cargar la vista de la ventana de pago.
     * @throws IncompleteFieldsException Si no se llenaron todos los campos necesarios para continuar con la compra.
     */
    @FXML
    private void generarOrden() throws IOException,IncompleteFieldsException {
        
        if (App.tipo == '\u0000') {
            try {
                throw new IncompleteFieldsException("No ha llenado todos los campos necesarios para continuar con su compra");
            } catch (IncompleteFieldsException e) {
                lbEfectivo.setText(e.getMessage());
            }
        }
        else{
            App.totalPagar=Double.parseDouble(lbTotalFinal.getText());
            
            ID generador = new ID();
            int pid = generador.generarID();
            App.idpago=pid;
            
            App.fecha=obtenerFechaActual();
            
            App.pedido.generarTransaccion();
            
            //actualizar lista de pedidos generados
            ArrayList<String> op = leerArchivo(App.pathH+"pagos.txt");
            op.remove(0);
            App.pgenerados= new ArrayList<>();
            for (String a: op){
                String[] part = a.trim().split(",");
                App.pgenerados.add(part[2]+", "+part[1]);
            }
        
            App.setRoot("PedidoGenerado");
            
            Label nomTarjeta = new Label("Datos de la Tarjeta");
            nomTarjeta.setStyle("-fx-font-family: Bogart Trial; -fx-font-weight: Bold");
            nomTarjeta.setPrefWidth(500);

            VBox vTarjeta = new VBox();
            vTarjeta.setPrefWidth(500);
            vTarjeta.setPrefHeight(241);
            vTarjeta.setStyle("-fx-background-color:  #4D846B");

            HBox uno = new HBox();
            uno.setPrefWidth(444);
            uno.setPrefHeight(44);
            Label unoL = new Label("Nombre:");
            unoL.setPrefWidth(173);
            unoL.setPrefHeight(26);
            unoL.setAlignment(Pos.CENTER_LEFT);
            TextField unoF = new TextField();
            unoF.setPrefWidth(270);
            unoF.setPrefHeight(30);
            uno.getChildren().addAll(unoL, unoF);

            HBox dos = new HBox();
            dos.setPrefWidth(444);
            dos.setPrefHeight(44);
            Label dosL = new Label("Número:");
            dosL.setPrefWidth(173);
            dosL.setPrefHeight(26);
            dosL.setAlignment(Pos.CENTER_LEFT);
            TextField dosF = new TextField();
            dosF.setPrefWidth(270);
            dosF.setPrefHeight(30);
            dos.getChildren().addAll(dosL, dosF);

            HBox tres = new HBox();
            tres.setPrefWidth(444);
            tres.setPrefHeight(44);
            Label tresL = new Label("Fecha Caducidad:");
            tresL.setPrefWidth(173);
            tresL.setPrefHeight(26);
            tresL.setAlignment(Pos.CENTER_LEFT);
            DatePicker tresF = new DatePicker();
            tresF.setPrefWidth(270);
            tresF.setPrefHeight(30);
            tres.getChildren().addAll(tresL, tresF);

            HBox cuatro = new HBox();
            cuatro.setPrefWidth(444);
            cuatro.setPrefHeight(44);
            Label cuatroL = new Label("CVV:");
            cuatroL.setPrefWidth(173);
            cuatroL.setPrefHeight(26);
            cuatroL.setAlignment(Pos.CENTER_LEFT);
            TextField cuatroF = new TextField();
            cuatroF.setPrefWidth(270);
            cuatroF.setPrefHeight(30);
            cuatro.getChildren().addAll(cuatroL, cuatroF);
            
            vTarjeta.getChildren().addAll(uno, dos, tres, cuatro);
            VBoxContenido.getChildren().addAll(vTarjeta);
        }
    }
    
    /**
     * Crea una ventana emergente para confirmar la cancelación de la compra y realizar acciones relacionadas.
     */
    @FXML
    public void crearNuevaVentana() {
        Button bsalir = new Button("Cancelar");

        bsalir.setOnMouseClicked(e -> {
            Stage s = (Stage) bsalir.getScene().getWindow();
            s.close();
        });

        Button baccept = new Button("Aceptar");

        baccept.setOnMouseClicked(e -> {
            Stage s = (Stage) baccept.getScene().getWindow();
            s.close();
            try {
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
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Label l1 = new Label("¿Está seguro de cancelar su compra?");

        VBox detalle = new VBox();
        HBox botones = new HBox();

        botones.getChildren().addAll(baccept, bsalir);
        botones.setPadding(new Insets(5, 5, 5, 5));
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(30);
        
        detalle.getChildren().addAll(l1, botones);

        detalle.setAlignment(Pos.CENTER);
        detalle.setSpacing(10);
        detalle.setPadding(new Insets(5, 5, 5, 5));
        detalle.setStyle("-fx-background-color: #ffe0ff;");

        Scene s = new Scene(detalle, 350, 200);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.setTitle("Mensaje");
        stage.show();
    }  
}