/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * La clase Sabores representa un sabor de helado con un nombre y un precio.
 * Implementa la interfaz Comparable para permitir la comparación de sabores.
 */

public class Sabores implements Comparable<Sabores>{
    
    double precio;
    String nombreSabor;
    
    //Constructor de la clase
    
    /**
     * Construye un nuevo objeto Sabores con el nombre del sabor y su precio.
     *
     * @param nombreSabor El nombre del sabor.
     * @param precio      El precio del sabor.
     */
    
    public Sabores(String nombreSabor, double precio){
        this.precio = precio;
        this.nombreSabor = nombreSabor;
    }
    
    //Getters y setters
    
    /**
     * Establece el precio del sabor.
     *
     * @param precio El nuevo precio del sabor.
     */
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    /**
     * Obtiene el precio del sabor.
     *
     * @return El precio del sabor.
     */
    
    public double getPrecio(){
        return this.precio;
    }

    /**
     * Obtiene el nombre del sabor.
     *
     * @return El nombre del sabor.
     */
    
    public String getNombreSabor() {
        return nombreSabor;
    }

    /**
     * Establece el nombre del sabor.
     *
     * @param nombreSabor El nuevo nombre del sabor.
     */
    
    public void setNombreSabor(String nombreSabor) {
        this.nombreSabor = nombreSabor;
    }
    
    //sobreescritura equalsTo()
    
    /**
     * Compara dos sabores en función de sus nombres.
     *
     * @param s El sabor a comparar.
     * @return Un valor negativo si este sabor es menor que el sabor proporcionado,
     *         un valor positivo si es mayor y 0 si son iguales.
     */
    
    @Override
    public int compareTo(Sabores s){
        return this.nombreSabor.compareTo(s.nombreSabor);
    }
    
    /**
     * Devuelve una representación en forma de cadena de este objeto Sabores.
     *
     * @return Una cadena que contiene el nombre del sabor y su precio.
     */
    
    @Override
    public String toString(){
        return this.nombreSabor + " - " + this.precio;
    }
    
    /**
     * Lee las líneas de un archivo de sabores y las devuelve como una lista de cadenas.
     *
     * @param nombrearchivo El nombre del archivo a leer.
     * @return Una lista de cadenas que representan las líneas del archivo.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     */
    
    public static ArrayList<String> lineaSabores(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        
        return lineas;
    }
    
}
