/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * La clase Toppings representa un topping o cobertura para helados con un nombre y un precio.
 */

public class Toppings {
    
    double precio;
    String nombreTopping;
    
    //Constructor de la clase
    
    /**
     * Construye un nuevo objeto Toppings con el nombre del topping y su precio.
     *
     * @param nombreTopping El nombre del topping.
     * @param precio        El precio del topping.
     */
    
    public Toppings(String nombreTopping, double precio ){
        this.precio = precio;
        this.nombreTopping = nombreTopping;
    }
    
    //Getters y setters
    
    /**
     * Establece el precio del topping.
     *
     * @param precio El nuevo precio del topping.
     */
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    /**
     * Obtiene el precio del topping.
     *
     * @return El precio del topping.
     */
    
    public double getPrecio(){
        return this.precio;
    }

    /**
     * Obtiene el nombre del topping.
     *
     * @return El nombre del topping.
     */
    
    public String getNombreTopping() {
        return nombreTopping;
    }

    /**
     * Establece el nombre del topping.
     *
     * @param nombreTopping El nuevo nombre del topping.
     */
    
    public void setNombreTopping(String nombreTopping) {
        this.nombreTopping = nombreTopping;
    }
    
    /**
     * Devuelve una representación en forma de cadena de este objeto Toppings.
     *
     * @return Una cadena que contiene el nombre del topping y su precio.
     */
    
    @Override
    public String toString(){
        return this.nombreTopping + " - " + this.precio;
    }
    
    /**
     * Lee las líneas de un archivo de toppings y las devuelve como una lista de cadenas.
     *
     * @param nombrearchivo El nombre del archivo a leer.
     * @return Una lista de cadenas que representan las líneas del archivo.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     */
    
    public static ArrayList<String> lineaToppings(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        
        return lineas;
    }
}
