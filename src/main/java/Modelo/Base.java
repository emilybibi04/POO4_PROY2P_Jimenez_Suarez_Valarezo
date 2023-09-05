/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.io.IOException;
import java.util.ArrayList;

public class Base {
    
    private double precio;
    private String nombreBase;

    
    //Constructor de la clase
    public Base(String nombreBase, double precio){
        this.precio = precio;
        this.nombreBase = nombreBase;
    }
    
    //Getters y setters
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public double getPrecio(){
        return this.precio;
    }

    public String getNombreBase() {
        return nombreBase;
    }

    public void setNombreSabor(String nombreBase) {
        this.nombreBase = nombreBase;
    }
    
    public static ArrayList<String> lineaBases(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        
        return lineas;
    }
    
}
