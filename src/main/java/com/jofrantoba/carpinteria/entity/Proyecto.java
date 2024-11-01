/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jofrantoba.carpinteria.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author JOFRANTOBA
 */
@Data
public class Proyecto implements Serializable{
    private  int idProyectoCosto;
    private Costo costo;
    private Proyecto proyecto;
    private BigDecimal monto;
    private BigDecimal cantidad;
}
