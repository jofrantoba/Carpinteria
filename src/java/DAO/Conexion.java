/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author JONATHAN
 */
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

    public Conexion(String ipHost, String puerto, String baseDatos, String usuario, String clave, String administradorBD) {
        this.ipHost = ipHost;
        this.puerto = puerto;
        this.baseDatos = baseDatos;
        this.usuario = usuario;
        this.clave = clave;
        if (administradorBD.equals("SQL")) {
            this.administradorBD = administradorBD;
            this.cadenaConexion = "jdbc:sqlserver://" + ipHost + ":" + puerto + ";DatabaseName=" + baseDatos;
            this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            System.out.println("GESTOR DE BASE DE DATOS SQL SERVER");
        } else if (administradorBD.equals("ORACLE")) {
            this.administradorBD = administradorBD;
            this.cadenaConexion = "jdbc:oracle:thin:@" + ipHost + ":" + puerto + ":" + baseDatos;
            this.driver = "oracle.jdbc.OracleDriver";
            System.out.println("GESTOR DE BASE DE DATOS ORACLE");
        } else if (administradorBD.equals("MYSQL")) {
            this.administradorBD = administradorBD;
            this.cadenaConexion = "jdbc:mysql://" + ipHost + ":" + puerto + "/" + baseDatos;
            this.driver = "com.mysql.jdbc.Driver";
            System.out.println("GESTOR DE BASE DE DATOS MYSQL");
        }
    }

    public boolean conectarBD() {
        boolean conectado = false;
        try {
            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(cadenaConexion, usuario, clave);
            cnx.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            cnx.setAutoCommit(false);
            conectado = true;
            System.out.print("CONECTADO CORRECTAMENTE");
        } catch (Exception ex) {
            System.out.println("ERROR AL CONECTAR:" + ex.getCause());
        }
        return conectado;
    }

    public boolean destroy() throws SQLException {
        boolean cerrado = false;
        try {
            cnx.close();
            cerrado = true;
            System.out.print("CONEXION CERRADA");
        } catch (SQLException ex) {
            System.out.print("ERROR AL CERRAR CONEXION: " + ex.getCause());
        }
        return cerrado;
    }

    public boolean commit() throws SQLException {
        boolean confirmar = false;
        try {
            cnx.commit();
            confirmar = true;
            System.out.print("TRANSACCION CONFIRMADA");
        } catch (SQLException ex) {
            System.out.print("ERRO AL CONFIRMAR TRANSACCION : " + ex.getCause());
        }
        return confirmar;
    }

    public boolean rollback() throws SQLException {
        boolean reset = false;
        try {
            cnx.rollback();
            reset = true;
            System.out.print("ROLLBACK CONFIRMADO");
        } catch (SQLException ex) {
            System.out.print("ERROR AL HACER ROLLBACK" + ex.getCause());
        }
        return reset;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getAdministradorBD() {
        return administradorBD;
    }

    public void setAdministradorBD(String administradorBD) {
        this.administradorBD = administradorBD;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getCadenaConexion() {
        return cadenaConexion;
    }

    public void setCadenaConexion(String cadenaConexion) {
        this.cadenaConexion = cadenaConexion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public String getIpHost() {
        return ipHost;
    }

    public void setIpHost(String ipHost) {
        this.ipHost = ipHost;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
