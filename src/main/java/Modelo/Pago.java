/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author davidsuarez
 */
public class Pago {
    int idPago;
    Pedido pedido;
    double totalPagar;
    String fecha;
    char tipo;
    
    public Pago(int idPago, Pedido pedido, double totalPagar, String fecha, char tipo) {
        this.idPago = idPago;
        this.pedido = pedido;
        this.totalPagar = totalPagar;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    // Getters y setters (métodos para acceder y modificar los atributos)
    
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    public String toString(){
        return this.idPago+","+this.pedido.getId()+","+this.pedido.getUsuario().getName()+","+this.totalPagar+","+this.fecha+","+this.tipo;
    }
}
