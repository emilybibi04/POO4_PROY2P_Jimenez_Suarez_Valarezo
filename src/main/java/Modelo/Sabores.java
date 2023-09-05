/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.io.IOException;
import java.util.ArrayList;

public class Sabores implements Comparable<Sabores>{
    
    double precio;
    String nombreSabor;
    
    //Constructor de la clase
    public Sabores(String nombreSabor, double precio){
        this.precio = precio;
        this.nombreSabor = nombreSabor;
    }
    
    //Getters y setters
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public double getPrecio(){
        return this.precio;
    }

    public String getNombreSabor() {
        return nombreSabor;
    }

    public void setNombreSabor(String nombreSabor) {
        this.nombreSabor = nombreSabor;
    }
    
    //sobreescritura equalsTo()
    @Override
    public int compareTo(Sabores s){
        return this.nombreSabor.compareTo(s.nombreSabor);
    }
    
    @Override
    public String toString(){
        return this.nombreSabor + " - " + this.precio;
    }
    
    public static ArrayList<String> lineaSabores(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        
        return lineas;
    }
    
}
