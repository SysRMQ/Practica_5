<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p align="right"><a href="login.jsp">salir</a></p>
        <h1 align="center">Blog de Salud</h1>
        
        <p><a href="Inicio?accion=nuevo">Nueva entrada</a></p>
        <table width="100%" style="border-collapse: collapse">
            <c:forEach var="item" items="${avisos}">
                <tr>
                    <td>${item.fecha}</td>
                    <td></td>
                </tr>  
                <tr>
                    <td><strong>${item.titulo}</strong></td>
                    <td></td>
                </tr>
                <tr>
                    <td>${item.contenido}</td>
                    <td></td>
                </tr>
                <tr style="border-bottom: 1pt solid black">
                    <td>Autor:</td>
                    <td align="right"><a href="Inicio?accion=editar&id=${item.id}">Editar</a>
                    <a href="Inicio?accion=eliminar&id=${item.id}" onclick="return(confirm('Esta Seguro'))">Eliminar</a></td>
                </tr>
                
            </c:forEach>
        </table>
    </body>
</html>
