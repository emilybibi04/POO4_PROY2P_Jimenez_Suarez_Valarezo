/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.util.ArrayList;

/**
 * La clase Helado representa un helado compuesto por una base, toppings y sabores.
 * Permite crear un helado con una base, una lista de toppings y una lista de sabores.
 */

public class Helado {
    
    Base base;
    ArrayList<Toppings> toppings;
    ArrayList<Sabores> sabores;
    
    /**
     * Construye un nuevo objeto Helado con la base, toppings y sabores especificados.
     *
     * @param base     La base del helado.
     * @param toppings La lista de toppings del helado.
     * @param sabores  La lista de sabores del helado.
     */
    
    public Helado(Base base, ArrayList<Toppings> toppings, ArrayList<Sabores> sabores){
        this.base = base;
        this.toppings = toppings;
        this.sabores = sabores;
    }
    
}
