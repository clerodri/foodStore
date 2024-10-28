package com.clerodri.mypizzastore.comida;

import java.io.Serializable;

public class Comida implements Serializable {
    private String nombre;
    private String descripcion;
    private int imagenId;
    private double price;

    //metodo constructor
    public Comida(String nombre, String descripcion, int imagenId,double price) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //getter and setter
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

    @Override
    public String toString() {
        return nombre;
    }
}
