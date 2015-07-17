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
public class MovProyecto {    
    public static boolean registrarProyecto(ArrayList param) {
        String proc = "call registrarproyecto(?,?,?)";
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

    public static boolean modificarProyecto(ArrayList param) {
        String proc = "call modificarproyecto(?,?,?,?)";
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

    public static boolean eliminarProyecto(ArrayList param) {
        String proc = "call eliminarproyecto(?)";
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

    public static ResultSet listarProyecto() {
        String proc = "call listarproyecto()";
        return Consultas.listarSQLSinParametros(proc);
    }

    public static int numRegistros() {
        int num = 0;
        String proc = "call numregproy()";
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
