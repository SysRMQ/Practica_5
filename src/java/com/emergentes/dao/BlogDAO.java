
package com.emergentes.dao;

import com.emergentes.modelo.Blog;
import com.emergentes.modelo.Usuario;
import java.util.List;

public interface BlogDAO {
    public void insert(Blog blog)throws Exception;
    public void delete(int id)throws Exception;
    public void update(Blog blog)throws Exception;
    public Blog getById (int id)throws Exception;
    public List<Blog> getAll () throws Exception;
    public boolean validarUsuario (Usuario usuario) throws Exception;
}
