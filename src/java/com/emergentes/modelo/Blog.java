package com.emergentes.modelo;

public class Blog {
    private int id;
    private String fecha;
    private String titulo;
    private String Contenido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", fecha=" + fecha + ", titulo=" + titulo + ", Contenido=" + Contenido + '}';
    }
    
    
}
