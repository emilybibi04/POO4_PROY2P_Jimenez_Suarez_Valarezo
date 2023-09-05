/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.util.ArrayList;

public class Helado {
    
    Base base;
    ArrayList<Toppings> toppings;
    ArrayList<Sabores> sabores;
    
    public Helado(Base base, ArrayList<Toppings> toppings, ArrayList<Sabores> sabores){
        this.base = base;
        this.toppings = toppings;
        this.sabores = sabores;
    }
    
}
