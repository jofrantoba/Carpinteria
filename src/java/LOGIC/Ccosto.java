/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

import BEAN.Costo;
import DAO.MovCosto;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WORK
 */
public class Ccosto {

    public static boolean registrar(String descripcion) {
        String desc = descripcion;
        ArrayList param = new ArrayList();
        param.add(desc);
        return MovCosto.registrarCosto(param);
    }

    public static boolean modificar(int id, String descripcion) {
        ArrayList param = new ArrayList();
        param.add(id);
        param.add(descripcion);
        return MovCosto.modificarCosto(param);
    }

    public static boolean eliminar(int id) {
        ArrayList param = new ArrayList();
        param.add(id);
        return MovCosto.eliminarCosto(param);
    }

    public static Object[][] listando() {
        ResultSet rs = MovCosto.listarCosto();
        if (rs == null) {
            return null;
        } else {
            int num = MovCosto.numRegistros();
            Object[][] objeto = new Object[num][2];
            int cont = 0;
            try {
                rs.beforeFirst();
                while (rs.next()) {
                    objeto[cont][0] = rs.getInt(1);
                    objeto[cont][1] = rs.getString(2);
                    cont++;
                }
            } catch (Exception e) {
                objeto = null;
            }
            return objeto;
        }
    }

    public static Object[] listarObjeto() {
        ResultSet rs = MovCosto.listarCosto();
        if (rs == null) {
            return null;
        } else {
            int num = MovCosto.numRegistros();
            Object[] objeto = new Object[num];
            int cont = 0;
            try {
                rs.beforeFirst();
                while (rs.next()) {
                    Costo c = new Costo();
                    c.setIdcosto(rs.getInt(1));
                    c.setDescripcion(rs.getString(2));
                    objeto[cont]=c;
                    cont++;
                }
            } catch (Exception e) {
                objeto = null;
            }
            return objeto;
        }
    }

    public static ArrayList listar() {
        ResultSet rs = MovCosto.listarCosto();
        if (rs == null) {
            return null;
        } else {
            ArrayList<Costo> lista = new ArrayList();
            try {
                rs.beforeFirst();
                while (rs.next()) {
                    Costo c = new Costo();
                    c.setIdcosto(rs.getInt(1));
                    c.setDescripcion(rs.getString(2));
                    lista.add(c);
                }
                return lista;
            } catch (Exception e) {
                return null;
            }
        }
    }
}
