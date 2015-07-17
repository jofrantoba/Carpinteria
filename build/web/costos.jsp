<%-- 
    Document   : costos
    Created on : Oct 16, 2010, 12:44:24 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="LOGIC.Ccosto"%>
<%@page import="BEAN.Costo"%>
<jsp:useBean id="costo" class="BEAN.Costo"></jsp:useBean>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="Script/modalbox/lib/prototype.js"></script>
        <script type="text/javascript" src="Script/modalbox/lib/scriptaculous.js?¬load=builder,effects"></script>
        <script type="text/javascript" src="Script/modalbox/modalbox.js"></script>
        <link rel="stylesheet" href="Script/modalbox/modalbox.css" type="text/css" media="screen" />
        <LINK rel="stylesheet" type="text/css" href="css/estilo.css">
        <title>Carpinteria Cristo Rey</title>
    </head>
    <body>
        <DIV id=contenedor_cabecera>
<DIV id=cabecera><A title="Carpintería Cristo Rey" href="index.jsp"><IMG alt="Carpintería Cristo Rey" src="img/carpinteriapaco_logo.jpg" width=80 height=90></A>
<DIV id=menu_superior>
<DIV id=enlace_grupo><A class=enlace_grupo title="Cristo Rey" href=""></A></DIV>| <A accessKey=N title="Carpintería Cristo Rey" href="index.jsp">Carpintería Paco</A> | <A accessKey=R title="Carpintería Cristo Rey - Proyectos" href="proyecto.jsp">Proyectos</A> | <A accessKey=S title="Carpintería Cristo Rey - Costos" href="costos.jsp">Costos</A> | <A accessKey=C title="Carpintería Cristo rey - Productos" href="">Productos</A> | <A accessKey=P title="Carpintería Cristo Rey - Galeria" href="">Galería</A> | <A accessKey=O title="Carpintería Cristo Rey - Contacto" href="">Contactenos</A> | </DIV></DIV></DIV>
<DIV id=contenedor_contenido>
<DIV id=contenido_carpinteria>
        <%! String accion = "";%>
        <c:out value="${mensaje}"></c:out>
        <% accion=String.valueOf(request.getAttribute("valor")); %>
        <h1>CREAR COSTOS</h1>
        <fieldset>
            <legend>Crear costos</legend>
            <form method="post" action="CCosto.<%if (accion.equals("edit")) {
                                out.print("update");
                            } else {
                                out.print("new");
                            }%>">
                <table>
                    <input type="hidden" name="id" value="<c:out value="${id}"></c:out>" readonly/>
                    <tr>
                        <td><label>Nombre del costo</label></td>
                        <td><input type="text" name="costo" value="<c:out value="${desc}"></c:out>"/></td>
                    </tr>                    
                    <tr>
                        <td></td>
                        <td><input type="submit" name="ok" value="CREAR" /></td>
                    </tr>
                </table>
            </form>
        </fieldset>
        <fieldset>
            <table>
                <legend>Buscar Costos</legend>
                <tr>
                    <td>Costo:<input type="text" name="buscarNombre" id="buscarNombre" class="caja_texto" value="" onkeyup="Modalbox.Methods.buscar('buscarNombre', 0)"/></td>
                </tr>
            </table>
        </fieldset>
        <table id="TABLA" width="100%" >
            <tr bgcolor="#FF9900" >
                <th>NOMBRE DEL COSTO</th>                
                <th></th>
                <th></th>
            </tr>
            <% ArrayList<Costo> proyecto = Ccosto.listar();
                        Iterator iterar = proyecto.iterator();
                        while (iterar.hasNext()) {
                            costo = (Costo) iterar.next();
            %>
            <tr bgcolor="#7A9BD3">
                <td><%=costo.getDescripcion()%></td>
                <td><a href="CCosto.edit?id=<%=costo.getIdcosto()%>&desc=<%=costo.getDescripcion()%>" onclick=""><img src="img/editar.png" alt="editar" height="30" width="30" title="editar" ></a></td>
                <td><a href="CCosto.eliminar?id=<%=costo.getIdcosto()%>" onlclick=""><img src="img/eliminar.png" alt="eliminar" height="30" width="30" title="eliminar"></a></td>
            </tr>
            <% }%>
        </table>
        <DIV id=interior_i>
</DIV>
</DIV>
</DIV>
    </body>
</html>
