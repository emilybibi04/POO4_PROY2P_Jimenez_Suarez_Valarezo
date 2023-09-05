/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.io.IOException;
import java.util.ArrayList;

public class Usuario {
    
    private String name;
    private String genero;
    private String user;
    private String password;
    
    public Usuario(String name, String genero, String user, String password){
        this.name = name;
        this.genero = genero;
        this.user = user;
        this.password = password;
    }
    
    //Getters y Setters
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public String getUser(){
        return user;
    }
    
    public void setUser(String user){
        this.user = user;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    @Override
    public String toString(){
        return name + " " + genero + " " + user + " " + password;
    }
    
    public static ArrayList<Usuario> objetoUsuarios(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        ArrayList<Usuario> usuarios = new ArrayList<>();

        for (String line : lineas){
            String[] elemento = line.trim().split(",");
            String n = elemento[0];
            String g = elemento[1];
            String u = elemento[2];
            String p = elemento[3];
            usuarios.add(new Usuario(n, g, u, p));
        }
        
        return usuarios;
    }
    
    public static boolean comprobarUsuario(String user, String pass, ArrayList<Usuario> lista) {
        for (Usuario u : lista) {
            if (u.getUser().equals(user) && u.getPassword().equals(pass)) {
                return true; // Usuario encontrado, retorna true
            }
        }
        return false; // Usuario no encontrado, retorna false
    }
    
    public static Usuario crearUsuario(String user, String pass, ArrayList<Usuario> lista){
        Usuario persona= null;
        for (Usuario u : lista) {
            if (u.getUser().equals(user) && u.getPassword().equals(pass)) {
                persona=new Usuario(u.name,u.genero,u.user,u.password);

            }        
        }
        return persona;
    }
}
