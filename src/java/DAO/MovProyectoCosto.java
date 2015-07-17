/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WORK
 */
public class MovProyectoCosto {
    
    public static boolean registrarPC(ArrayList param){
        String proc="call registrarpc(?,?,?,?)";
        boolean estado = Consultas.listaSQLConParametros(proc,param);
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
    public static boolean modificarPC(ArrayList param){
        String proc="call modificarpc(?,?,?)";
        boolean estado= Consultas.listaSQLConParametros(proc,param);
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
    public static boolean eliminarPC(ArrayList param){
        String proc="call eliminarpc(?)";        
        boolean estado = Consultas.listaSQLConParametros(proc,param);
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
    public static ResultSet listarPC(ArrayList param){
        String proc="call listarpc(?)";
        return Consultas.listarSQLConParametros(proc,param);
    }
    public static int numRegistros(){
        int num=0;
        String proc="call numregpc()";
        ResultSet rs=Consultas.listarSQLSinParametros(proc);
        try{
        rs.beforeFirst();
        while(rs.next()){
            num=rs.getInt(1);
        }
        }catch(Exception e){
         num=0;
        }
        return num;
    }
}
