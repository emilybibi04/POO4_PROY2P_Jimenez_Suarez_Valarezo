/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * La clase Usuario representa un usuario con nombre, género, nombre de usuario (user) y contraseña (password).
 */

public class Usuario {
    
    private String name;
    private String genero;
    private String user;
    private String password;
    
    /**
     * Construye un nuevo objeto Usuario con nombre, género, nombre de usuario y contraseña.
     *
     * @param name     El nombre del usuario.
     * @param genero   El género del usuario.
     * @param user     El nombre de usuario.
     * @param password La contraseña del usuario.
     */
    
    public Usuario(String name, String genero, String user, String password){
        this.name = name;
        this.genero = genero;
        this.user = user;
        this.password = password;
    }
    
    //Getters y Setters
    
    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    
    public String getName(){
        return name;
    }
    
    /**
     * Establece el nombre del usuario.
     *
     * @param name El nuevo nombre del usuario.
     */
    
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Obtiene el género del usuario.
     *
     * @return El género del usuario.
     */
    
    public String getGenero(){
        return genero;
    }
    
    /**
     * Establece el género del usuario.
     *
     * @param genero El nuevo género del usuario.
     */
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    
    public String getUser(){
        return user;
    }
    
    /**
     * Establece el nombre de usuario.
     *
     * @param user El nuevo nombre de usuario.
     */
    
    public void setUser(String user){
        this.user = user;
    }
    
    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    
    public String getPassword(){
        return password;
    }
    
    /**
     * Establece la contraseña del usuario.
     *
     * @param password La nueva contraseña del usuario.
     */
    
    public void setPassword(String password){
        this.password = password;
    }
    
    /**
     * Devuelve una representación en forma de cadena de este objeto Usuario.
     *
     * @return Una cadena que contiene el nombre, género, nombre de usuario y contraseña del usuario.
     */
    
    @Override
    public String toString(){
        return name + " " + genero + " " + user + " " + password;
    }
    
    /**
     * Lee las líneas de un archivo de usuarios y las convierte en una lista de objetos Usuario.
     *
     * @param nombrearchivo El nombre del archivo a leer.
     * @return Una lista de objetos Usuario que representan los usuarios del archivo.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     */
    
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
    
    /**
     * Comprueba si un usuario y contraseña coinciden con los registrados en una lista de usuarios.
     *
     * @param user  El nombre de usuario a comprobar.
     * @param pass  La contraseña a comprobar.
     * @param lista La lista de usuarios registrados.
     * @return true si el usuario y la contraseña coinciden con un usuario en la lista, false en caso contrario.
     */
    
    public static boolean comprobarUsuario(String user, String pass, ArrayList<Usuario> lista) {
        for (Usuario u : lista) {
            if (u.getUser().equals(user) && u.getPassword().equals(pass)) {
                return true; // Usuario encontrado, retorna true
            }
        }
        return false; // Usuario no encontrado, retorna false
    }
    
    /**
     * Crea un nuevo objeto Usuario a partir del nombre de usuario y contraseña proporcionados,
     * utilizando información de una lista de usuarios.
     *
     * @param user  El nombre de usuario a crear.
     * @param pass  La contraseña a crear.
     * @param lista La lista de usuarios registrados.
     * @return Un objeto Usuario si se encuentra una coincidencia en la lista, o null si no se encuentra.
     */
    
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
