/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto_2p_poo;

import Modelo.ID;
import Modelo.IncompleteFieldsException;
import static Modelo.Readable.obtenerFechaActual;
import static Modelo.Readable.redondear;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author davidsuarez
 */
public class PagarController implements Initializable {

    /**
     * Initializes the controller class.
     */
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lbTotal.setText("0.00");
        
        lbAdTarjeta.setText("0.00");
        
        lbIva.setText("0.00");
        
        lbTotalFinal.setText("0.00");
        
    }
    
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
        
        
            //App.setRoot(""); poner la ultima escena
        }
    }
    
    
}
