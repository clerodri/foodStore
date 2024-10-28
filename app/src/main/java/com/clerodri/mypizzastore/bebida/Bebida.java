package com.clerodri.mypizzastore.bebida;

public class Bebida {
    private String nombre;
    private String descripcion;
    private int imagenId;

    public Bebida(String nombre, String descripcion, int imagenId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
