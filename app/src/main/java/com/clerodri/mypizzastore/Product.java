package com.clerodri.mypizzastore;

import java.io.Serializable;

public class Product  implements Serializable {

    private String name;
    private String message;
    private int imgId;
    private double price;
    private ProductType productType;

    public Product(String name, String message, int imgId, double price, ProductType productType) {
        this.name = name;
        this.message = message;
        this.imgId = imgId;
        this.price = price;
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
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
