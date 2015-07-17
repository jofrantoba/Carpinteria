/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WORK
 */
public class MovCosto {

    public static boolean registrarCosto(ArrayList param) {
        String proc = "call registrarcosto(?)";
        boolean estado = Consultas.listaSQLConParametros(proc, param);
        if (estado) {
            try {
                return ObjetoConexion.getMysql().commit();
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getCause());
                return false;
            }
        } else {
            return estado;
        }
    }

    public static boolean modificarCosto(ArrayList param) {
        String proc = "call modificarcosto(?,?)";
        boolean estado = Consultas.listaSQLConParametros(proc, param);
        if (estado) {
            try {
                return ObjetoConexion.getMysql().commit();
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getCause());
                return false;
            }
        } else {
            return estado;
        }
    }

    public static boolean eliminarCosto(ArrayList param) {
        String proc = "call eliminarcosto(?)";
        boolean estado = Consultas.listaSQLConParametros(proc, param);
        if (estado) {
            try {
                return ObjetoConexion.getMysql().commit();
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getCause());
                return false;
            }
        } else {
            return estado;
        }
    }

    public static ResultSet listarCosto() {
        String proc = "call listarcosto()";
        return Consultas.listarSQLSinParametros(proc);
    }

    public static int numRegistros() {
        int num = 0;
        String proc = "call numregcosto()";
        ResultSet rs = Consultas.listarSQLSinParametros(proc);
        try {
            rs.beforeFirst();
            while (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {
            num = 0;
        }
        return num;
    }
}
