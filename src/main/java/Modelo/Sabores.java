/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Sabores {
    
    double precio;
    String nombreSabor;
    
    //Constructor de la clase
    public void Sabores(double precio, String nombreSabor){
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
    
}
