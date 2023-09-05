/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto_2p_poo;

import Modelo.Helado;
import Modelo.ID;
import Modelo.Pedido;
import static Modelo.Readable.escribirPedidos;
import static Modelo.Readable.serializarPedidos;
import Modelo.Sabores;
import Modelo.Toppings;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author davidsuarez
 */
public class TuPedidoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView<String> lista;
    
    @FXML
    private Button btnEliminar;
    
    @FXML
    private Button btnConfirmar;
    
    @FXML
    private Button btnCancelar;
    
    @FXML
    private Label lbPagar;
    
    @FXML
    private Label lbMsg;
    
    private ObservableList<String> elementos = FXCollections.observableArrayList(); // Usar ObservableList para una actualización automática
    
    private boolean check = false;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        elementos.add("Base: " + App.basehelado.getNombreBase());
        
        for (Sabores sabor : App.saboreshelado) {
            if (sabor != null) {
                elementos.add("Sabor: " + sabor.getNombreSabor());
            }
        }
        
        if (App.toppingshelado != null) {
            for (Toppings topping : App.toppingshelado) {
                elementos.add("Topping: " + topping.getNombreTopping());
            }
        }
        
        // Configurar la ListView y agregar elementos
        lista.setItems(elementos);
        
        lbPagar.setText("Valor a pagar: " + App.total);
        
        btnEliminar.setOnAction(this::eliminarSabor);
        
        btnCancelar.setOnMouseClicked(event -> crearNuevaVentana2());

    }

    private void eliminarSabor(ActionEvent event) {
    // Obtener el elemento seleccionado en la ListView
    lbMsg.setText("");
            
    String selectedElement = lista.getSelectionModel().getSelectedItem();

    if (selectedElement != null && selectedElement.startsWith("Sabor: ")) {
        // Verificar que haya al menos dos sabores presentes antes de eliminar uno
        if (contarSabores() >= 2) {
            // Mostrar la ventana emergente y esperar hasta que se cierre
            crearNuevaVentana(event);

            // Comprobar el resultado de la ventana emergente
            if (check) {
                // Si se hizo clic en "Aceptar", eliminar el sabor seleccionado
                elementos.remove(selectedElement);
                actualizarTotal(selectedElement);
            } 
        } else {
            // Mostrar un mensaje de error si no hay suficientes sabores
            lbMsg.setText("Tiene que haber mínimo un sabor en la lista.");
        }
    } else {
        // Mostrar un mensaje de error si el elemento no es un sabor
        lbMsg.setText("Solo se pueden eliminar sabores.");
    }
}
    //metodo para saber si los sabores del ListView
    private int contarSabores() {
        int contadorSabores = 0;
        for (String elemento : elementos) {
            if (elemento.startsWith("Sabor: ")) {
                contadorSabores++;
            }
        }
        return contadorSabores;
    }

    private void actualizarTotal(String elegido) {
        double menos= 0.0;
        try {
            ArrayList<String> datosSabores = Sabores.lineaSabores(App.pathI+"sabores.txt");
            
            for (String a: datosSabores){
                int indiceInicio = elegido.indexOf(":") + 2; // Suma 2 para saltar el espacio
                String sabor = elegido.substring(indiceInicio);
                
                String[] parte= a.trim().split(",");
                if (sabor.equals(parte[0])){
                    menos= Double.parseDouble(parte[1]);
                }
                
            }
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        App.total= Math.round((App.total-menos) * 100.0) / 100.0;
        
        
        lbPagar.setText("Valor a pagar: " + App.total);
    }
    
    @FXML
    public void crearNuevaVentana(ActionEvent event) {
        CompletableFuture<Boolean> future = new CompletableFuture<>();

        Button bsalir = new Button("Cancelar");
        bsalir.setStyle("-fx-background-color: #ffd463;");
        bsalir.setOnMouseClicked(e -> {
            Stage s = (Stage) bsalir.getScene().getWindow();
            s.close();
            future.complete(false); // Establecer el resultado como falso
        });

        Button baccept = new Button("Aceptar");
        baccept.setStyle("-fx-background-color: #ffd463;");

        baccept.setOnMouseClicked(e -> {
            Stage s = (Stage) baccept.getScene().getWindow();
            s.close();
            future.complete(true); // Establecer el resultado como verdadero
        });

        Label l1 = new Label("¿Está seguro de eliminar el componente?");
        l1.setStyle("-fx-font-weight: bold;");

        
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


        Scene scene = new Scene(detalle, 350, 200);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Mensaje");
        stage.showAndWait(); // Mostrar la ventana y esperar hasta que se cierre

        // Esperar a que el usuario haga clic en uno de los botones y luego obtener el resultado del CompletableFuture
        try {
            check = future.get();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    

    
    @FXML
    public void crearNuevaVentana2() {
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
                App.toppingshelado.clear();
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
    
    @FXML
    private void cambiarAPasoPago2() throws IOException {
        
        ID generador = new ID();
        int nid = generador.generarID();
        App.id=nid;
        
        Helado h=new Helado(App.basehelado,App.toppingshelado,App.saboreshelado);
        App.helado=h;
        
        Pedido p= new Pedido(App.id, App.cliente,App.helado,App.total);
        App.pedido=p;
        
        escribirPedidos(p,App.pathH+"pedidos.txt");
        
        serializarPedidos(p);
                
        App.setRoot("Pagar");
        
    }

}
