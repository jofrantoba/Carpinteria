/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import BEAN.Costo;
import BEAN.ProyectoCosto;
import LOGIC.Ccosto;
import LOGIC.Cproyectocosto;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WORK
 */
@WebServlet(urlPatterns={"/PC.ver", "/PC.eliminar", "/PC.new"})
public class PC extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=request.getServletPath();
        if(url.equals("/"+this.getClass().getSimpleName()+".ver")){
            listar(request,response);
        }
        if(url.equals("/"+this.getClass().getSimpleName()+".eliminar")){
            int id=Integer.parseInt(request.getParameter("idpc"));
            boolean eliminar=Cproyectocosto.eliminar(id);
            if(eliminar){
                HttpSession session=request.getSession(true);
                request.setAttribute("mensaje", "ELIMINADO CORRECTAMENTE");
                                ArrayList<ProyectoCosto> listapc=Cproyectocosto.listar(Integer.parseInt(session.getAttribute("idproyecto").toString()));
            request.setAttribute("pc", listapc);
            ArrayList<Costo> listacosto=Ccosto.listar();
            for(int i=0;i<listapc.size();i++){
                for(int j=0;j<listacosto.size();j++){
                    if(listacosto.get(j).getIdcosto()==listapc.get(i).getCosto().getIdcosto()){
                        listacosto.remove(j);
                    }
                }
            }
            request.setAttribute("listacosto", listacosto);
            request.getRequestDispatcher("/cotizar.jsp").forward(request, response);
            }else{
                HttpSession session=request.getSession(true);
                request.setAttribute("mensaje", "ERROR AL ELIMINAR");
                ArrayList<ProyectoCosto> listapc=Cproyectocosto.listar(Integer.parseInt(session.getAttribute("idproyecto").toString()));
            request.setAttribute("pc", listapc);
            ArrayList<Costo> listacosto=Ccosto.listar();
            for(int i=0;i<listapc.size();i++){
                for(int j=0;j<listacosto.size();j++){
                    if(listacosto.get(j).getIdcosto()==listapc.get(i).getCosto().getIdcosto()){
                        listacosto.remove(j);
                    }
                }
            }
            request.setAttribute("listacosto", listacosto);
            request.getRequestDispatcher("/cotizar.jsp").forward(request, response);
            }
        }
        if(url.equals("/"+this.getClass().getSimpleName()+".new")){            
            int idproyecto=Integer.parseInt(request.getParameter("idproyecto"));
            int idcosto=Integer.parseInt(request.getParameter("idcosto"));
            BigDecimal preciounitario=null;
            BigDecimal cantidad=null;
            try{            
            cantidad=BigDecimal.valueOf(Double.parseDouble(request.getParameter("cantidad")));
            cantidad=cantidad.setScale(2,BigDecimal.ROUND_HALF_UP);
            preciounitario=BigDecimal.valueOf(Double.parseDouble(request.getParameter("precio")));
            preciounitario=preciounitario.setScale(2,BigDecimal.ROUND_HALF_UP);
            }catch(Exception e){
                HttpSession session=request.getSession(true);
                request.setAttribute("mensaje", "ERROR AL REGISTRAR");
                ArrayList<ProyectoCosto> listapc=Cproyectocosto.listar(Integer.parseInt(session.getAttribute("idproyecto").toString()));
            request.setAttribute("pc", listapc);
            ArrayList<Costo> listacosto=Ccosto.listar();
            for(int i=0;i<listapc.size();i++){
                for(int j=0;j<listacosto.size();j++){
                    if(listacosto.get(j).getIdcosto()==listapc.get(i).getCosto().getIdcosto()){
                        listacosto.remove(j);
                    }
                }
            }
            request.setAttribute("listacosto", listacosto);
            request.getRequestDispatcher("/cotizar.jsp").forward(request, response);
            }
            boolean registrar = Cproyectocosto.registrar(idproyecto, idcosto, preciounitario,cantidad);
            if(registrar){
                request.setAttribute("mensaje", "REGISTRADO CORRECTAMENTE");
                HttpSession session=request.getSession(true);
                ArrayList<ProyectoCosto> listapc=Cproyectocosto.listar(Integer.parseInt(session.getAttribute("idproyecto").toString()));
            request.setAttribute("pc", listapc);
            ArrayList<Costo> listacosto=Ccosto.listar();
            for(int i=0;i<listapc.size();i++){
                for(int j=0;j<listacosto.size();j++){
                    if(listacosto.get(j).getIdcosto()==listapc.get(i).getCosto().getIdcosto()){
                        listacosto.remove(j);
                    }
                }
            }
            request.setAttribute("listacosto", listacosto);
            request.getRequestDispatcher("/cotizar.jsp").forward(request, response);
            }else{
                request.setAttribute("mensaje", "ERROR AL REGISTRAR");
                HttpSession session=request.getSession(true);
                ArrayList<ProyectoCosto> listapc=Cproyectocosto.listar(Integer.parseInt(session.getAttribute("idproyecto").toString()));
            request.setAttribute("pc", listapc);
            ArrayList<Costo> listacosto=Ccosto.listar();
            for(int i=0;i<listapc.size();i++){
                for(int j=0;j<listacosto.size();j++){
                    if(listacosto.get(j).getIdcosto()==listapc.get(i).getCosto().getIdcosto()){
                        listacosto.remove(j);
                    }
                }
            }
            request.setAttribute("listacosto", listacosto);
            request.getRequestDispatcher("/cotizar.jsp").forward(request, response);
            }
        }
    } 
    private void listar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            HttpSession session=request.getSession(true);
            session.setAttribute("idproyecto", request.getParameter("id"));
            session.setAttribute("proyecto", request.getParameter("desc"));                          
            ArrayList<ProyectoCosto> listapc=Cproyectocosto.listar(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("pc", listapc);
            ArrayList<Costo> listacosto=Ccosto.listar();
            for(int i=0;i<listapc.size();i++){
                for(int j=0;j<listacosto.size();j++){
                    if(listacosto.get(j).getIdcosto()==listapc.get(i).getCosto().getIdcosto()){
                        listacosto.remove(j);
                    }
                }
            } 
            request.setAttribute("listacosto", listacosto);
            request.getRequestDispatcher("/cotizar.jsp").forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
