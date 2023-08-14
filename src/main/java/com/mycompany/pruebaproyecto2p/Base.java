/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaproyecto2p;

/**
 *
 * @author gabsjimz
 */
public class Base {
    double precio;
    String nombreBase;
    
    //constructor de la clase
    public void Base(double precio, String nombreBase){
        this.precio = precio;
        this.nombreBase = nombreBase;
    }
    
    
    
    //getters y setters
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
    
    
}
