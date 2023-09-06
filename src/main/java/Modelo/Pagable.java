/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

/**
 * La interfaz Pagable define un contrato para objetos que pueden generar transacciones de pago.
 * Las clases que implementan esta interfaz deben proporcionar una implementación del método generarTransaccion
 * para realizar una transacción de pago específica.
 */

public interface Pagable {
    
    /**
     * Genera una transacción de pago.
     * La implementación de este método debe realizar la lógica necesaria para completar la transacción de pago.
     */
    
    void generarTransaccion();
}
