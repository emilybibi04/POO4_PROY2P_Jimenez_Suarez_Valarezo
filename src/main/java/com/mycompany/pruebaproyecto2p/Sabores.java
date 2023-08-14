/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaproyecto2p;

/**
 *
 * @author gabsjimz
 */
public class Sabores {
    double precio;
    String nombreSabor;
    
    //constructor de la clase
    public void Sabores(double precio, String nombreSabor){
        this.precio = precio;
        this.nombreSabor = nombreSabor;
    }
    
    
    
    //getters y setters
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
    
    
}
