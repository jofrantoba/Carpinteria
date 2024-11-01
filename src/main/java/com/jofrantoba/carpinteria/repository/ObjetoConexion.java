/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jofrantoba.carpinteria.repository;

import java.sql.Connection;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author JOFRANTOBA
 */
@Log4j2
public class ObjetoConexion {

    private static Conexion sql;
    private static Conexion mysql;
    private static Conexion oracle;

    public static Conexion getMysql() {
        return mysql;
    }

    public static Conexion getOracle() {
        return oracle;
    }

    public static Conexion getSql() {
        return sql;
    }

    public static Connection conectarSQL() {
        try {
            sql = new Conexion("127.0.0.1", "1433", "dbia", "sa", "", "SQL");
            boolean estado = sql.conectarBD();
            if (estado) {
                log.info("CONECTADO CORRECTAMENTE");
                return sql.getCnx();
            } else {
                log.error("ERROR AL CONECTAR");                
                return null;
            }
        } catch (Exception ex) {
            log.error("ERROR AL CONECTAR: {}",ex.getCause());            
            return null;
        }
    }

    public static Connection conectarMYSQL() {
        try {
            mysql = new Conexion("localhost", "3306", "cristorey", "root", "J0fr4nt0b4", "MYSQL");
            boolean estado = mysql.conectarBD();
            if (estado) {
                log.info("CONECTADO CORRECTAMENTE");                
                return mysql.getCnx();
            } else {
                log.error("ERROR AL CONECTAR");                
                return null;
            }
        } catch (Exception ex) {
            log.error("ERROR AL CONECTAR: {}",ex.getCause());            
            return null;
        }
    }

    public static Connection conectarORACLE() {
        try {
            oracle = new Conexion("127.0.0.1", "1521", "xe", "sys", "oracle", "ORACLE");
            boolean estado = oracle.conectarBD();
            if (estado) {
                log.info("CONECTADO CORRECTAMENTE");                
                return oracle.getCnx();
            } else {
                log.error("ERROR AL CONECTAR");                
                return null;
            }
        } catch (Exception ex) {
            log.error("ERROR AL CONECTAR: {}",ex.getCause());            
            return null;
        }
    }
}
