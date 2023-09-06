/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

/**
 * La excepción IncompleteStageException se lanza cuando se encuentra una etapa o proceso incompleto en una operación o flujo de trabajo.
 * Puede utilizarse para indicar que una etapa importante o requerida no se ha completado según lo esperado, lo que puede afectar la continuidad de una tarea o proceso.
 */

public class IncompleteStageException extends Exception {
    
    /**
     * Construye una nueva instancia de IncompleteStageException con un mensaje de error personalizado.
     *
     * @param message El mensaje de error que describe la causa de la excepción.
     */
    
    public IncompleteStageException(String message) {
        super(message);
    }
}
