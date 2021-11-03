package com.eshop.jamiske.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cart implements Serializable {
    private int id;
    private String name;
    private String image;
    private Integer price;
    private int quantity;

    public Cart() {
    }

    public Cart(int id, String name, Integer price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getId() == ((Cart) obj).getId();
    }

    public void ToCart(Products book) {
        this.id = book.getId();
        this.name = book.getName();
        this.price = book.getPrice();
        this.quantity = 1;
    }

    public void toProduct(Products book) {
        this.id = book.getId();
        this.name = book.getName();
        this.price = book.getPrice();
        this.quantity = 1;
        this.image = book.getPhoto();
    }

}
