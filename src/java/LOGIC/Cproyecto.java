/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

import BEAN.Proyecto;
import DAO.MovProyecto;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WORK
 */
public class Cproyecto {

    public static boolean registrar(String descripcion, String fecha,BigDecimal cantidad) {
        ArrayList param = new ArrayList();
        param.add(descripcion);
        param.add(fecha);
        param.add(cantidad);
        return MovProyecto.registrarProyecto(param);
    }

    public static boolean modificar(int id, String descripcion, String fecha, BigDecimal cantidad) {
        ArrayList param = new ArrayList();
        param.add(id);
        param.add(descripcion);
        param.add(fecha);
        param.add(cantidad);
        return MovProyecto.modificarProyecto(param);
    }

    public static boolean eliminar(int id) {
        ArrayList param = new ArrayList();
        param.add(id);
        return MovProyecto.eliminarProyecto(param);
    }

    public static Object[][] listando() {
        ResultSet rs = MovProyecto.listarProyecto();
        if (rs == null) {
            return null;
        } else {
            int num = MovProyecto.numRegistros();
            Object[][] objeto = new Object[num][4];
            int cont = 0;
            try {
                rs.beforeFirst();
                while (rs.next()) {
                    objeto[cont][0] = rs.getInt(1);
                    objeto[cont][1] = rs.getString(2);
                    objeto[cont][2] = rs.getString(3);
                    objeto[cont][3] = rs.getBigDecimal(4);
                    cont++;
                }
            } catch (Exception e) {
                objeto = null;
            }
            return objeto;
        }
    }

    public static Object[] listarObjeto() {
        ResultSet rs = MovProyecto.listarProyecto();
        if (rs == null) {
            return null;
        } else {
            int num = MovProyecto.numRegistros();
            Object[] objeto = new Object[num];
            int cont = 0;
            try {
                rs.beforeFirst();
                while (rs.next()) {
                    Proyecto p = new Proyecto();
                    p.setIdproyecto(rs.getInt(1));
                    p.setDescripcion(rs.getString(2));
                    p.setFecha(rs.getString(3));
                    p.setCantidad(rs.getBigDecimal(4));
                    objeto[cont]=p;
                    cont++;
                }
            } catch (Exception e) {
                objeto = null;
            }
            return objeto;
        }
    }

    public static ArrayList<Proyecto> listar() {
        ResultSet rs = MovProyecto.listarProyecto();
        if (rs == null) {
            return null;
        } else {
            ArrayList<Proyecto> lista = new ArrayList();
            try {
                rs.beforeFirst();
                while (rs.next()) {
                    Proyecto p = new Proyecto();
                    p.setIdproyecto(rs.getInt(1));
                    p.setDescripcion(rs.getString(2));
                    p.setFecha(rs.getString(3));
                    p.setCantidad(rs.getBigDecimal(4));
                    lista.add(p);
                }
                return lista;
            } catch (Exception e) {
                return null;
            }
        }
    }
}
