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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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