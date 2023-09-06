/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * La clase Ubicacion representa una ubicación geográfica con coordenadas, nombre y horario.
 */

public class Ubicacion {
    
    private double coordenadaX;    
    private double coordenadaY;
    private String nombre;
    private String horario;
    
    /**
     * Construye un nuevo objeto Ubicacion con coordenadas, nombre y horario.
     *
     * @param coordenadaX Coordenada X de la ubicación.
     * @param coordenadaY Coordenada Y de la ubicación.
     * @param nombre      Nombre de la ubicación.
     * @param horario     Horario de la ubicación.
     */
    
    public Ubicacion(double coordenadaX, double coordenadaY, String nombre, String horario){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.nombre = nombre;
        this.horario = horario;
    }
    
    //Getters y Setters
    
    /**
     * Obtiene la coordenada X de la ubicación.
     *
     * @return La coordenada X de la ubicación.
     */
    
    public double getCoorX(){
        return coordenadaX;
    }
    
    /**
     * Establece la coordenada X de la ubicación.
     *
     * @param coordenadaX La nueva coordenada X de la ubicación.
     */
    
    public void setCoorX(double coordenadaX){
        this.coordenadaX = coordenadaX;
    }
    
    /**
     * Obtiene la coordenada Y de la ubicación.
     *
     * @return La coordenada Y de la ubicación.
     */
    
    public double getCoorY(){
        return coordenadaY;
    }
    
    /**
     * Establece la coordenada Y de la ubicación.
     *
     * @param coordenadaY La nueva coordenada Y de la ubicación.
     */
    
    public void setCoorY(double coordenadaY){
        this.coordenadaY = coordenadaY;
    }
    
    /**
     * Obtiene el nombre de la ubicación.
     *
     * @return El nombre de la ubicación.
     */
    
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Establece el nombre de la ubicación.
     *
     * @param nombre El nuevo nombre de la ubicación.
     */
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el horario de la ubicación.
     *
     * @return El horario de la ubicación.
     */
    
    public String getHorario(){
        return horario;
    }
    
    /**
     * Establece el horario de la ubicación.
     *
     * @param horario El nuevo horario de la ubicación.
     */
    
    public void setHorario(String horario){
        this.horario = horario;
    }
    
    /**
     * Devuelve una representación en forma de cadena de este objeto Ubicacion.
     *
     * @return Una cadena que contiene las coordenadas, nombre y horario de la ubicación.
     */
    
    @Override
    public String toString(){
        return getCoorX() + " " + coordenadaY + " " + nombre + " " + horario;
    }
    
    /**
     * Lee las líneas de un archivo de ubicaciones y las convierte en una lista de objetos Ubicacion.
     *
     * @param nombrearchivo El nombre del archivo a leer.
     * @return Una lista de objetos Ubicacion que representan las ubicaciones del archivo.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     */
    
    public static ArrayList<Ubicacion> objetoUbicaciones(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        ArrayList<Ubicacion> ubicaciones = new ArrayList<>();

        for (String line : lineas){
            String[] elemento = line.trim().split(",");
            double coorX = Double.parseDouble(elemento[0]);
            double coorY = Double.parseDouble(elemento[1]);
            String nombre = elemento[2];
            String horario = elemento[3];
            ubicaciones.add(new Ubicacion(coorX, coorY, nombre, horario));
        }
        
        return ubicaciones;
    }
    
}

