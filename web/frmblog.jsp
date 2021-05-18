<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${aviso.id == 0}">Nuevo</c:if>
            <c:if test="${aviso.id != 0}">Editar</c:if>
            Aviso
        </h1>
        <form action="Inicio" method="POST">
            <table>
               <input type="hidden" name="id" value="${aviso.id}" />
            <tr>
                <td>Titu</td>
                <td><input type="text" name="fecha" value="${aviso.fecha}" /></td>
            </tr>
            <tr>
                <td>Titulo</td>
                <td><input type="text" name="titulo" value="${aviso.titulo}" /></td>
            </tr>
            <tr>
                <td>Contenido</td>
                <td><textarea name="contenido" rows="4" cols="20">${aviso.contenido}</textarea></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Agregar"> </td>
            </tr>
            </table>
               
        </form>
            
    </body>
</html>
