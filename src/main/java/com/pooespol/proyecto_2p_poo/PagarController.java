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
import java.time.LocalDate;
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
    
    @FXML
    VBox vboxGreen;
    
    @FXML
    Label lblTarjeta;
    
    @FXML
    HBox h1;
    
    @FXML
    HBox h2;
    
    @FXML
    HBox h3;
    
    @FXML
    HBox h4;
    
    @FXML
    Label l1;
    
    @FXML
    Label l2;
    
    @FXML
    Label l3;
    
    @FXML
    Label l4;
    
    private TextField unoF= new TextField();
    private TextField dosF= new TextField();
    private DatePicker tresF= new DatePicker();
    private TextField cuatroF= new TextField();
    private boolean check=true;
    
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
        
        lbTotal.setText("  0.00");
        
        lbAdTarjeta.setText("  0.00");
        
        lbIva.setText("  0.00");
        
        lbTotalFinal.setText("  0.00");
        
        btnCancel.setOnMouseClicked(event -> crearNuevaVentana());
    }
    
    /**
     * Realiza el proceso de pago en efectivo y actualiza los campos en la ventana de pago.
     *
     * @param event El evento de acción que desencadenó este método.
     */
    
    @FXML
    public void pagarEfectivo(ActionEvent event){
        
        VBoxContenido.setVisible(false);
        if (h1.getChildren().size() > 1) {
            h1.getChildren().remove(1); 
        }
        if (h2.getChildren().size() > 1) {
            h2.getChildren().remove(1);
        }
        if (h3.getChildren().size() > 1) {
            h3.getChildren().remove(1); 
        }
        if (h3.getChildren().size() > 1) {
            h3.getChildren().remove(1); 
        }
        if (h4.getChildren().size() > 1) {
            h4.getChildren().remove(1); 
        }
        
        
        
        lbEfectivo.setText("Acércate a Caja para pagar tu pedido");
        
        double tot=redondear(App.total);
        lbTotal.setText("  " + String.valueOf(tot));
        
        lbAdTarjeta.setText("  " + "0.00");
        
        double iva= redondear(App.total*0.12);
        lbIva.setText("  " + String.valueOf(iva));
        
        double ftotal=redondear(tot+iva);
        lbTotalFinal.setText("  " + String.valueOf(ftotal));
        
        App.tipo ='E';
        
        App.fecha=obtenerFechaActual();
        
        unoF.setText("a");
        dosF.setText("a");
        LocalDate defaultDate = LocalDate.of(2023, 9, 5);
        tresF.setValue(defaultDate);
        cuatroF.setText("a");
    }
    /**
     * Realiza el proceso de pago con tarjeta y actualiza los campos en la ventana de pago.
     *
     * @param event El evento de acción que desencadenó este método.
     */
    
    @FXML
    public void pagarTarjeta(ActionEvent event){
        
        VBoxContenido.setVisible(true);
        
        lbEfectivo.setText("");
        
        double tot=redondear(App.total);
        lbTotal.setText("  " + String.valueOf(tot));
        
        double tarjeta= redondear(App.total*0.10);
        lbAdTarjeta.setText("  " + String.valueOf(tarjeta));
        
        double iva= redondear((tot+tarjeta)*0.12);
        lbIva.setText("  " + String.valueOf(iva));
        
        double ftotal=redondear(tot+iva+tarjeta);
        lbTotalFinal.setText("  " + String.valueOf(ftotal));
        
        App.tipo='C';
        
        lblTarjeta.setText("Datos de la Tarjeta");

        vboxGreen.setStyle("-fx-background-color: #4D846B");

        l1.setText("Nombre:");
        unoF = new TextField();
        unoF.setPrefWidth(270);
        unoF.setPrefHeight(30);
        h1.getChildren().addAll(unoF);

        l2.setText("Número:");
        dosF = new TextField();
        dosF.setPrefWidth(270);
        dosF.setPrefHeight(30);
        h2.getChildren().addAll(dosF);

        l3.setText("Caducidad:");
        tresF = new DatePicker();
        tresF.setPrefWidth(270);
        tresF.setPrefHeight(30);
        h3.getChildren().addAll(tresF);

        l4.setText("CVV:");
        cuatroF = new TextField();
        cuatroF.setPrefWidth(270);
        cuatroF.setPrefHeight(30);
        h4.getChildren().addAll(cuatroF);
        
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
                throw new IncompleteFieldsException("Complete todos los campos para continuar la compra");
            } catch (IncompleteFieldsException e) {
                lbEfectivo.setText(e.getMessage());
            }
        } else {
            check = camposTarjetaEstanCompletos();
            if (!check) {
                try {
                    throw new IncompleteFieldsException("Rellene los datos de su tarjeta");
                } catch (IncompleteFieldsException e) {
                    lbEfectivo.setText(e.getMessage());
                }
            } else {
                App.totalPagar = Double.parseDouble(lbTotalFinal.getText());

                ID generador = new ID();
                int pid = generador.generarID();
                App.idpago = pid;

                App.fecha = obtenerFechaActual();

                App.pedido.generarTransaccion();

                // Actualizar lista de pedidos generados
                ArrayList<String> op = leerArchivo(App.pathH + "pagos.txt");
                op.remove(0);
                App.pgenerados = new ArrayList<>();
                for (String a : op) {
                    String[] part = a.trim().split(",");
                    App.pgenerados.add(part[2] + ", " + part[1]);
                }

                App.setRoot("PedidoGenerado");
            }
        }
    }
    
    /**
     * Crea una ventana emergente para confirmar la cancelación de la compra y realizar acciones relacionadas.
     */
    
    @FXML
    public void crearNuevaVentana() {
        Button bsalir = new Button("Cancelar");
        bsalir.setStyle("-fx-background-color: white; -fx-font-family: 'Avenir Next'; -fx-text-fill: #366952; -fx-font-size: 16px");
        bsalir.setOnMouseClicked(e -> {
            Stage s = (Stage) bsalir.getScene().getWindow();
            s.close();
        });

        Button baccept = new Button("Aceptar");
        baccept.setStyle("-fx-background-color: white; -fx-font-family: 'Avenir Next'; -fx-text-fill: #366952; -fx-font-size: 16px");
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

        Label l1 = new Label("¿Está seguro de");
        l1.setStyle("-fx-font-family: 'Avenir Next'; -fx-font-weight: bold; -fx-font-size: 22px; -fx-text-fill: white");
        
        Label l2 = new Label("cancelar su compra?");
        l2.setStyle("-fx-font-family: 'Avenir Next'; -fx-font-weight: bold; -fx-font-size: 22px; -fx-text-fill: white");
        
        VBox detalle = new VBox();
        VBox espacio = new VBox();
        espacio.setPrefHeight(15);
        HBox botones = new HBox();

        botones.getChildren().addAll(baccept, bsalir);
        botones.setPadding(new Insets(5, 5, 5, 5));
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(30);
        
        detalle.getChildren().addAll(l1, l2, espacio, botones);

        detalle.setAlignment(Pos.CENTER);
        detalle.setPadding(new Insets(-12, -12, -12, -12));
        detalle.setStyle("-fx-background-color: #8EBD88;");

        Scene s = new Scene(detalle, 420, 250);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.setTitle("Mensaje");
        stage.show();
    }  
    
    /**
     * Verifica si los campos de tarjeta de crédito están completos y válidos.
     *
     * @return `true` si los campos están completos y válidos, `false` de lo contrario.
     */
    
    private boolean camposTarjetaEstanCompletos() {
        // Verificar si las variables de instancia no son nulas y contienen valores válidos
        return unoF != null && dosF != null && tresF != null && cuatroF != null
                && !unoF.getText().isEmpty() && !dosF.getText().isEmpty()
                && tresF.getValue() != null && !cuatroF.getText().isEmpty();
    }
}