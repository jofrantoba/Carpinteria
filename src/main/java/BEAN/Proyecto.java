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
public class Proyecto {

    private int idproyecto;
    private String descripcion;
    private String fecha;
    private BigDecimal cantidad;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }
}
