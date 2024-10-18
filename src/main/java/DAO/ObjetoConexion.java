/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

/**
 *
 * @author JONATHAN
 */
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
            sql = new Conexion("127.0.0.1","1433","dbia","sa","","SQL");
            boolean estado=sql.conectarBD();
            if(estado){
            System.out.println("CONECTADO CORRECTAMENTE");
            return sql.getCnx();
            }else{
            System.out.println("ERROR AL CONECTAR");
                return null;
            }
        } catch (Exception ex) {
            System.out.println("ERROR AL CONECTAR: "+ex.getCause());
            return null;
        }
    }
    public static Connection conectarMYSQL() {
        try {
            mysql = new Conexion("localhost", "3306", "cristorey", "root", "J0fr4nt0b4", "MYSQL");
            boolean estado=mysql.conectarBD();
            if(estado){
            System.out.println("CONECTADO CORRECTAMENTE");
            return mysql.getCnx();
            }else{
            System.out.println("ERROR AL CONECTAR");
                return null;
            }
        } catch (Exception ex) {
            System.out.println("ERROR AL CONECTAR: "+ex.getCause());
            return null;
        }
    }
    public static Connection conectarORACLE() {
        try {
            oracle = new Conexion("127.0.0.1", "1521", "xe", "sys", "oracle", "ORACLE");
            boolean estado=oracle.conectarBD();
            if(estado){
            System.out.println("CONECTADO CORRECTAMENTE");
            return oracle.getCnx();
            }else{
            System.out.println("ERROR AL CONECTAR");
                return null;
            }
        } catch (Exception ex) {
            System.out.println("ERROR AL CONECTAR: "+ex.getCause());
            return null;
        }
    }
}
