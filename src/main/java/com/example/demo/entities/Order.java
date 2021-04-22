package com.example.demo.entities;

import java.util.List;

public class Order {
    private Long id;
    private List<Good> goods;
    private Customer customer;

    public Order(Long id, List<Good> goods, Customer customer) {
        this.id = id;
        this.goods = goods;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
