/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import java.math.BigDecimal;

/**
 *
 * @author WORK
 */
public class ProyectoCosto {
    private  int idpc;
    private Costo costo;
    private Proyecto proyecto;
    private BigDecimal monto;
    private BigDecimal cantidad;

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getIdpc() {
        return idpc;
    }

    public void setIdpc(int idpc) {
        this.idpc = idpc;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Costo getCosto() {
        return costo;
    }

    public void setCosto(Costo costo) {
        this.costo = costo;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
