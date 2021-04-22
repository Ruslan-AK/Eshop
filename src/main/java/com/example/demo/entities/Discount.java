package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Discount {
    private Long id;
    private BigDecimal value;
    private Date expDate;
    private Boolean used;

    public Discount(Long id, BigDecimal value, Date expDate, Boolean used) {
        this.id = id;
        this.value = value;
        this.expDate = expDate;
        this.used = used;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
}
