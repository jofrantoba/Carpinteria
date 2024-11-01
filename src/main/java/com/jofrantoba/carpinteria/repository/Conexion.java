/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jofrantoba.carpinteria.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author JOFRANTOBA
 */
@Log4j2
public class Conexion {
    private Connection cnx;
    private String ipHost;
    private String puerto;
    private String baseDatos;
    private String usuario;
    private String clave;
    private String cadenaConexion;
    private String administradorBD;
    private String driver;   
    
    public Conexion(String ipHost, String puerto, String baseDatos, String usuario, String clave, String administradorBD){
        this.ipHost = ipHost;
        this.puerto = puerto;
        this.baseDatos = baseDatos;
        this.usuario = usuario;
        this.clave = clave;
        if (administradorBD.equals("SQL")) {
            this.administradorBD = administradorBD;
            this.cadenaConexion = "jdbc:sqlserver://" + ipHost + ":" + puerto + ";DatabaseName=" + baseDatos;
            this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            log.info("GESTOR DE BASE DE DATOS SQL SERVER");
        } else if (administradorBD.equals("ORACLE")) {
            this.administradorBD = administradorBD;
            this.cadenaConexion = "jdbc:oracle:thin:@" + ipHost + ":" + puerto + ":" + baseDatos;
            this.driver = "oracle.jdbc.OracleDriver";
            log.info("GESTOR DE BASE DE DATOS ORACLE");
        } else if (administradorBD.equals("MYSQL")) {
            this.administradorBD = administradorBD;
            this.cadenaConexion = "jdbc:mysql://" + ipHost + ":" + puerto + "/" + baseDatos;
            this.driver = "com.mysql.cj.jdbc.Driver";
            log.info("GESTOR DE BASE DE DATOS MYSQL");
        }
    }
    
    public boolean conectarBD() {
        boolean conectado = false;
        try {
            Class.forName(driver);
            cnx = DriverManager.getConnection(cadenaConexion, usuario, clave);
            cnx.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            cnx.setAutoCommit(false);
            conectado = true;
            log.info("CONECTADO CORRECTAMENTE");
        } catch (SQLException | ClassNotFoundException ex) {
            log.error("ERROR AL CONECTAR:{}",ex.getMessage());
        }
        return conectado;
    }

    public boolean destroy() {
        boolean cerrado = false;
        try {
            cnx.close();
            cerrado = true;
            log.info("CONEXION CERRADA");
        } catch (SQLException ex) {
            log.error("ERROR AL CERRAR CONEXION:{}",ex.getMessage());
        }
        return cerrado;
    }

    public boolean commit(){
        boolean confirmar = false;
        try {
            cnx.commit();
            confirmar = true;
            log.info("TRANSACCION CONFIRMADA");
        } catch (SQLException ex) {
            log.error("ERRO AL CONFIRMAR TRANSACCION : {}" ,ex.getMessage());
        }
        return confirmar;
    }

    public boolean rollback() {
        boolean reset = false;
        try {
            cnx.rollback();
            reset = true;
            log.info("ROLLBACK CONFIRMADO");
        } catch (SQLException ex) {
            log.error("ERROR AL HACER ROLLBACK : {}",ex.getMessage());
        }
        return reset;
    }
    
    public Connection getCnx(){
        return this.cnx;
    }
}
