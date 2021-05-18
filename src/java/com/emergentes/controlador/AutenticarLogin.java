/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.dao.BlogDAO;
import com.emergentes.dao.BlogDAOimpl;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PCC
 */
@WebServlet(name = "AutenticarLogin", urlPatterns = {"/AutenticarLogin"})
public class AutenticarLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String usuario = request.getParameter("usuario");
            String pass = String.valueOf(request.getParameter("pass"));
            Usuario pro = new Usuario();
            pro.setUsuario(usuario);
            pro.setPassword(pass);
        try {
            BlogDAO dao = new BlogDAOimpl();
            if (dao.validarUsuario(pro))
            {
                request.setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath()+"/Inicio");
            }
            else
            {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger("error"+ex.getMessage());
        }
    }
}
