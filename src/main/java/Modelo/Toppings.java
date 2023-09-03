/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.IOException;
import java.util.ArrayList;

public class Toppings {
    
    double precio;
    String nombreTopping;
    
    //Constructor de la clase
    public Toppings(String nombreTopping, double precio ){
        this.precio = precio;
        this.nombreTopping = nombreTopping;
    }
    
    //Getters y setters
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public double getPrecio(){
        return this.precio;
    }

    public String getNombreTopping() {
        return nombreTopping;
    }

    public void setNombreTopping(String nombreTopping) {
        this.nombreTopping = nombreTopping;
    }
    
    @Override
    public String toString(){
        return this.nombreTopping+" - "+this.precio;
    }
    public static ArrayList<String> lineaToppings(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        
        return lineas;
    }
}
