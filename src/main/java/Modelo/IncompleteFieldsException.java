/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

/**
 * La excepción IncompleteFieldsException se lanza cuando se detectan campos incompletos o faltantes en una operación o entrada.
 * Puede utilizarse para indicar que se esperaban ciertos campos pero no se proporcionaron, lo que resulta en un estado incompleto o inválido.
 */

public class IncompleteFieldsException extends RuntimeException {

    /**
     * Construye una nueva instancia de IncompleteFieldsException con un mensaje de error personalizado.
     *
     * @param message El mensaje de error que describe la causa de la excepción.
     */
    
    public IncompleteFieldsException(String message) {
        super(message);
    }
}
