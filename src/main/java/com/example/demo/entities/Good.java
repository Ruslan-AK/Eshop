package com.example.demo.entities;

import java.math.BigDecimal;

public class Good {
    private Long id;
    private GoodType type;
    private String description;
    private BigDecimal price;

    public Good(Long id, GoodType type, String description, BigDecimal price) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GoodType getType() {
        return type;
    }

    public void setType(GoodType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public enum GoodType {
        ELECTRONIC,FOOD,CLOTHES,ACCESSORIES
    }
}
