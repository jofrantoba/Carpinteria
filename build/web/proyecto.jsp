<%--
    Document   : index
    Created on : Oct 16, 2010, 12:31:04 PM
    Author     : ADMIN
--%>

<%@page import="LOGIC.Cproyecto"%>
<%@page import="BEAN.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="proy" class="BEAN.Proyecto"></jsp:useBean>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="fecha" class="java.util.Date"></jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
        <meta http-equiv="pragma" content="no-cache">
        <META HTTP-EQUIV="Expires" CONTENT="0">
        <title>Carpinteria Cristo Rey</title>
        <SCRIPT type="text/javascript" src="java/calendarDateInput.js"></SCRIPT><STYLE>
            td.calendarDateInput {letter-spacing:normal;line-height:normal;font-family:Tahoma,Sans-Serif;font-size:11px;}
            select.calendarDateInput {letter-spacing:.06em;font-family:Verdana,Sans-Serif;font-size:11px;}
            input.calendarDateInput {letter-spacing:.06em;font-family:Verdana,Sans-Serif;font-size:11px;}
        </STYLE>
        <script type="text/javascript" src="Script/modalbox/lib/prototype.js"></script>
        <script type="text/javascript" src="Script/modalbox/lib/scriptaculous.js?¬load=builder,effects"></script>
        <script type="text/javascript" src="Script/modalbox/modalbox.js"></script>
        <link rel="stylesheet" href="Script/modalbox/modalbox.css" type="text/css" media="screen" />
        <SCRIPT type="text/javascript" src="java/calendar/calendar.js"></SCRIPT>
        <SCRIPT type="text/javascript" src="java/calendar/calendar-setup.js"></SCRIPT>
        <SCRIPT type="text/javascript" src="java/calendar/calendar-es.js"></SCRIPT>
        <script type="text/javascript" src="java/utils.js"></script>
        <STYLE type="text/css">@import url("java/calendar/calendar-win2k-cold-1.css");</STYLE>
        <LINK href="js/calendar/calendar-win2k-cold-1.css" type="text/css" rel="stylesheet">
        <script language="javascript" src="java/timepicker/mootools.v1.11.js"></script>
        <script language="javascript" src="java/timepicker/nogray_time_picker_min.js"></script>
        <LINK rel="stylesheet" type="text/css" href="css/estilo.css">
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
        <h1>CREACION DE PROYECTOS</h1>
        <fieldset>
            <legend>Crear Proyecto</legend>
            <table>
                <form method="post" action="CProyecto.<%if (accion.equals("edit")) {
                                out.print("update");
                            } else {
                                out.print("new");
                            }%>">
                            <input type="hidden" name="id" value="<c:out value="${id}"></c:out>" readonly/>
                    <tr>
                        <td>Nombre del Proyecto</td>
                        <td><input type="text" name="proy" value="<c:out value="${desc}"></c:out>"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Fecha de Creacion</td>
                        <td><input type="text" name="fecha" id="fecha" value="<c:choose><c:when test="${id!=null}">${fech}</c:when><c:otherwise><fmt:formatDate value="${fecha}" pattern="yyyy-MM-dd"></fmt:formatDate></c:otherwise></c:choose>" readonly/></td>
                        <td><a><IMG src="img/calendar.jpg" alt="Pulse para ver el Calendario" class="Bienvenidos" id="cal-button-1" border="0"></a>
                            <SCRIPT type="text/javascript">
                                Calendar.setup({
                                    inputField    : "fecha", button : "cal-button-1", align : "Tr" });
                            </SCRIPT></td>
                    </tr>
                    <tr>
                        <td>Costo Total del Proyecto</td>
                        <td><input type="text" name="monto" value="${cant}"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="ok" value="CREAR" /></td>
                        <td></td>
                    </tr>
                </form>
            </table>
        </fieldset>
        <fieldset>
            <table>
                <legend>Buscar Proyecto</legend>
                <tr>
                    <td>Nombre:<input type="text" name="buscarNombre" id="buscarNombre" class="caja_texto" value="" onkeyup="Modalbox.Methods.buscar('buscarNombre', 0)"/></td>
                    <td>Fecha:<input type="text" name="buscarFecha" id="buscarFecha" class="caja_texto" value="" onkeyup="Modalbox.buscar('buscarFecha', 1)"/></td>
                </tr>
            </table>
        </fieldset>
        <table id="TABLA" width="100%" >
            <tr bgcolor="#FF9900" >
                <th>NOMBRE DEL PROYECTO</th>
                <th>FECHA DE CREACION</th>
                <th>MONTO</th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <% ArrayList<Proyecto> proyecto = Cproyecto.listar();
                        Iterator iterar = proyecto.iterator();
                        while (iterar.hasNext()) {
                            proy = (Proyecto) iterar.next();
            %>
            <tr bgcolor="#7A9BD3">
                <td><%=proy.getDescripcion()%></td>
                <td><%=proy.getFecha()%></td>
                <td><%=proy.getCantidad()%></td>
                <td><a href="RepCotizar.pdf?idproyecto=<%=proy.getIdproyecto()%>" onclick="" ><img src="img/calendar.jpg" alt="reporte" height="30" width="30" title="reporte" ></a></td>
                <td><a href="PC.ver?id=<%=proy.getIdproyecto()%>&desc=<%=proy.getDescripcion()%>" onclick="" ><img src="img/cotizar.jpg" alt="cotizar" height="30" width="30" title="cotizar" ></a></td>
                <td><a href="CProyecto.edit?id=<%=proy.getIdproyecto()%>&desc=<%=proy.getDescripcion()%>&fech=<%=proy.getFecha()%>&cant=<%=proy.getCantidad()%>" onclick=""><img src="img/editar.png" alt="editar" height="30" width="30" title="editar" ></a></td>
                <td><a href="CProyecto.eliminar?id=<%=proy.getIdproyecto()%>" onlclick=""><img src="img/eliminar.png" alt="eliminar" height="30" width="30" title="eliminar"></a></td>
            </tr>
            <% }%>
        </table>
<DIV id=interior_i>
</DIV>
</DIV>
</DIV>
    </body>
</html>
