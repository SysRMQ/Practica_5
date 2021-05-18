/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.dao.BlogDAO;
import com.emergentes.dao.BlogDAOimpl;
import com.emergentes.modelo.Blog;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {   
                BlogDAO dao = new BlogDAOimpl();
              
               int id;
               Usuario usu =new Usuario();
               Blog pro = new Blog();
                String accion = (request.getParameter("accion")!= null) ? request.getParameter("accion") : "view";
                switch (accion){
                    case "nuevo": 
                        request.setAttribute("aviso", pro);
                        request.getRequestDispatcher("frmblog.jsp").forward(request, response);
                    break;
                    case "editar": 
                            id = Integer.parseInt(request.getParameter("id"));
                            pro = dao.getById(id);
                            request.setAttribute("aviso", pro);
                            request.getRequestDispatcher("frmblog.jsp").forward(request, response);
                    break;
                    case "eliminar": 
                            id = Integer.parseInt(request.getParameter("id"));
                            dao.delete(id);
                            response.sendRedirect(request.getContextPath()+"/Inicio");                            
                    break;
                    case "view":
                        List<Blog> lista = dao.getAll();
                        request.setAttribute("avisos", lista);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    default:
                    break;           
                }                    
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());;
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BlogDAO dao = new BlogDAOimpl();
        String fechaDate = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        Blog pro = new Blog();
        pro.setId(id);
        pro.setFecha(fechaDate);
        pro.setTitulo(titulo);
        pro.setContenido(contenido);
        if (id == 0 )
        {         
            try {
                dao.insert(pro);
                response.sendRedirect(request.getContextPath()+"/Inicio");
            } catch (Exception ex) {
                System.out.println("error "+ex.getMessage());;
            }            
        }
        else 
        {
            try {
                dao.update(pro);
                response.sendRedirect(request.getContextPath()+"/Inicio");
            } catch (Exception ex) {
                System.out.println("error "+ex.getMessage());;
            }
        }
    }

}
