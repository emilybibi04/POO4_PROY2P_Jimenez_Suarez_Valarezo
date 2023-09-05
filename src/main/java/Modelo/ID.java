/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;


public class ID {
    
    private Set<Integer> generatedCodes;
    private SecureRandom secureRandom;
    

    
    public ID() {
        generatedCodes = new HashSet<>();
        secureRandom = new SecureRandom();
    }
    
    
    public int generarID() {
        int code;
        do {
            code = secureRandom.nextInt(9000) + 1000;
        } while (!generatedCodes.add(code));
        
        return code;
    }
    

}
