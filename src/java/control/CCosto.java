/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import LOGIC.Ccosto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WORK
 */
@WebServlet(urlPatterns={"/CCosto.new", "/CCosto.eliminar", "/CCosto.edit","/CCosto.update"})
public class CCosto extends HttpServlet {
   
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
        if(url.equals("/"+this.getClass().getSimpleName()+".new")){
            String nombre=request.getParameter("costo");
            boolean registrar = Ccosto.registrar(nombre);
            if(registrar){
                request.setAttribute("mensaje", "REGISTRADO CORRECTAMENTE");
                request.getRequestDispatcher("/costos.jsp").forward(request, response);
            }else{
                request.setAttribute("mensaje", "ERROR AL REGISTRAR");
                request.getRequestDispatcher("/costos.jsp").forward(request, response);
            }
        }
        if(url.equals("/"+this.getClass().getSimpleName()+".eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            boolean eliminar=Ccosto.eliminar(id);
            if(eliminar){
                request.setAttribute("mensaje", "ELIMINADO CORRECTAMENTE");
                request.getRequestDispatcher("/costos.jsp").forward(request, response);
            }else{
                request.setAttribute("mensaje", "ERROR AL ELIMINAR");
                request.getRequestDispatcher("/costos.jsp").forward(request, response);
            }
        }
        if(url.equals("/"+this.getClass().getSimpleName()+".edit")){
            request.setAttribute("id",request.getParameter("id"));
            request.setAttribute("desc",request.getParameter("desc"));
            request.setAttribute("valor", "edit");
            request.getRequestDispatcher("/costos.jsp").forward(request, response);
        }
        if(url.equals("/"+this.getClass().getSimpleName()+".update")){
            String nombre=request.getParameter("costo");
            int id=0;
            try{
            id=Integer.parseInt(request.getParameter("id"));
            }catch(Exception e){
                request.setAttribute("mensaje", "ERROR AL MODIFICAR");
                request.getRequestDispatcher("/costos.jsp").forward(request, response);
            }
            boolean modificar = Ccosto.modificar(id, nombre);
            if(modificar){
                request.setAttribute("mensaje", "MODIFICADO CORRECTAMENTE");
                request.getRequestDispatcher("/costos.jsp").forward(request, response);
            }else{
                request.setAttribute("mensaje", "ERROR AL MODIFICAR");
                request.getRequestDispatcher("/costos.jsp").forward(request, response);
            }
        }
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
