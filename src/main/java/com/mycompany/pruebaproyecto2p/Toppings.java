/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaproyecto2p;

/**
 *
 * @author gabsjimz
 */
public class Toppings {
    
    double precio;
    String nombreTopping;
    
    //constructor de la clase
    public void Topping(double precio, String nombreTopping){
        this.precio = precio;
        this.nombreTopping = nombreTopping;
    }
    
    
    
    //getters y setters
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
    
    
}
