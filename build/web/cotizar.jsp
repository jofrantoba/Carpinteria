<%-- 
    Document   : cotizar
    Created on : Oct 16, 2010, 12:49:08 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>COTIZANDO</h1><br>
        <h2><label>NOMBRE DEL PROYECTO: </label><c:out value="${proyecto}"></c:out></h2>
        <fieldset>
            <legend>costos del proyecto</legend>
            <c:out value="${mensaje}"></c:out>
        <table width="100%">
            <tr bgcolor="#FF9900">
                <th>CANTIDAD</th>
                <th>COSTO</th>
                <th>PRECIO UNITARIO</th>
                <th></th>
            </tr>
            <c:forEach var="objeto" items="${pc}">
            <tr bgcolor="#7A9BD3">
                <td>${objeto.cantidad}</td>
                <td>${objeto.costo.descripcion}</td>
                <td>${objeto.monto}</td>
                <td><a href="PC.eliminar?idpc=<c:out value="${objeto.idpc}"/>" onlclick=""><img src="img/eliminar.png" alt="eliminar" height="30" width="30" title="eliminar"></a></td>
            </tr>
            </c:forEach>
        </table>
        <br>
            </fieldset>
        <fieldset>
            <legend>costos</legend>            
            <fieldset>
            <table>
                <legend>Buscar Costos</legend>
                <tr>
                    <td>Costo:<input type="text" name="buscarNombre" id="buscarNombre" class="caja_texto" value="" onkeyup="Modalbox.Methods.buscar('buscarNombre', 0)"/></td>
                </tr>
            </table>
            </fieldset>
            <br/>
            <table id="TABLA" width="100%">
            <tr bgcolor="#FF9900">
                <th>COSTO</th>
                <th></th>
            </tr>
            <c:forEach var="costo" items="${listacosto}">
            <tr bgcolor="#7A9BD3">
                <td>${costo.descripcion}</td>
                <td><a href="javascript:;" onclick="Modalbox.show('registrar.jsp?idproyecto=${idproyecto}&idcosto=${costo.idcosto}&desc=${costo.descripcion}',{title:'Agregar costo',width: 900,height:150,loadingString:'Cargando ventana de registro de Datos', closeString:'Cerrar Ventana'});return false;"><img src="img/agregar.jpg" alt="agregar costo" height="30" width="30" title="agregar"></a></td>
            </tr>
            </c:forEach>
        </table>
            </fieldset>
        <DIV id=interior_i>
</DIV>
</DIV>
</DIV>
    </body>
</html>