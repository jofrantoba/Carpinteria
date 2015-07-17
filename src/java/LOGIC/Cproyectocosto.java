/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LOGIC;

import BEAN.Costo;
import BEAN.Proyecto;
import BEAN.ProyectoCosto;
import DAO.MovProyectoCosto;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WORK
 */
public class Cproyectocosto {
public static boolean registrar(int idproyecto,int idcosto,BigDecimal valor,BigDecimal cantidad){
        ArrayList param=new ArrayList();
        param.add(idproyecto);
        param.add(idcosto);
        param.add(valor);
        param.add(cantidad);
        return MovProyectoCosto.registrarPC(param);
    }
    public static boolean modificar(int idproyecto,int idcosto,BigDecimal valor){
        ArrayList param=new ArrayList();
        param.add(idproyecto);
        param.add(idcosto);
        param.add(valor);
        return MovProyectoCosto.modificarPC(param);
    }
    public static boolean eliminar(int idpc){
        ArrayList param=new ArrayList();
        param.add(idpc);
        return MovProyectoCosto.eliminarPC(param);
    }
    public static Object[][] listando(int idproyecto){
        ArrayList param=new ArrayList();
        param.add(idproyecto);
        ResultSet rs=MovProyectoCosto.listarPC(param);
        int num=MovProyectoCosto.numRegistros();
        Object[][] objeto=new Object[num][3];
        int cont=0;
        try{
        rs.beforeFirst();
        while(rs.next()){
            objeto[cont][0]=rs.getInt(1);
            objeto[cont][1]=rs.getString(2);
            objeto[cont][2]=rs.getBigDecimal(3);
            cont++;
        }
        }catch(Exception e){
            objeto=null;
        }
        return objeto;
    }
    public static ArrayList<ProyectoCosto> listar(int idproyecto) {
        ArrayList param=new ArrayList();
        param.add(idproyecto);
        ResultSet rs=MovProyectoCosto.listarPC(param);
        if (rs == null) {
            return null;
        } else {
            ArrayList<ProyectoCosto> lista = new ArrayList();
            try {
                rs.beforeFirst();
                while (rs.next()) {
                    Proyecto p = new Proyecto();
                    p.setIdproyecto(rs.getInt(1));
                    p.setDescripcion(rs.getString(2));
                    p.setFecha(rs.getString(3));
                    p.setCantidad(rs.getBigDecimal(4));
                    Costo c=new Costo();
                    c.setIdcosto(rs.getInt(5));
                    c.setDescripcion(rs.getString(6));
                    ProyectoCosto pc=new ProyectoCosto();
                    pc.setCosto(c);
                    pc.setProyecto(p);
                    pc.setIdpc(rs.getInt(7));
                    pc.setMonto(rs.getBigDecimal(8));
                    pc.setCantidad(rs.getBigDecimal(9));
                    lista.add(pc);
                }
                return lista;
            } catch (Exception e) {
                return null;
            }
        }
    }
}
