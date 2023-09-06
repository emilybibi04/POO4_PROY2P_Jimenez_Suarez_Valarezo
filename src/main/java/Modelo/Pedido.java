/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import com.pooespol.proyecto_2p_poo.App;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * La clase Pedido representa un pedido realizado en la aplicación.
 * Contiene información sobre el identificador del pedido, el usuario que realiza el pedido,
 * el helado solicitado y el total a pagar.
 */

public class Pedido implements Serializable,Pagable{
    int id;
    Usuario usuario;
    Helado helado;
    double total;
    
    /**
     * Construye un nuevo objeto Pedido con los detalles del pedido.
     *
     * @param id      El identificador único del pedido.
     * @param usuario El usuario que realiza el pedido.
     * @param helado  El helado solicitado en el pedido.
     * @param total   El total a pagar por el pedido.
     */
    
    public Pedido(int id, Usuario usuario, Helado helado, double total) {
        this.id = id;
        this.usuario = usuario;
        this.helado = helado;
        this.total = total;
    }

    // Métodos getter y setter para acceder a los atributos
    
    /**
     * Obtiene el identificador único del pedido.
     *
     * @return El identificador único del pedido.
     */
    
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del pedido.
     *
     * @param id El nuevo identificador único del pedido.
     */
    
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el usuario que realiza el pedido.
     *
     * @return El usuario que realiza el pedido.
     */
    
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realiza el pedido.
     *
     * @param usuario El nuevo usuario que realiza el pedido.
     */
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el helado solicitado en el pedido.
     *
     * @return El helado solicitado en el pedido.
     */
    
    public Helado getHelado() {
        return helado;
    }

    /**
     * Establece el helado solicitado en el pedido.
     *
     * @param helado El nuevo helado solicitado en el pedido.
     */
    
    public void setHelado(Helado helado) {
        this.helado = helado;
    }

    /**
     * Obtiene el total a pagar por el pedido.
     *
     * @return El total a pagar por el pedido.
     */
    
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total a pagar por el pedido.
     *
     * @param total El nuevo total a pagar por el pedido.
     */
    
    public void setTotal(double total) {
        this.total = total;
    }
    //metodo toString
    
    /**
     * Devuelve una representación en forma de cadena de este objeto Pedido.
     *
     * @return Una cadena que contiene los detalles clave del pedido, separados por comas.
     */
    
    public String toString(){
        return id+","+usuario.getName()+","+total;
    }
    
    /**
     * Genera una transacción de pago para este pedido y registra los detalles del pago en un archivo de registro.
     */
    
    @Override
    public void generarTransaccion(){
        Pago pago= new Pago(App.idpago,App.pedido,App.totalPagar,App.fecha,App.tipo);
        FileWriter writer=null;
        try{
            writer= new FileWriter(App.pathH+"pagos.txt",true);
            writer.write(pago+"\n");

        }catch(IOException ex){
            ex.printStackTrace();
        } finally{
            try{
                writer.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
