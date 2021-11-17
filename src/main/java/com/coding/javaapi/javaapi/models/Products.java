package com.coding.javaapi.javaapi.models;

import java.util.Date;

public class Products {
    private Long id;
    private String type;
    private int rating;
    private String name;
    private Date createdAt;
    private int categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String lastname) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(String firstname) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCratedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
