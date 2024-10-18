/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author JONATHAN
 */
public class Consultas {

    static Connection cnx = ObjetoConexion.conectarMYSQL();

    public static ResultSet listarSQLSinParametros(String procedimientoAlmacenado) {
        CallableStatement cst;
        ResultSet rs = null;
        try {
            cst = cnx.prepareCall(procedimientoAlmacenado);
            rs = cst.executeQuery();
            cnx.commit();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return rs;
    }

    public static ResultSet listarSQLConParametros(String procedimientoAlmacenado, ArrayList parametros) {
        CallableStatement cst;
        ResultSet rs = null;
        try {
            cst = cnx.prepareCall(procedimientoAlmacenado);
            if (numeroParametros(procedimientoAlmacenado) == parametros.size()) {
                for (int i = 0; i < parametros.size(); i++) {
                    if (obtenerTipo(parametros.get(i)).equals("java.lang.Integer")) {
                        int param = Integer.parseInt(String.valueOf(parametros.get(i)));
                        cst.setInt(i + 1, param);
                    } else if (obtenerTipo(parametros.get(i)).equals("java.lang.String")) {
                        String param = String.valueOf(parametros.get(i));
                        cst.setString(i + 1, param);
                    } else if (obtenerTipo(parametros.get(i)).equals("java.lang.Double")) {
                        double param = Double.parseDouble(String.valueOf(parametros.get(i)));
                        cst.setDouble(i + 1, param);
                    } else if (obtenerTipo(parametros.get(i)).equals("java.lang.Float")) {
                        float param = Float.parseFloat(String.valueOf(parametros.get(i)));
                        cst.setFloat(i + 1, param);
                    } else if (obtenerTipo(parametros.get(i)).equals("java.math.BigDecimal")) {
                        BigDecimal param = BigDecimal.valueOf(Double.parseDouble(String.valueOf(parametros.get(i))));
                        cst.setBigDecimal(i + 1, param);
                    }
                }
                rs = cst.executeQuery();
                cnx.commit();
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return rs;
    }

    public static boolean listaSQLConParametros(String procedimientoAlmacenado, ArrayList parametros) {
        CallableStatement cst;
        boolean estado = false;
        try {
            cst = cnx.prepareCall(procedimientoAlmacenado);
            if (numeroParametros(procedimientoAlmacenado) == parametros.size()) {
                for (int i = 0; i < parametros.size(); i++) {
                    if (obtenerTipo(parametros.get(i)).equals("java.lang.Integer")) {
                        int param = Integer.parseInt(String.valueOf(parametros.get(i)));
                        cst.setInt(i + 1, param);
                    } else if (obtenerTipo(parametros.get(i)).equals("java.lang.String")) {
                        String param = String.valueOf(parametros.get(i));
                        cst.setString(i + 1, param);
                    } else if (obtenerTipo(parametros.get(i)).equals("java.lang.Double")) {
                        double param = Double.parseDouble(String.valueOf(parametros.get(i)));
                        cst.setDouble(i + 1, param);                        
                    } else if (obtenerTipo(parametros.get(i)).equals("java.lang.Float")) {
                        float param = Float.parseFloat(String.valueOf(parametros.get(i)));
                        cst.setFloat(i + 1, param);
                    } else if (obtenerTipo(parametros.get(i)).equals("java.math.BigDecimal")) {                        
                        BigDecimal param = (BigDecimal)parametros.get(i);                                                                        
                        cst.setBigDecimal(i+1, param);
                    }
                }
                cst.executeUpdate();
                estado = true;
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return estado;
    }

    public static int numeroParametros(String consulta) {
        int contador = 0;
        for (int i = 0; i < consulta.length(); i++) {
            if (String.valueOf(consulta.charAt(i)).equals("?")) {
                contador = contador + 1;
            }
        }
        return contador;
    }

    public static String obtenerTipo(Object parametro) {
        return parametro.getClass().getName();
    }
}