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
 *
 * @author davidsuarez
 */
public class Pedido implements Serializable,Pagable{
    int id;
    Usuario usuario;
    Helado helado;
    double total;
    
    public Pedido(int id, Usuario usuario, Helado helado, double total) {
        this.id = id;
        this.usuario = usuario;
        this.helado = helado;
        this.total = total;
    }

    // Métodos getter y setter para acceder a los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Helado getHelado() {
        return helado;
    }

    public void setHelado(Helado helado) {
        this.helado = helado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    //metodo toString
    public String toString(){
        return id+","+usuario.getName()+","+total;
    }
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
