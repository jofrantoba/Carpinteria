<%-- 
    Document   : registrar
    Created on : 30/10/2010, 07:44:46 PM
    Author     : WORK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carpinteria Cristo Rey</title>
    </head>
    <body>
        <form method="post" action="PC.new">
            <table width="30%" >
                <input type="hidden" name="idproyecto" value="${param['idproyecto']}" />
                <input type="hidden" name="idcosto" value="${param['idcosto']}" />
            <tr bgcolor="#FF9900" >
                <th>CANTIDAD</th>
                <th>COSTO</th>
                <th>PRECIO UNITARIO</th>
            </tr>
            <tr bgcolor="#7A9BD3">
                <td><input type="text" name="cantidad" value=""/></td>
                <td>${param['desc']}</td>
                <td><input type="text" name="precio" value=""/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="ok" value="Registrar"/></td>
                <td></td>
            </tr>
        </table>
            </form>
    </body>
</html>
