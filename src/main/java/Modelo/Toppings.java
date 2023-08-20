/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Toppings {
    
    double precio;
    String nombreTopping;
    
    //Constructor de la clase
    public void Topping(double precio, String nombreTopping){
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
    
}
