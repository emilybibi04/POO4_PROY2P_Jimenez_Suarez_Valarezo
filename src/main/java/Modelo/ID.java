/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * La clase ID genera identificadores únicos de forma segura.
 * Utiliza números enteros de cuatro dígitos como identificadores.
 */

public class ID {
    
    private Set<Integer> generatedCodes;
    private SecureRandom secureRandom;

    /**
     * Constructor de la clase ID. Inicializa las estructuras de datos y el generador seguro de números aleatorios.
     */
    
    public ID() {
        generatedCodes = new HashSet<>();
        secureRandom = new SecureRandom();
    }

    /**
     * Genera un identificador único de cuatro dígitos de manera segura.
     *
     * @return El identificador único generado.
     */
    
    public int generarID() {
        int code;
        do {
            code = secureRandom.nextInt(9000) + 1000;
        } while (!generatedCodes.add(code));
        
        return code;
    }

}
