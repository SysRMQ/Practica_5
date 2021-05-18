
package com.emergentes.dao;

import com.emergentes.modelo.Blog;
import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BlogDAOimpl extends ConexionDB implements BlogDAO {
    

    @Override
    public void insert(Blog blog) throws Exception {
        try {
            this.conectar();
            String sql = "insert into posts (fecha, titulo, contenido) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from posts where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Blog blog) throws Exception {
        try {
            this.conectar();
            String sql = "update posts set fecha= ?, titulo= ?, contenido = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.setInt(4, blog.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Blog getById(int id) throws Exception {
        Blog pro = new Blog();
        try {
            this.conectar();
            String sql = "  select * from posts where id = ? limit 1";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaDate = "";
            
            if(rs.next())
            {
                fechaDate = formato.format(rs.getDate("fecha"));
                pro.setId(rs.getInt("id"));
                pro.setFecha(fechaDate);
                pro.setTitulo(rs.getString("titulo"));
                pro.setContenido(rs.getString("contenido"));            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Blog> getAll() throws Exception {
        List<Blog> lista = null;
         try {

            this.conectar();
            String sql = "select * from posts order by fecha desc";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaDate = "";
            lista = new ArrayList<Blog>();
            while(rs.next())
            {
                fechaDate = formato.format(rs.getDate("fecha"));
                Blog pro = new Blog();
                pro.setId(rs.getInt("id"));
                pro.setFecha(fechaDate);
                pro.setTitulo(rs.getString("titulo"));
                pro.setContenido(rs.getString("contenido"));                
                lista.add(pro);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
         return lista;
    }

    @Override
    public boolean validarUsuario(Usuario usuario) throws Exception {
        try{
            this.conectar();
            String sql = "SELECT usuario, password FROM usuarios WHERE usuario=? and password=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.absolute(1)){
                return true;
            }
        }catch (Exception e){
            throw e;
        }finally{
            
        }
        return false;
    }
}
