package com.clerodri.mypizzastore;

import java.io.Serializable;

public class Bebida implements Serializable {
    private String name;
    private String message;
    private int imgId;
    private double price;

    public Bebida(String name, String message, int imgId, double price) {
        this.name = name;
        this.message = message;
        this.imgId = imgId;
        this.price = price;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
