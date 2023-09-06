/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * La clase Base representa una base con un nombre y un precio.
 * Proporciona métodos para obtener y establecer el nombre y el precio de la base.
 * También incluye un método para leer líneas de un archivo.
 */

public class Base {
    
    private double precio;
    private String nombreBase;

    
    /**
     * Construye un nuevo objeto Base con el nombre y el precio dados.
     *
     * @param nombreBase El nombre de la base.
     * @param precio     El precio de la base.
     */

    public Base(String nombreBase, double precio){
        this.precio = precio;
        this.nombreBase = nombreBase;
    }
    
    //Getters y setters
    
    /**
     * Establece el precio de la base.
     *
     * @param precio El nuevo precio de la base.
     */
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    /**
     * Obtiene el precio de la base.
     *
     * @return El precio de la base.
     */
    
    public double getPrecio(){
        return this.precio;
    }

    /**
     * Obtiene el nombre de la base.
     *
     * @return El nombre de la base.
     */
    
    public String getNombreBase() {
        return nombreBase;
    }

    /**
     * Establece el nombre de la base.
     *
     * @param nombreBase El nuevo nombre de la base.
     */
    
    public void setNombreSabor(String nombreBase) {
        this.nombreBase = nombreBase;
    }
    
    /**
     * Lee líneas de un archivo y las devuelve como un ArrayList de cadenas.
     *
     * @param nombrearchivo El nombre del archivo que se va a leer.
     * @return Un ArrayList de cadenas que representan las líneas leídas del archivo.
     * @throws IOException Si ocurre un error de E/S al leer el archivo.
     */
    
    public static ArrayList<String> lineaBases(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        
        return lineas;
    }
    
}
