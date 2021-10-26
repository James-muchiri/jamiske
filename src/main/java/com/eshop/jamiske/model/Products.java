package com.eshop.jamiske.model;

import javax.persistence.*;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "photo", nullable = false)
    private String photo;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "original_price", nullable = false)
    private Integer original_price;
    @Column(name = "is_hidden", nullable = false)
    private String is_hidden;
    private  Integer dicount;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
       this.price = price;
    }
    public Integer getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(int original_price) {
        this.original_price = original_price;
    }
    public String getIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(String is_hidden) {
        this.is_hidden = is_hidden;
    }

    public Integer getDicount() {
        return dicount;
    }

    public void setDicount(int price, int original_price) {
        this.dicount = ((price - original_price) / original_price) * 100;
    }






}
