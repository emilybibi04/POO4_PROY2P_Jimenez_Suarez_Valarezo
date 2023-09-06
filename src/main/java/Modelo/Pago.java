/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

/**
 * La clase Pago representa una transacción de pago realizada en la aplicación.
 * Contiene información sobre el identificador del pago, el pedido asociado, el monto total a pagar, la fecha y el tipo de pago.
 */

public class Pago {
    int idPago;
    Pedido pedido;
    double totalPagar;
    String fecha;
    char tipo;
    
    /**
     * Construye un nuevo objeto Pago con los detalles de la transacción.
     *
     * @param idPago     El identificador único del pago.
     * @param pedido     El pedido asociado a este pago.
     * @param totalPagar El monto total a pagar en la transacción.
     * @param fecha      La fecha en la que se realizó el pago.
     * @param tipo       El tipo de pago (por ejemplo, 'E' para efectivo, 'T' para tarjeta).
     */
    
    public Pago(int idPago, Pedido pedido, double totalPagar, String fecha, char tipo) {
        this.idPago = idPago;
        this.pedido = pedido;
        this.totalPagar = totalPagar;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    // Getters y setters (métodos para acceder y modificar los atributos)
    
    /**
     * Obtiene el identificador único del pago.
     *
     * @return El identificador único del pago.
     */
    
    public int getIdPago() {
        return idPago;
    }

    /**
     * Establece el identificador único del pago.
     *
     * @param idPago El nuevo identificador único del pago.
     */
    
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    /**
     * Obtiene el pedido asociado a este pago.
     *
     * @return El pedido asociado a este pago.
     */
    
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * Establece el pedido asociado a este pago.
     *
     * @param pedido El nuevo pedido asociado a este pago.
     */
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * Obtiene el monto total a pagar en la transacción.
     *
     * @return El monto total a pagar en la transacción.
     */
    
    public double getTotalPagar() {
        return totalPagar;
    }

    /**
     * Establece el monto total a pagar en la transacción.
     *
     * @param totalPagar El nuevo monto total a pagar en la transacción.
     */
    
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * Obtiene la fecha en la que se realizó el pago.
     *
     * @return La fecha en la que se realizó el pago.
     */
    
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se realizó el pago.
     *
     * @param fecha La nueva fecha en la que se realizó el pago.
     */
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el tipo de pago (por ejemplo, 'E' para efectivo, 'T' para tarjeta).
     *
     * @return El tipo de pago.
     */
    
    public char getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de pago (por ejemplo, 'E' para efectivo, 'T' para tarjeta).
     *
     * @param tipo El nuevo tipo de pago.
     */
    
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Devuelve una representación en forma de cadena de este objeto Pago.
     *
     * @return Una cadena que contiene los detalles clave del pago, separados por comas.
     */
    
    public String toString(){
        return this.idPago+","+this.pedido.getId()+","+this.pedido.getUsuario().getName()+","+this.totalPagar+","+this.fecha+","+this.tipo;
    }
}
