/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.opcion2_proyecto2p;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gabsjimz
 */
public interface Readable{

    ArrayList<String> lineas = new ArrayList<String>();
    
    default ArrayList<String> leerArchivo(String nombreArchivo){
        
        //Lectura del archivo y obtencion de informacion (se agrega en el Array)
        try(BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            while((linea = lector.readLine())!=null){
                lineas.add(linea);
            }
        //Excepciones
        }catch(FileNotFoundException e1){
            System.out.println("Archivo no encontrado");
        } catch(IOException e2){
            System.out.println("Error de entrada/salida");
        }
        
        return lineas;
    }
}
