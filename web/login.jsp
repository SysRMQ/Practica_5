
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1 align="center">LOGIN USUARIOS</h1>
        <form action="AutenticarLogin" method="post">
            <table align="center">
            <tr>
                <td>Usuario</td>
            <td><input type="text" name="usuario"/><td/>
            </tr>
            <tr>
                <td>Password</td>
            <td><input type="password" name="pass"/><td/>
            </tr>
            <tr>
                <td></td><br>
            <td><input type="submit" value="Ingresar"/><td/>
            </tr>
            </table>
        </form>
    </body>
</html>
