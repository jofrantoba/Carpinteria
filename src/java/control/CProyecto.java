/*
  * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;



import BEAN.Proyecto;
import LOGIC.Cproyecto;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author WORK
 */
@WebServlet(urlPatterns={"/CProyecto.new", "/CProyecto.edit", "/CProyecto.update","/CProyecto.eliminar"})
public class CProyecto extends HttpServlet {
   
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
            String nombre=request.getParameter("proy");            
            String fecha=request.getParameter("fecha");
            BigDecimal costo=null;
            try{
            costo=BigDecimal.valueOf(Double.parseDouble(request.getParameter("monto")));
            costo=costo.setScale(2,BigDecimal.ROUND_HALF_UP);
            }catch(Exception e){
                request.setAttribute("mensaje", "ERROR AL REGISTRAR");
                request.getRequestDispatcher("/proyecto.jsp").forward(request, response);
            }
            boolean registrar = Cproyecto.registrar(nombre, fecha, costo);
            if(registrar){
                request.setAttribute("mensaje", "REGISTRADO CORRECTAMENTE");
                request.getRequestDispatcher("/proyecto.jsp").forward(request, response);
            }else{
                request.setAttribute("mensaje", "ERROR AL REGISTRAR");
                request.getRequestDispatcher("/proyecto.jsp").forward(request, response);
            }
        }
        if(url.equals("/"+this.getClass().getSimpleName()+".update")){            
            String nombre=request.getParameter("proy");
            String fecha=request.getParameter("fecha");
            BigDecimal costo=null;
            int id=0;
            try{
            costo=BigDecimal.valueOf(Double.parseDouble(request.getParameter("monto")));
            costo=costo.setScale(2,BigDecimal.ROUND_HALF_UP);
            id=Integer.parseInt(request.getParameter("id"));
            }catch(Exception e){
                request.setAttribute("mensaje", "ERROR AL MODIFICAR");
                request.getRequestDispatcher("/proyecto.jsp").forward(request, response);
            }
            boolean modificar = Cproyecto.modificar(id,nombre, fecha, costo);
            if(modificar){
                request.setAttribute("mensaje", "MODIFICADO CORRECTAMENTE");
                request.getRequestDispatcher("/proyecto.jsp").forward(request, response);
            }else{
                request.setAttribute("mensaje", "ERROR AL MODIFICAR");
                request.getRequestDispatcher("/proyecto.jsp").forward(request, response);
            }
        }
        if(url.equals("/"+this.getClass().getSimpleName()+".eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            boolean eliminar=Cproyecto.eliminar(id);
            if(eliminar){
                request.setAttribute("mensaje", "ELIMINADO CORRECTAMENTE");
                request.getRequestDispatcher("/proyecto.jsp").forward(request, response);
            }else{
                request.setAttribute("mensaje", "ERROR AL ELIMINAR");
                request.getRequestDispatcher("/proyecto.jsp").forward(request, response);
            }
        }
        if(url.equals("/"+this.getClass().getSimpleName()+".edit")){            
            request.setAttribute("id",request.getParameter("id"));
            request.setAttribute("desc",request.getParameter("desc"));
            request.setAttribute("fech",request.getParameter("fech"));
            request.setAttribute("cant", request.getParameter("cant"));
            request.setAttribute("valor", "edit");
            request.getRequestDispatcher("/proyecto.jsp").forward(request, response);
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
