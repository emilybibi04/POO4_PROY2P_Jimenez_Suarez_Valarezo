/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.proyecto_2p_poo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Ubicacion {
    
    private double coordenadaX;    
    private double coordenadaY;
    private String nombre;
    private String horario;
    
    public Ubicacion(double coordenadaX, double coordenadaY, String nombre, String horario){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.nombre = nombre;
        this.horario = horario;
    }
    
    public double getCoorX(){
        return coordenadaX;
    }
    
    public void setCoorX(double coordenadaX){
        this.coordenadaX = coordenadaX;
    }
    
    public double getCoorY(){
        return coordenadaY;
    }
    
    public void setCoorY(double coordenadaY){
        this.coordenadaY = coordenadaY;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getHorario(){
        return horario;
    }
    
    public void setHorario(String horario){
        this.horario = horario;
    }
    
    @Override
    public String toString(){
        return coordenadaX + " " + coordenadaY + " " + nombre + " " + horario;
    }
    
    public static ArrayList<Ubicacion> objetoUbicaciones(String nombrearchivo){
    
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<Ubicacion> ubicaciones = new ArrayList<>();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null){
                lineas.add(linea);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (null != fr){
                    fr.close();
                }
            } catch (Exception e2){
                e2.printStackTrace();
            }
        }
        
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

